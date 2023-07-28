package cn.edu.guet.insuranceandmove.service.impl;

import cn.edu.guet.insuranceandmove.bean.Permission;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.insuranceandmove.bean.User;
import cn.edu.guet.insuranceandmove.service.UserService;
import cn.edu.guet.insuranceandmove.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author Cloud
* @description 针对表【users(用户表)】的数据库操作Service实现
* @createDate 2023-07-28 15:54:40
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<Permission> getPermissionsByUsername(String username) {
        /**
         * 处理菜单关系
         *
         */
        // 包含了一级和二级
        List<Permission> permissionList = userMapper.getPermissionsByUsername(username);
        // 声明一个存储二级菜单的集合
        List<Permission> childPermissionList = new ArrayList<>();

        for (Permission permission:permissionList){
            if (permission.getParentPermissionId()!=0){
                childPermissionList.add(permission);
            }
        }
        /**
         * 集合运算
         */
        // 去除二级菜单
        permissionList.removeAll(childPermissionList);

        for (Permission permission:permissionList){
            for (Permission childPermission:childPermissionList){
                if (childPermission.getParentPermissionId()==permission.getPermissionId()){
                    // 关联一级菜单和二级菜单
                    permission.getChildPermissions().add(childPermission);
                }
            }
        }

        return permissionList;
    }
}





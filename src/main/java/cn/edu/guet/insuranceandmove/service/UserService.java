package cn.edu.guet.insuranceandmove.service;

import cn.edu.guet.insuranceandmove.bean.Permission;
import cn.edu.guet.insuranceandmove.bean.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Cloud
* @description 针对表【users(用户表)】的数据库操作Service
* @createDate 2023-07-28 15:54:40
*/
public interface UserService extends IService<User> {
    List<Permission> getPermissionsByUsername(String username);
}

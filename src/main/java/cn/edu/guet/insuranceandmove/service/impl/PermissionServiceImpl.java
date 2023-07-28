package cn.edu.guet.insuranceandmove.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.insuranceandmove.bean.Permission;
import cn.edu.guet.insuranceandmove.service.PermissionService;
import cn.edu.guet.insuranceandmove.mapper.PermissionMapper;
import org.springframework.stereotype.Service;

/**
* @author Cloud
* @description 针对表【permissions(权限表)】的数据库操作Service实现
* @createDate 2023-07-28 15:55:05
*/
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission>
    implements PermissionService{

}





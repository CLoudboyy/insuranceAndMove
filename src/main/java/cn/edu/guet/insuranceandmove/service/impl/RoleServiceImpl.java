package cn.edu.guet.insuranceandmove.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.insuranceandmove.bean.Role;
import cn.edu.guet.insuranceandmove.service.RoleService;
import cn.edu.guet.insuranceandmove.mapper.RoleMapper;
import org.springframework.stereotype.Service;

/**
* @author Cloud
* @description 针对表【roles(角色表)】的数据库操作Service实现
* @createDate 2023-07-28 15:54:52
*/
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role>
    implements RoleService{

}





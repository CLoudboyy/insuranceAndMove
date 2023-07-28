package cn.edu.guet.insuranceandmove.mapper;

import cn.edu.guet.insuranceandmove.bean.Permission;
import cn.edu.guet.insuranceandmove.bean.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Cloud
* @description 针对表【users(用户表)】的数据库操作Mapper
* @createDate 2023-07-28 15:54:40
* @Entity cn.edu.guet.insuranceandmove.bean.User
*/
@Mapper
public interface UserMapper extends BaseMapper<User> {
    List<Permission> getPermissionsByUsername(String username);
}





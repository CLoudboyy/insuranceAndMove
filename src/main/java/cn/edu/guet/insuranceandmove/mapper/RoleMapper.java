package cn.edu.guet.insuranceandmove.mapper;

import cn.edu.guet.insuranceandmove.bean.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Cloud
* @description 针对表【roles(角色表)】的数据库操作Mapper
* @createDate 2023-07-28 15:54:52
* @Entity cn.edu.guet.insuranceandmove.bean.Role
*/
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}





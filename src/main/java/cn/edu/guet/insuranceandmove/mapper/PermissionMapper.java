package cn.edu.guet.insuranceandmove.mapper;

import cn.edu.guet.insuranceandmove.bean.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author Cloud
* @description 针对表【permissions(权限表)】的数据库操作Mapper
* @createDate 2023-07-28 15:55:05
* @Entity cn.edu.guet.insuranceandmove.bean.Permission
*/
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}





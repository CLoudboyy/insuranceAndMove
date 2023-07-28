package cn.edu.guet.insuranceandmove.mapper;

import cn.edu.guet.insuranceandmove.bean.InsuranceList;
import cn.edu.guet.insuranceandmove.bean.RelocationList;
import cn.edu.guet.insuranceandmove.bean.RelocationListQueryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author 楠沐
 * @description 针对表【modify_basic_info(modify_basic_info)】的数据库操作Mapper
 * @createDate 2023-07-26 17:53:27
 * @Entity cn.edu.guet.insuranceandmove.bean.RelocationList
 */
@Mapper
public interface RelocationListMapper extends BaseMapper<RelocationList> {
    List<RelocationList> searchRelocation(RelocationListQueryDTO relocationDTO);

    int selectTotalRow(RelocationListQueryDTO relocationDTO);

    int deleteRelocation(RelocationListQueryDTO id);

    List<RelocationList> getRelocationById(Long id);
}



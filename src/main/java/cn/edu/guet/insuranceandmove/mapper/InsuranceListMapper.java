package cn.edu.guet.insuranceandmove.mapper;

import cn.edu.guet.insuranceandmove.bean.InsuranceDTO;
import cn.edu.guet.insuranceandmove.bean.InsuranceList;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
* @author Cloud
* @description 针对表【t_insurance_list(保险清单表;保险清单表)】的数据库操作Mapper
* @createDate 2023-07-23 15:18:03
* @Entity cn.edu.guet.insuranceandmove.bean.InsuranceList
*/
@Mapper
public interface InsuranceListMapper extends BaseMapper<InsuranceList> {
    /**
     * 查询保险清单
     */
    List<InsuranceList> selectInsurance(InsuranceDTO insuranceDTO);

    /**
     * 查询保险清单总记录数
     */
    int selectTotalRow(InsuranceDTO insuranceDTO);
}





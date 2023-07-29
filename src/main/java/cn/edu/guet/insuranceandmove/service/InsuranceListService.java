package cn.edu.guet.insuranceandmove.service;

import cn.edu.guet.insuranceandmove.bean.InsuranceDTO;
import cn.edu.guet.insuranceandmove.bean.InsuranceList;
import cn.edu.guet.insuranceandmove.bean.InsuranceStatistics;
import cn.edu.guet.insuranceandmove.bean.Page;
import cn.edu.guet.insuranceandmove.common.ResponseData;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Cloud
* @description 针对表【t_insurance_list(保险清单表;保险清单表)】的数据库操作Service
* @createDate 2023-07-23 15:18:03
*/
public interface InsuranceListService extends IService<InsuranceList> {
    Page<InsuranceList> selectInsuranceList(InsuranceDTO insuranceDTO);

    int deleteInsuranceByIds(List<Long> idsList);

    ResponseData getInsuranceById(Long id);

    List<InsuranceStatistics> selectInsuranceStatisticsByYear(int year);

    void simpleWrite(List<Integer> idsList);

}

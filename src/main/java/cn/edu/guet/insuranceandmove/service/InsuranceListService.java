package cn.edu.guet.insuranceandmove.service;

import cn.edu.guet.insuranceandmove.bean.InsuranceDTO;
import cn.edu.guet.insuranceandmove.bean.InsuranceList;
import cn.edu.guet.insuranceandmove.bean.InsuranceStatistics;
import cn.edu.guet.insuranceandmove.bean.Page;
import cn.edu.guet.insuranceandmove.common.ResponseData;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
* @author Cloud
* @description 针对表【t_insurance_list(保险清单表;保险清单表)】的数据库操作Service
* @createDate 2023-07-23 15:18:03
*/
public interface InsuranceListService extends IService<InsuranceList> {

    /**
     * 查询保险清单
     * @param insuranceDTO
     * @return
     */
    Page<InsuranceList> selectInsuranceList(InsuranceDTO insuranceDTO);

    /**
     * 删除保险清单
     * @param idsList
     * @return
     */
    int deleteInsuranceByIds(List<Long> idsList);

    /**
     * 获取保险清单
     * @param id
     * @return
     */
    ResponseData getInsuranceById(Long id);

    /**
     * 查询保险清单汇总统计
     * @param year
     * @return
     */
    List<InsuranceStatistics> selectInsuranceStatisticsByYear(int year);

    /**
     * 导出保险清单Excel
     * @param idsList
     */
    void simpleWrite(List<Integer> idsList);

    /**
     * 导出保险清单汇总统计Excel
     * @param insuranceStatisticsList
     * @return
     */
    void exportInsuranceStatistics(List<InsuranceStatistics> insuranceStatisticsList);
}

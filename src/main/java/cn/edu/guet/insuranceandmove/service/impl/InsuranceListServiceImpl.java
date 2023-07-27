package cn.edu.guet.insuranceandmove.service.impl;

import cn.edu.guet.insuranceandmove.bean.InsuranceDTO;
import cn.edu.guet.insuranceandmove.bean.InsuranceStatistics;
import cn.edu.guet.insuranceandmove.bean.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.insuranceandmove.bean.InsuranceList;
import cn.edu.guet.insuranceandmove.service.InsuranceListService;
import cn.edu.guet.insuranceandmove.mapper.InsuranceListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author Cloud
 * @description 针对表【t_insurance_list(保险清单表;保险清单表)】的数据库操作Service实现
 * @createDate 2023-07-23 15:18:03
 */
@Service
public class InsuranceListServiceImpl extends ServiceImpl<InsuranceListMapper, InsuranceList>
        implements InsuranceListService {

    @Autowired
    private InsuranceListMapper insuranceListMapper;

    /**
     * 查询保险清单
     *
     * @param insuranceDTO
     * @return
     */
    @Override
    public Page<InsuranceList> selectInsuranceList(InsuranceDTO insuranceDTO) {

        insuranceDTO.setCurrent((insuranceDTO.getCurrent() - 1) * insuranceDTO.getSize());
        System.out.println(insuranceDTO.getCaseOccurrenceTime());
        List<InsuranceList> insuranceList = insuranceListMapper.selectInsurance(insuranceDTO);
        int totalRow = insuranceListMapper.selectTotalRow(insuranceDTO);
        int pages = 0;
        if (totalRow % insuranceDTO.getSize() == 0) {
            pages = totalRow / insuranceDTO.getSize();
        } else {
            pages = totalRow / insuranceDTO.getSize() + 1;
        }
        Page<InsuranceList> paginations = new Page<>();
        paginations.setTotal(totalRow);
        paginations.setPages(pages);
        paginations.setSize(insuranceDTO.getSize());
        paginations.setCurrent(insuranceDTO.getCurrent());
        paginations.setRecords(insuranceList);
        return paginations;
    }

    /**
     * 删除保险清单
     *
     * @param idsList
     * @return
     */
    @Override
    public int deleteInsuranceByIds(List<Long> idsList) {
        int deleteResult = insuranceListMapper.deleteBatchIds(idsList);
        if (deleteResult != 0) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public List<InsuranceStatistics> selectInsuranceStatisticsByYear(int year) {
        List<InsuranceStatistics> insuranceStatisticsList = new ArrayList<>();
        for (int i = 1; i <= 14; i++) {
            InsuranceStatistics insuranceStatistics = new InsuranceStatistics();
            insuranceStatistics.setPrefecture(i);
            insuranceStatistics.setCount(0);
            insuranceStatistics.setJanuary(0);
            insuranceStatistics.setFebruary(0);
            insuranceStatistics.setMay(0);
            insuranceStatistics.setMarch(0);
            insuranceStatistics.setApril(0);
            insuranceStatistics.setMay(0);
            insuranceStatistics.setJune(0);
            insuranceStatistics.setJuly(0);
            insuranceStatistics.setAugust(0);
            insuranceStatistics.setSeptember(0);
            insuranceStatistics.setOctober(0);
            insuranceStatistics.setNovember(0);
            insuranceStatistics.setDecember(0);
            insuranceStatistics.setTotalMoney(BigDecimal.ZERO);
            insuranceStatisticsList.add(insuranceStatistics);
        }
        QueryWrapper<InsuranceList> queryWrapper = new QueryWrapper<>();
        // 设置查询条件，筛选指定年份的数据
        queryWrapper.apply("YEAR(case_occurrence_time) = {0}", year);

        // 执行查询
        List<InsuranceList> insuranceLists = insuranceListMapper.selectList(queryWrapper);
        insuranceLists.forEach(insuranceList -> {
            Integer prefecture = insuranceList.getPrefecture();
            Date occurrenceTime = insuranceList.getCaseOccurrenceTime();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(occurrenceTime);
            // 获取项目发生的月份
            int month = calendar.get(Calendar.MONTH) + 1;

            switch (month) {
                case 1:
                    InsuranceStatistics januaryStats = insuranceStatisticsList.get(prefecture - 1);
                    januaryStats.setJanuary(januaryStats.getJanuary() + 1);
                    januaryStats.setCount(januaryStats.getCount() + 1);
                    break;
                case 2:
                    InsuranceStatistics februaryStats = insuranceStatisticsList.get(prefecture - 1);
                    februaryStats.setFebruary(februaryStats.getFebruary() + 1);
                    februaryStats.setCount(februaryStats.getCount() + 1);
                    break;
                case 3:
                    InsuranceStatistics marchStats = insuranceStatisticsList.get(prefecture - 1);
                    marchStats.setMarch(marchStats.getMarch() + 1);
                    marchStats.setCount(marchStats.getCount() + 1);
                    break;
                case 4:
                    InsuranceStatistics aprilStats = insuranceStatisticsList.get(prefecture - 1);
                    aprilStats.setApril(aprilStats.getApril() + 1);
                    aprilStats.setCount(aprilStats.getCount() + 1);
                    break;
                case 5:
                    InsuranceStatistics mayStats = insuranceStatisticsList.get(prefecture - 1);
                    mayStats.setMay(mayStats.getMay() + 1);
                    mayStats.setCount(mayStats.getCount() + 1);
                    break;
                case 6:
                    InsuranceStatistics juneStats = insuranceStatisticsList.get(prefecture - 1);
                    juneStats.setJune(juneStats.getJune() + 1);
                    juneStats.setCount(juneStats.getCount() + 1);
                    break;
                case 7:
                    InsuranceStatistics julyStats = insuranceStatisticsList.get(prefecture - 1);
                    julyStats.setJuly(julyStats.getJuly() + 1);
                    julyStats.setCount(julyStats.getCount() + 1);
                    break;
                case 8:
                    InsuranceStatistics augustStats = insuranceStatisticsList.get(prefecture - 1);
                    augustStats.setAugust(augustStats.getAugust() + 1);
                    augustStats.setCount(augustStats.getCount() + 1);
                    break;
                case 9:
                    InsuranceStatistics septemberStats = insuranceStatisticsList.get(prefecture - 1);
                    septemberStats.setSeptember(septemberStats.getSeptember() + 1);
                    septemberStats.setCount(septemberStats.getCount() + 1);
                    break;
                case 10:
                    InsuranceStatistics octoberStats = insuranceStatisticsList.get(prefecture - 1);
                    octoberStats.setOctober(octoberStats.getOctober() + 1);
                    octoberStats.setCount(octoberStats.getCount() + 1);
                    break;
                case 11:
                    InsuranceStatistics novemberStats = insuranceStatisticsList.get(prefecture - 1);
                    novemberStats.setNovember(novemberStats.getNovember() + 1);
                    novemberStats.setCount(novemberStats.getCount() + 1);
                    break;
                case 12:
                    InsuranceStatistics decemberStats = insuranceStatisticsList.get(prefecture - 1);
                    decemberStats.setDecember(decemberStats.getDecember() + 1);
                    decemberStats.setCount(decemberStats.getCount() + 1);
                    break;
                default:
                    break;
            }
        });

        System.out.println(insuranceStatisticsList);


        return insuranceStatisticsList;
    }
}





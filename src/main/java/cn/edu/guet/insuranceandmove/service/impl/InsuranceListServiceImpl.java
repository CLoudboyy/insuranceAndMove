package cn.edu.guet.insuranceandmove.service.impl;

import cn.edu.guet.insuranceandmove.bean.*;

import cn.edu.guet.insuranceandmove.common.CalculateUtil;
import cn.edu.guet.insuranceandmove.common.ResponseData;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.insuranceandmove.service.InsuranceListService;
import cn.edu.guet.insuranceandmove.mapper.InsuranceListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * 查询保险清单（id）
     *
     * @param id
     * @return
     */
    @Override
    public ResponseData getInsuranceById(Long id) {

        List<InsuranceList> insuranceListList = insuranceListMapper.getInsuranceById(id);
        System.out.println(insuranceListList);
        return ResponseData.ok(insuranceListList);
    }

    /**
     * 汇总统计保险清单
     *
     * @param year
     * @return
     */
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
            CalculateUtil.updateInsuranceStatisticsList(insuranceStatisticsList, insuranceList);
        });
        InsuranceStatistics totalStatistics = CalculateUtil.calculateInsuranceCounts(insuranceStatisticsList);
        insuranceStatisticsList.add(totalStatistics);

        return insuranceStatisticsList;
    }

    /**
     * 导出保险清单Excel
     *
     * @param idsList
     */
    @Override
    public void simpleWrite(List<Integer> idsList) {
        String fileName = "C:\\Users\\Cloud\\Desktop\\test\\" + System.currentTimeMillis() + ".xlsx";

        // 模拟获取数据,此处设定查询条件
        List<InsuranceList> insuranceLists = insuranceListMapper.selectBatchIds(idsList);

        // 将数据库数据装填到excel包装类
        List<InsuranceModel> insuranceModels = insuranceLists.stream().map(insuranceItem -> {

            InsuranceModel insuranceModel = new InsuranceModel();
            insuranceModel.setSubmitTime(new Date());
            insuranceModel.setInsuranceId(insuranceItem.getId());
            insuranceModel.setDomainName(insuranceItem.getPrefecture() + "");
            insuranceModel.setSubdomainName(insuranceItem.getCounty() + "");
            insuranceModel.setNetworkLayer(insuranceItem.getNetworkHierarchy());
            insuranceModel.setCaseOccurTime(insuranceItem.getCaseOccurrenceTime());
            insuranceModel.setCaseName(insuranceItem.getCaseName());
            insuranceModel.setCaseDetailedStatement(insuranceItem.getInsuranceContentDescription());
            insuranceModel.setCaseProgress(insuranceItem.getCaseProgressSituation());
            insuranceModel.setCaseClassificationReason(insuranceItem.getReportingReasonsType());
            insuranceModel.setSpottedInformant(insuranceItem.getCaseReporter());
            insuranceModel.setSelfMaintainResponsibility(insuranceItem.getMaintenanceManager());
            insuranceModel.setPreviewLossAmount(insuranceItem.getEstimatedLossAmount());
            insuranceModel.setPaidType(insuranceItem.getCompensationType());
            insuranceModel.setPayAccountAmount(insuranceItem.getCompensationReceivedAmount());
            insuranceModel.setPayAccountTime(insuranceItem.getCompensationReceivedTime());
            insuranceModel.setInsuranceBillRegisterName(insuranceItem.getIcLedgerRegistrationName());
            insuranceModel.setInsuranceReportNo(insuranceItem.getIcInsuranceReportNo());
            insuranceModel.setInsuranceEstimatePayAmount(insuranceItem.getIcEstimatedReparationAmount());
            insuranceModel.setPayProgress(insuranceItem.getCompensationProgress());
            insuranceModel.setPayStatusRemark(insuranceItem.getInsuranceRemarks());
            insuranceModel.setCompletionConfirmed(insuranceItem.getCaseCompletionConfirm() + "");
            insuranceModel.setInsuranceRemark(insuranceItem.getInsuranceRemarks());

            return insuranceModel;
        }).collect(Collectors.toList());

        EasyExcel.write(fileName, InsuranceModel.class).sheet("Sheet 1").doWrite(insuranceModels);
    }

    @Override
    public void exportInsuranceStatistics(List<InsuranceStatistics> insuranceStatisticsList) {
        String fileName = "C:\\Users\\Cloud\\Desktop\\test\\" + System.currentTimeMillis() + ".xlsx";
        // 将数据库数据装填到excel包装类
        List<InsuranceStatisticModel> insuranceStatisticModels = insuranceStatisticsList.stream().map(insuranceStatisticsItem -> {
            InsuranceStatisticModel insuranceStatisticModel = new InsuranceStatisticModel();
            insuranceStatisticModel.setSubmitTime(new Date());
            insuranceStatisticModel.setDomainName(insuranceStatisticsItem.getPrefecture()+"");
            insuranceStatisticModel.setCount(insuranceStatisticsItem.getCount());
            insuranceStatisticModel.setJanuary(insuranceStatisticsItem.getJanuary());
            insuranceStatisticModel.setFebruary(insuranceStatisticsItem.getFebruary());
            insuranceStatisticModel.setMarch((insuranceStatisticsItem.getMarch()));
            insuranceStatisticModel.setApril(insuranceStatisticsItem.getApril());
            insuranceStatisticModel.setMay(insuranceStatisticsItem.getMay());
            insuranceStatisticModel.setJune(insuranceStatisticsItem.getJune());
            insuranceStatisticModel.setJuly(insuranceStatisticsItem.getJuly());
            insuranceStatisticModel.setAugust(insuranceStatisticsItem.getAugust());
            insuranceStatisticModel.setSeptember(insuranceStatisticsItem.getSeptember());
            insuranceStatisticModel.setOctober(insuranceStatisticsItem.getOctober());
            insuranceStatisticModel.setNovember(insuranceStatisticsItem.getNovember());
            insuranceStatisticModel.setDecember(insuranceStatisticsItem.getDecember());
            insuranceStatisticModel.setTotalMoney(insuranceStatisticsItem.getTotalMoney());
            return insuranceStatisticModel;
        }).collect(Collectors.toList());

        EasyExcel.write(fileName, InsuranceStatisticModel.class).sheet("Sheet 1").doWrite(insuranceStatisticModels);
    }


}





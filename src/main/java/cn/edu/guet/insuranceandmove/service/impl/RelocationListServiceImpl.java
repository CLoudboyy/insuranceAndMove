package cn.edu.guet.insuranceandmove.service.impl;

import cn.edu.guet.insuranceandmove.bean.*;
import cn.edu.guet.insuranceandmove.common.CalculateUtil;
import cn.edu.guet.insuranceandmove.common.ResponseData;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.insuranceandmove.service.RelocationListService;
import cn.edu.guet.insuranceandmove.mapper.RelocationListMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 楠沐
 * @description 针对表【modify_basic_info(modify_basic_info)】的数据库操作Service实现
 * @createDate 2023-07-26 17:53:27
 */
@Service
public class RelocationListServiceImpl extends ServiceImpl<RelocationListMapper, RelocationList>
        implements RelocationListService {

    private static final int MAX_PREFECTURES = 14;

    @Autowired
    private RelocationListMapper relocationListMapper;

    /**
     * 查询迁改
     *
     * @param relocationDTO
     * @return
     */
    @Override
    public IPage<RelocationList> searchRelocation(RelocationListQueryDTO relocationDTO) {
        Page<RelocationList> page = new Page<>();
        page.setSize(relocationDTO.getSize());
        page.setCurrent(relocationDTO.getCurrent());

        QueryWrapper<RelocationList> queryWrapper = new QueryWrapper<>();
        if (relocationDTO.getPrefecture() != null && relocationDTO.getPrefecture() != 0) {
            //查询SQL中是否包含该条件，要先判断是否为空
            queryWrapper.eq("prefecture", relocationDTO.getPrefecture());
        }
        if (relocationDTO.getCounty() != null && relocationDTO.getCounty() != 0) {
            queryWrapper.eq("county", relocationDTO.getPrefecture());
        }
        if (!StringUtils.isBlank(relocationDTO.getModifyProjectName())) {
            queryWrapper.like("modify_project_name", relocationDTO.getModifyProjectName());
        }
        if (!CollectionUtils.isEmpty(relocationDTO.getActualCompletionTime())) {
            queryWrapper.between("actual_completion_time", relocationDTO.getActualCompletionTime().get(0), relocationDTO.getActualCompletionTime().get(1));
        }

        return relocationListMapper.selectPage(page, queryWrapper);
    }

    /**
     * 删除迁改清单
     *
     * @param ids
     * @return
     */
    @Override
    public ResponseData deleteRelocation(List<Long> ids) {
        int result = relocationListMapper.deleteBatchIds(ids);
        if (result != 0) {
            return ResponseData.ok("删除成功");
        } else {
            return ResponseData.fail("删除失败");
        }
    }

    /**
     * 新增迁改
     *
     * @param relocationList
     * @return
     */
    @Override
    public RelocationList createRelocationList(RelocationList relocationList) {
        relocationList.setCreateTime(new Timestamp(System.currentTimeMillis()));
        relocationList.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        int result = relocationListMapper.insert(relocationList);
        System.out.println(result);
        return null;
    }

    /**
     * 查询迁改清单
     *
     * @param id
     * @return
     */
    @Override
    public ResponseData getRelocationById(Long id) {

        List<RelocationList> relocationListList = relocationListMapper.getRelocationById(id);
        return ResponseData.ok(relocationListList);
    }

    /**
     * 导出迁改清单Excel
     *
     * @param idsList
     */
    @Override
    public void exportRelocationListExcel(List<Integer> idsList) {
        String fileName = "C:\\Users\\Cloud\\Desktop\\test\\" + System.currentTimeMillis() + ".xlsx";

        // 模拟获取数据,此处设定查询条件
        List<RelocationList> relocationLists = relocationListMapper.selectBatchIds(idsList);

        // 将数据库数据装填到excel包装类
        List<RelocationModel> relocationModels = relocationLists.stream().map(relocationItem -> {
            RelocationModel relocationModel = new RelocationModel();
            relocationModel.setSubmitTime(new Date());
            relocationModel.setPrefecture(relocationItem.getPrefecture() + "");
            relocationModel.setCounty(relocationItem.getCounty() + "");
            relocationModel.setModifyProjectName(relocationItem.getModifyProjectName());
            relocationModel.setExpectedBeginTime(relocationItem.getExpectedBeginTime());
            relocationModel.setExpectedCompletionTime(relocationItem.getExpectedCompletionTime());
            relocationModel.setEstimatedMaintainTotalCost(relocationItem.getEstimatedMaintainTotalCost());
            relocationModel.setGovernmentInterfacer(relocationItem.getGovernmentInterfacer());
            relocationModel.setGovernmentInterfacerCif(relocationItem.getGovernmentInterfacerCif());
            relocationModel.setOurInterfacer(relocationItem.getOurInterfacer());
            relocationModel.setOurInterfacerCif(relocationItem.getOurInterfacerCif());
            relocationModel.setDiscussSchedule(relocationItem.getDiscussSchedule());
            relocationModel.setActualCompletionTime(relocationItem.getActualCompletionTime());
            relocationModel.setCompensationCosts(relocationItem.getCompensationCosts());
            relocationModel.setOtherBudgetName(relocationItem.getOtherBudgetName());
            relocationModel.setOtherBudgetId(relocationItem.getOtherBudgetId());
            relocationModel.setWireMaintainCosts(relocationItem.getWireMaintainCosts());
            relocationModel.setMaintainBudgetName(relocationItem.getMaintainBudgetName());
            relocationModel.setCompensationRatio(relocationItem.getCompensationRatio());
            relocationModel.setCompensationSchedule(relocationItem.getCompensationSchedule() + "");
            return relocationModel;
        }).collect(Collectors.toList());

        EasyExcel.write(fileName, RelocationModel.class).sheet("Sheet 1").doWrite(relocationModels);
    }

    @Override
    public void exportRelocationStatistics(List<RelocationStatistics> relocationStatisticsList) {
        String fileName = "C:\\Users\\Cloud\\Desktop\\test\\" + System.currentTimeMillis() + ".xlsx";
        // 将数据库数据装填到excel包装类
        List<RelocationStatisticsModel> relocationStatisticsModels = relocationStatisticsList.stream().map(relocationStatistics -> {
            System.out.println(relocationStatistics);
            RelocationStatisticsModel relocationStatisticsModel = new RelocationStatisticsModel();
            relocationStatisticsModel.setSubmitTime(new Date());
            relocationStatisticsModel.setDomainName(relocationStatistics.getPrefecture()+"");
            relocationStatisticsModel.setCount(relocationStatistics.getCount());
            relocationStatisticsModel.setJanuary(relocationStatistics.getJanuary());
            relocationStatisticsModel.setFebruary(relocationStatistics.getFebruary());
            relocationStatisticsModel.setMarch((relocationStatistics.getMarch()));
            relocationStatisticsModel.setApril(relocationStatistics.getApril());
            relocationStatisticsModel.setMay(relocationStatistics.getMay());
            relocationStatisticsModel.setJune(relocationStatistics.getJune());
            relocationStatisticsModel.setJuly(relocationStatistics.getJuly());
            relocationStatisticsModel.setAugust(relocationStatistics.getAugust());
            relocationStatisticsModel.setSeptember(relocationStatistics.getSeptember());
            relocationStatisticsModel.setOctober(relocationStatistics.getOctober());
            relocationStatisticsModel.setNovember(relocationStatistics.getNovember());
            relocationStatisticsModel.setDecember(relocationStatistics.getDecember());
            relocationStatisticsModel.setTotalMoney(relocationStatistics.getTotalMoney());
            return relocationStatisticsModel;
        }).collect(Collectors.toList());

        EasyExcel.write(fileName, RelocationStatisticsModel.class).sheet("Sheet 1").doWrite(relocationStatisticsModels);
    }

    /**
     * 迁改清单汇总统计
     *
     * @param year
     * @return
     */
    @Override
    public List<RelocationStatistics> selectRelocationStatisticsByYear(int year) {
        List<RelocationStatistics> relocationStatisticsList = new ArrayList<>();
        for (int i = 1; i <= MAX_PREFECTURES; i++) {
            RelocationStatistics relocationStatistics = new RelocationStatistics();
            relocationStatistics.setPrefecture(i);
            relocationStatistics.setCount(0);
            relocationStatistics.setJanuary(0);
            relocationStatistics.setFebruary(0);
            relocationStatistics.setMay(0);
            relocationStatistics.setMarch(0);
            relocationStatistics.setApril(0);
            relocationStatistics.setMay(0);
            relocationStatistics.setJune(0);
            relocationStatistics.setJuly(0);
            relocationStatistics.setAugust(0);
            relocationStatistics.setSeptember(0);
            relocationStatistics.setOctober(0);
            relocationStatistics.setNovember(0);
            relocationStatistics.setDecember(0);
            relocationStatistics.setTotalMoney(BigDecimal.ZERO);
            relocationStatisticsList.add(relocationStatistics);
        }
        QueryWrapper<RelocationList> queryWrapper = new QueryWrapper<>();
        // 设置查询条件，筛选指定年份的数据
        queryWrapper.apply("YEAR(create_time) = {0}", year);

        // 执行查询
        List<RelocationList> relocationLists = relocationListMapper.selectList(queryWrapper);
        relocationLists.forEach(relocationList -> {
            CalculateUtil.updateRelocationStatisticsList(relocationStatisticsList,relocationList);
        });

        RelocationStatistics totalStatistics = CalculateUtil.calculateRelocationCounts(relocationStatisticsList);
        relocationStatisticsList.add(totalStatistics);

        return relocationStatisticsList;
    }
}



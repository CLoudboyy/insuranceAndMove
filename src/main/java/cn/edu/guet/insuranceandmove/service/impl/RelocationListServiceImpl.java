package cn.edu.guet.insuranceandmove.service.impl;

import cn.edu.guet.insuranceandmove.bean.*;
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
        System.out.println(relocationListList);
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

    /**
     * 迁改清单汇总统计
     *
     * @param year
     * @return
     */
    @Override
    public List<RelocationStatistics> selectRelocationStatisticsByYear(int year) {
        List<RelocationStatistics> relocationStatisticsList = new ArrayList<>();
        for (int i = 1; i <= 14; i++) {
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
            Integer prefecture = relocationList.getPrefecture();
            Date occurrenceTime = relocationList.getCreateTime();

            Calendar calendar = Calendar.getInstance();
            calendar.setTime(occurrenceTime);
            // 获取项目发生的月份
            int month = calendar.get(Calendar.MONTH) + 1;

            switch (month) {
                case 1:
                    RelocationStatistics januaryStats = relocationStatisticsList.get(prefecture - 1);
                    januaryStats.setJanuary(januaryStats.getJanuary() + 1);
                    januaryStats.setCount(januaryStats.getCount() + 1);
                    break;
                case 2:
                    RelocationStatistics februaryStats = relocationStatisticsList.get(prefecture - 1);
                    februaryStats.setFebruary(februaryStats.getFebruary() + 1);
                    februaryStats.setCount(februaryStats.getCount() + 1);
                    break;
                case 3:
                    RelocationStatistics marchStats = relocationStatisticsList.get(prefecture - 1);
                    marchStats.setMarch(marchStats.getMarch() + 1);
                    marchStats.setCount(marchStats.getCount() + 1);
                    break;
                case 4:
                    RelocationStatistics aprilStats = relocationStatisticsList.get(prefecture - 1);
                    aprilStats.setApril(aprilStats.getApril() + 1);
                    aprilStats.setCount(aprilStats.getCount() + 1);
                    break;
                case 5:
                    RelocationStatistics mayStats = relocationStatisticsList.get(prefecture - 1);
                    mayStats.setMay(mayStats.getMay() + 1);
                    mayStats.setCount(mayStats.getCount() + 1);
                    break;
                case 6:
                    RelocationStatistics juneStats = relocationStatisticsList.get(prefecture - 1);
                    juneStats.setJune(juneStats.getJune() + 1);
                    juneStats.setCount(juneStats.getCount() + 1);
                    break;
                case 7:
                    RelocationStatistics julyStats = relocationStatisticsList.get(prefecture - 1);
                    julyStats.setJuly(julyStats.getJuly() + 1);
                    julyStats.setCount(julyStats.getCount() + 1);
                    break;
                case 8:
                    RelocationStatistics augustStats = relocationStatisticsList.get(prefecture - 1);
                    augustStats.setAugust(augustStats.getAugust() + 1);
                    augustStats.setCount(augustStats.getCount() + 1);
                    break;
                case 9:
                    RelocationStatistics septemberStats = relocationStatisticsList.get(prefecture - 1);
                    septemberStats.setSeptember(septemberStats.getSeptember() + 1);
                    septemberStats.setCount(septemberStats.getCount() + 1);
                    break;
                case 10:
                    RelocationStatistics octoberStats = relocationStatisticsList.get(prefecture - 1);
                    octoberStats.setOctober(octoberStats.getOctober() + 1);
                    octoberStats.setCount(octoberStats.getCount() + 1);
                    break;
                case 11:
                    RelocationStatistics novemberStats = relocationStatisticsList.get(prefecture - 1);
                    novemberStats.setNovember(novemberStats.getNovember() + 1);
                    novemberStats.setCount(novemberStats.getCount() + 1);
                    break;
                case 12:
                    RelocationStatistics decemberStats = relocationStatisticsList.get(prefecture - 1);
                    decemberStats.setDecember(decemberStats.getDecember() + 1);
                    decemberStats.setCount(decemberStats.getCount() + 1);
                    break;
                default:
                    break;
            }
        });

        System.out.println(relocationStatisticsList);


        return relocationStatisticsList;
    }
}



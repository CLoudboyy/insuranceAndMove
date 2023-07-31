package cn.edu.guet.insuranceandmove.controller;

import cn.edu.guet.insuranceandmove.bean.*;
import cn.edu.guet.insuranceandmove.common.ResponseData;
import cn.edu.guet.insuranceandmove.service.RelocationListService;
;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class RelocationController {
    private static Logger logger = LoggerFactory.getLogger(RelocationListService.class);

    @Autowired
    private RelocationListService relocationListService;

    /**
     * 查询
     * @param relocationDTO
     * @return
     */
    @PostMapping("/searchRelocation")
    public ResponseData searchRelocation(@RequestBody RelocationListQueryDTO relocationDTO) {
        IPage<RelocationList> relocationIPage = relocationListService.searchRelocation(relocationDTO);
        return ResponseData.ok(relocationIPage);
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @PostMapping("/deleteRelocation")
    public ResponseData deleteRelocation(@RequestBody List<Long> ids) {
        return relocationListService.deleteRelocation(ids);
    }


    @GetMapping("/selectRelocation/{id}")
    public ResponseData getrelocationById(@PathVariable Long id) {
        return relocationListService.getRelocationById(id);
    }

    /**
     * 新增保存
     * @param relocationList
     * @return
     */
    @PostMapping("/createRelocationList")
    public ResponseData createRelocationList(@RequestBody RelocationList relocationList) {
        System.out.println(relocationList);
        relocationListService.createRelocationList(relocationList);
        return ResponseData.ok("保存成功！");
    }

    /**
     * 修改
     * @param relocationList
     * @return
     */
    @PostMapping("/modifyRelocation")
    public ResponseData modifyInsurance(@RequestBody RelocationList relocationList) {
        // 作为查询条件
        Integer id = relocationList.getId();
        UpdateWrapper<RelocationList> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id);
        relocationList.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        relocationListService.update(relocationList,updateWrapper);
        return ResponseData.ok("清单修改成功");
    }

    /**
     * 汇总统计
     * @param relocationStatisticsVO
     * @return
     */
    @PostMapping("/selectRelocationStatisticsByYear")
    public ResponseData selectRelocationStatisticsByYear(@RequestBody RelocationStatisticsVO relocationStatisticsVO){
        return ResponseData.ok(relocationListService.selectRelocationStatisticsByYear(relocationStatisticsVO.getYear()));
    }

    /**
     * 导出迁改清单Excel
     * @param idsList
     * @return
     */
    @PostMapping("/exportRelocationListExcel")
    public ResponseData exportRelocationListExcel(@RequestBody List<Integer> idsList){
        relocationListService.exportRelocationListExcel(idsList);
        return ResponseData.ok();
    }

    /**
     * 导出迁改汇总统计清单
     * @param relocationStatisticsVO
     * @return
     */
    @PostMapping("/exportRelocationStatistics")
    public ResponseData exportRelocationStatistics(@RequestBody RelocationStatisticsVO relocationStatisticsVO){
        List<RelocationStatistics> relocationStatisticsList =
                relocationListService.selectRelocationStatisticsByYear(relocationStatisticsVO.getYear());
        relocationListService.exportRelocationStatistics(relocationStatisticsList);
        return ResponseData.ok();
    }

}

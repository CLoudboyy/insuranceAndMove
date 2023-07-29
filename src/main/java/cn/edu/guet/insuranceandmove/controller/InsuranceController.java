package cn.edu.guet.insuranceandmove.controller;

import cn.edu.guet.insuranceandmove.bean.InsuranceDTO;
import cn.edu.guet.insuranceandmove.bean.InsuranceList;
import cn.edu.guet.insuranceandmove.bean.InsuranceStatisticsVO;
import cn.edu.guet.insuranceandmove.common.ResponseData;
import cn.edu.guet.insuranceandmove.service.InsuranceListService;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.springframework.web.bind.annotation.*;
import cn.edu.guet.insuranceandmove.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author huangzhouyu
 * @Data 2023/7/23 15:23
 */
@RestController
public class InsuranceController {

    private static Logger logger = LoggerFactory.getLogger(InsuranceList.class);

    @Autowired
    private InsuranceListService insuranceListService;

    @Autowired
    private UserService userService;

    /**
     * 查询保险清单
     * <p>
     * 查询保险清单（带分页）
     *
     * @param insuranceDTO
     * @return
     */
    @PostMapping("/selectInsuranceList")
    public ResponseData selectInsuranceList(@RequestBody InsuranceDTO insuranceDTO) {
        return ResponseData.ok(insuranceListService.selectInsuranceList(insuranceDTO));
    }


    /**
     * 删除保险清单
     *
     * @param idsList
     * @return
     */
    @PostMapping("/deleteInsuranceByIds")
    public ResponseData deleteInsuranceByIds(@RequestBody List<Long> idsList) {
        int deleteResult = insuranceListService.deleteInsuranceByIds(idsList);
        if (deleteResult == 1) {
            return ResponseData.ok("删除成功");
        } else {
            return ResponseData.fail("删除失败");
        }
    }

    /**
     * 新增保险
     * @param insuranceList
     * @return
     */
    @PostMapping("/saveInsurance")
    public ResponseData saveInsurance(@RequestBody InsuranceList insuranceList) {
        insuranceList.setCreateTime(new Timestamp(System.currentTimeMillis()));
        insuranceList.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        insuranceListService.save(insuranceList);
        return ResponseData.ok("保存成功");
    }

    /**
     * 查询保险（Id）
     * @param id
     * @return
     */
    @GetMapping("/selectInsurance/{id}")
    public ResponseData getInsuranceById(@PathVariable Long id) {
        return insuranceListService.getInsuranceById(id);
    }

    /**
     * 修改保险
     * @param insuranceList
     * @return
     */
    @PostMapping("/modifyInsurance")
    public ResponseData modifyInsurance(@RequestBody InsuranceList insuranceList) {
        // 作为查询条件
        Integer id = insuranceList.getId();
        UpdateWrapper<InsuranceList> updateWrapper = new UpdateWrapper<>();
        updateWrapper.eq("id",id);
        insuranceList.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        insuranceListService.update(insuranceList,updateWrapper);
        return ResponseData.ok("清单修改成功");
    }

    /**
     * 保险汇总统计
     * @param insuranceStatisticsVO
     * @return
     */
    @PostMapping("/selectInsuranceStatisticsByYear")
    public ResponseData selectInsuranceStatisticsByYear(@RequestBody InsuranceStatisticsVO insuranceStatisticsVO) {
        if (insuranceStatisticsVO.getYear() == null) {
            System.out.println("year:" + insuranceStatisticsVO.getYear());
        }
        return ResponseData.ok(insuranceListService.selectInsuranceStatisticsByYear(insuranceStatisticsVO.getYear()));
    }

    /**
     * 获取权限菜单
     * @param username
     * @return
     */
    @GetMapping("/getPermissionsByUsername")
    public ResponseData getPermissionsByUsername(String username) {
        return ResponseData.ok(userService.getPermissionsByUsername(username));
    }

    /**
     * 导出保险清单Excel
     * @param idsList
     * @return
     */
    @PostMapping("/getInsuranceListExcelById")
    public ResponseData getInsuranceListExcelById(@RequestBody List<Integer> idsList){
        System.out.println(idsList);
        insuranceListService.simpleWrite(idsList);
        return ResponseData.ok();
    }
}

package cn.edu.guet.insuranceandmove.controller;

import cn.edu.guet.insuranceandmove.bean.InsuranceDTO;
import cn.edu.guet.insuranceandmove.bean.InsuranceList;
import cn.edu.guet.insuranceandmove.common.ResponseData;
import cn.edu.guet.insuranceandmove.service.InsuranceListService;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
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

    /**

     * 查询保险清单

     * 查询保险清单（带分页）
     * @param insuranceDTO
     * @return
     */
    @PostMapping("/selectInsuranceList")
    public ResponseData selectInsuranceList(@RequestBody InsuranceDTO insuranceDTO){
        return ResponseData.ok(insuranceListService.selectInsuranceList(insuranceDTO));
    }


    /**
     * 删除保险清单
     * @param idsList
     * @return
     */
    @PostMapping("/deleteInsuranceByIds")
    public ResponseData deleteInsuranceByIds(@RequestBody List<Long> idsList){
        int deleteResult = insuranceListService.deleteInsuranceByIds(idsList);
        if (deleteResult == 1){
            return ResponseData.ok("删除成功");
        }else {
            return ResponseData.fail("删除失败");
        }
    }



    @PostMapping("/saveInsurance")
    public ResponseData saveInsurance(@RequestBody InsuranceList insuranceList) {
        insuranceList.setCreateTime(new Timestamp(System.currentTimeMillis()));
        insuranceList.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        insuranceListService.save(insuranceList);
        return ResponseData.ok("工单创建成功");
    }


    @GetMapping("/selectInsurance/{id}")
    public ResponseData getInsuranceById(@PathVariable Long id) {
        return insuranceListService.getInsuranceById(id);
    }

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

}

package cn.edu.guet.insuranceandmove.controller;

import cn.edu.guet.insuranceandmove.bean.InsuranceDTO;
import cn.edu.guet.insuranceandmove.bean.InsuranceList;
import cn.edu.guet.insuranceandmove.common.ResponseData;
import cn.edu.guet.insuranceandmove.service.InsuranceListService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author huangzhouyu
 * @Data 2023/7/23 15:23
 */
@RestController
public class InsuranceController {

    private static Logger logger = LoggerFactory.getLogger(InsuranceList.class);

    @Autowired
    private InsuranceListService insuranceListService;

    @PostMapping("/selectInsuranceList")
    public ResponseData selectInsuranceList(@RequestBody InsuranceDTO insuranceDTO){
        return ResponseData.ok(insuranceListService.selectInsuranceList(insuranceDTO));
    }
}

package cn.edu.guet.insuranceandmove.controller;

import cn.edu.guet.insuranceandmove.bean.InsuranceDTO;
import cn.edu.guet.insuranceandmove.bean.InsuranceList;
import cn.edu.guet.insuranceandmove.bean.InsuranceStatisticsVO;
import cn.edu.guet.insuranceandmove.common.ResponseData;
import cn.edu.guet.insuranceandmove.service.InsuranceListService;
import cn.edu.guet.insuranceandmove.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @PostMapping("/selectInsuranceStatisticsByYear")
    public ResponseData selectInsuranceStatisticsByYear(@RequestBody InsuranceStatisticsVO insuranceStatisticsVO) {
        if (insuranceStatisticsVO.getYear() == null) {
            System.out.println("year:" + insuranceStatisticsVO.getYear());
        }
        return ResponseData.ok(insuranceListService.selectInsuranceStatisticsByYear(insuranceStatisticsVO.getYear()));
    }

    @GetMapping("/getPermissionsByUsername")
    public ResponseData getPermissionByUsername(String username) {
        return ResponseData.ok(userService.getPermissionByUsername(username));
    }
}

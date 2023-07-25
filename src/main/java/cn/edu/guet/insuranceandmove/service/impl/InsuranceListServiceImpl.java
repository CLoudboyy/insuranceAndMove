package cn.edu.guet.insuranceandmove.service.impl;

import cn.edu.guet.insuranceandmove.bean.InsuranceDTO;
import cn.edu.guet.insuranceandmove.bean.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.edu.guet.insuranceandmove.bean.InsuranceList;
import cn.edu.guet.insuranceandmove.service.InsuranceListService;
import cn.edu.guet.insuranceandmove.mapper.InsuranceListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author Cloud
* @description 针对表【t_insurance_list(保险清单表;保险清单表)】的数据库操作Service实现
* @createDate 2023-07-23 15:18:03
*/
@Service
public class InsuranceListServiceImpl extends ServiceImpl<InsuranceListMapper, InsuranceList>
    implements InsuranceListService{

    @Autowired
    private InsuranceListMapper insuranceListMapper;

    /**
     * 查询保险清单
     * @param insuranceDTO
     * @return
     */
    @Override
    public Page<InsuranceList> selectInsuranceList(InsuranceDTO insuranceDTO) {
        insuranceDTO.setCurrent((insuranceDTO.getCurrent()-1) * insuranceDTO.getSize());
        System.out.println(insuranceDTO.getCaseOccurrenceTime());
        List<InsuranceList> insuranceList= insuranceListMapper.selectInsurance(insuranceDTO);
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
     * @param idsList
     * @return
     */
    @Override
    public int deleteInsuranceByIds(List<Long> idsList) {
        int deleteResult = insuranceListMapper.deleteBatchIds(idsList);
        if (deleteResult != 0){
            return 1;
        }else {
            return 0;
        }

    }
}





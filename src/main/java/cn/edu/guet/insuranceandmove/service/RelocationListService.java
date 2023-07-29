package cn.edu.guet.insuranceandmove.service;

import cn.edu.guet.insuranceandmove.bean.RelocationList;
import cn.edu.guet.insuranceandmove.bean.RelocationListQueryDTO;
import cn.edu.guet.insuranceandmove.bean.RelocationStatistics;
import cn.edu.guet.insuranceandmove.common.ResponseData;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author 楠沐
 * @description 针对表【modify_basic_info(modify_basic_info)】的数据库操作Service
 * @createDate 2023-07-26 17:53:27
 */
public interface RelocationListService extends IService<RelocationList> {
    IPage<RelocationList> searchRelocation(RelocationListQueryDTO relocationListQueryDTO);
    ResponseData deleteRelocation(List<Long> ids);
    RelocationList createRelocationList(RelocationList relocationList);
    List<RelocationStatistics> selectRelocationStatisticsByYear(int year);
    ResponseData getRelocationById(Long id);

    void exportRelocationListExcel(List<Integer> idsList);

    void exportRelocationStatistics(List<RelocationStatistics> relocationStatisticsList);
}

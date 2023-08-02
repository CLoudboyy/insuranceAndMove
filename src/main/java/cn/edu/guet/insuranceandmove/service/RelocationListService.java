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

    /**
     * 查询迁改清单
     * @param relocationListQueryDTO
     * @return
     */
    IPage<RelocationList> searchRelocation(RelocationListQueryDTO relocationListQueryDTO);

    /**
     * 删除迁改
     * @param ids
     * @return
     */
    ResponseData deleteRelocation(List<Long> ids);

    /**
     * 新增迁改
     * @param relocationList
     * @return
     */
    RelocationList createRelocationList(RelocationList relocationList);

    /**
     * 查询迁改汇总统计
     * @param year
     * @return
     */
    List<RelocationStatistics> selectRelocationStatisticsByYear(int year);

    /**
     * 获取迁改清单
     * @param id
     * @return
     */
    ResponseData getRelocationById(Long id);

    /**
     * 导出迁改清单Excel
     * @param idsList
     */
    void exportRelocationListExcel(List<Integer> idsList);

    /**
     * 导出迁改汇总统计Excel
     * @param relocationStatisticsList
     */
    void exportRelocationStatistics(List<RelocationStatistics> relocationStatisticsList);
}

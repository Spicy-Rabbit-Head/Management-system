package com.zzk.dao.sparePartsRelated;

import com.zzk.entity.po.sparePartsManagement.CostStatistics;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 费用转移相关数据库访问层<br>
 * <p>
 * <p>
 * 1.0版本: 费用转移相关数据库访问层构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2024-01-27 11:34
 */
@Repository
public interface CostStatisticsDao {
    /**
     * 批量添加费用记录
     */
    Integer insertCostRecordBatch(List<CostStatistics> costStatisticsList);

    /**
     * 添加费用记录
     */
    Integer insertCostRecord(CostStatistics costStatistics);
}

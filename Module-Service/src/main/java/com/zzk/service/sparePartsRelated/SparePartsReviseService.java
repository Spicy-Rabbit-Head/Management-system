package com.zzk.service.sparePartsRelated;

import com.zzk.entity.po.sparePartsManagement.CostStatistics;

import java.util.List;

/**
 * 备品更新服务层接口<br>
 * <p>
 * <p>
 * 1.0版本：备品更新服务层接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2024-01-27 13:28
 */
public interface SparePartsReviseService {
    /**
     * 添加实际费用
     *
     * @param actualCost 实际使用量
     * @return 是否添加成功
     */
    Boolean feeWritingProcess(List<CostStatistics> actualCost);
}

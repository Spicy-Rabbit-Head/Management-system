package com.zzk.service.sparePartsRelated;

import com.zzk.entity.dto.sparePartsRelated.ActualCostDTO;

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
     * 是否存在该设备
     *
     * @param deviceNumber 设备编号
     */
    Boolean isExistDevice(String deviceNumber);

    /**
     * 添加初始费用
     *
     * @param deviceNumber     设备编号
     * @param maintenanceCycle 保养周期
     */
    Boolean addInitialCost(String deviceNumber, String maintenanceCycle);

    /**
     * 添加实际费用
     *
     * @param deviceSparePartsCostList 实际使用量
     */
    Boolean addActualCost(ActualCostDTO actualCost);
}

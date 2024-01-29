package com.zzk.dao.sparePartsRelated;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

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
public interface CostTransferDao {
    /**
     * 是否存在该设备
     *
     * @param deviceNumber 设备编号
     * @return 是否存在该设备
     */
    @Select("SELECT EXISTS(SELECT 1 FROM  spare_parts_management.cost_transfer WHERE device_number = #{deviceNumber})")
    Boolean isExistDevice(String deviceNumber);

    /**
     * 添加初始费用
     *
     * @param deviceNumber     设备编号
     * @param maintenanceCycle 保养周期
     */
    Integer addInitialCost(String deviceNumber, String maintenanceCycle);

    /**
     * 添加实际费用
     *
     * @param actualQuantity 实际使用量
     * @param deviceNumber   设备编号
     * @param sparePartsName 备品名称
     */
    @Update("UPDATE spare_parts_management.cost_transfer SET actual_quantity = #{actualQuantity} WHERE device_number = #{deviceNumber} AND spare_part_name = #{sparePartsName}")
    Integer addActualCost(String actualQuantity, String deviceNumber, String sparePartsName);
}

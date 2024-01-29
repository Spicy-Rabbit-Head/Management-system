package com.zzk.dao.sparePartsRelated;

import com.zzk.entity.po.sparePartsManagement.DeviceSparePartsCost;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 备品数据访问层<br>
 * <p>
 * <p>
 * 1.0版本：备品数据访问层<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2024-01-26 14:01
 */
@Repository
public interface DeviceSparePartsCostDao {
    /**
     * 根据机台编号查询备品数据
     *
     * @param deviceNumber     机台编号
     * @param maintenanceCycle 保养周期
     * @return 备品数据
     * @since 1.0
     */
    List<DeviceSparePartsCost> selectDeviceSparePartsCostByDeviceNumber(String deviceNumber, String maintenanceCycle);
}

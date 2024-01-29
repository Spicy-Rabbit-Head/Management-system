package com.zzk.service.sparePartsRelated;

import com.zzk.entity.dto.sparePartsRelated.SparePartsInquiryDTO;
import com.zzk.entity.po.sparePartsManagement.DeviceSparePartsCost;

import java.util.List;

/**
 * 备品查询服务接口<br>
 * <p>
 * <p>
 * 1.0版本：备品查询服务接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2024-01-26 14:09
 */
public interface SparePartsQueryService {
    /**
     * 查询备品数据
     *
     * @param deviceNumber     设备编号
     * @param maintenanceCycle 保养周期
     */
    List<DeviceSparePartsCost> getSparePartsData(List<SparePartsInquiryDTO> sparePartsInquiryDTO);
}

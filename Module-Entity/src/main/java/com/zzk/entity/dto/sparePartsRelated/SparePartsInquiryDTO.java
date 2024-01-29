package com.zzk.entity.dto.sparePartsRelated;

import lombok.Data;

/**
 * 备品查询数据传输对象<br>
 */
@Data
public class SparePartsInquiryDTO {
    /**
     * 设备编号
     */
    private String deviceNumber;

    /**
     * 保养周期
     */
    private String maintenanceCycle;
}

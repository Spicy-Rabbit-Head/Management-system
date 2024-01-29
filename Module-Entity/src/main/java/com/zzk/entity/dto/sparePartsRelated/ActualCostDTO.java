package com.zzk.entity.dto.sparePartsRelated;

import lombok.Data;

/**
 * 实际费用数据传输对象<br>
 */
@Data
public class ActualCostDTO {
    // 设备编号
    private String deviceNumber;
    // 备品名称
    private String[] sparePartName;
    // 实际使用量
    private Integer[] actualQuantity;
}

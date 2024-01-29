package com.zzk.entity.po.sparePartsManagement;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 备品费用转移<br>
 * <p>
 * <p>
 * 1.0版本：备品费用转移构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2024-01-27 11:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("spare_parts_management.cost_transfer")
@ApiModel(description = "备品费用转移", value = "CostTransfer")
public class CostTransfer extends Model<CostTransfer> {
    // 设备编号
    @ApiModelProperty(value = "设备编号", name = "device_number")
    private String deviceNumber;
    // 保养周期
    @ApiModelProperty(value = "保养周期", name = "maintenance_cycle")
    private String maintenanceCycle;
    // 保养项目
    @ApiModelProperty(value = "保养项目", name = "maintenance_item")
    private String maintenanceItem;
    // 备品名称
    @ApiModelProperty(value = "备品名称", name = "spare_parts_name")
    private String sparePartsName;
    // 备品使用数量
    @ApiModelProperty(value = "备品使用数量", name = "quantity")
    private Integer quantity;
    // 价格
    @ApiModelProperty(value = "价格", name = "price")
    private Float price;
    // 总价
    @ApiModelProperty(value = "总价", name = "total_price")
    private Float totalPrice;
    // 实际使用量
    @ApiModelProperty(value = "实际使用量", name = "actual_quantity")
    private Integer actualQuantity;
    // 实际总价
    @ApiModelProperty(value = "实际总价", name = "actual_total_price")
    private Float actualTotalPrice;
}

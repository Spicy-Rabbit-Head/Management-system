package com.zzk.entity.po.sparePartsManagement;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 设备备件费用表(DeviceSparePartsCost)实体类<br>
 * <p>
 * <p>
 * 1.0版本：设备备件费用表实体类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2024-01-26 13:46
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("spare_parts_management.device_spare_parts_cost")
@ApiModel(description = "设备备件费用表", value = "DeviceSparePartsCost")
public class DeviceSparePartsCost extends Model<DeviceSparePartsCost> {
    // 设备编号
    @ApiModelProperty(value = "设备编号", name = "device_number")
    private String deviceNumber;
    // 项目名称
    @ApiModelProperty(value = "项目名称", name = "maintenance_item")
    private String maintenanceItem;
    // 项目周期
    @ApiModelProperty(value = "项目周期", name = "maintenance_cycle")
    private String maintenanceCycle;
    // 备品名称
    @ApiModelProperty(value = "备品名称", name = "spare_part_name")
    private String sparePartName;
    // 备品料号
    @ApiModelProperty(value = "备品料号", name = "part_number")
    private String partNumber;
    // 备品数量
    @ApiModelProperty(value = "备品数量", name = "quantity")
    private Integer quantity;
    // 备品单价
    @ApiModelProperty(value = "备品单价", name = "price")
    private Float price;
    // 备品总价
    @ApiModelProperty(value = "备品总价", name = "total_price")
    private Float totalPrice;
    // 备品图片
    @ApiModelProperty(value = "备品图片", name = "image")
    private String image;
}

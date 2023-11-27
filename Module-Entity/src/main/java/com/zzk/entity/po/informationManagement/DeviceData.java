package com.zzk.entity.po.informationManagement;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 设备数据(com.zzk.entity.po.informationManagement.DeviceData)实体类<br>
 * <p>
 * <p>
 * 1.0版本：设备数据实体类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-11-22 14:40
 */
@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("information_management.device_data")
@ApiModel(description = "用户表", value = "DeviceData")
public class DeviceData extends Model<DeviceData> {
    // 设备编号
    @TableId(value = "device_number")
    @ApiModelProperty(value = "设备编号", name = "device_number")
    private String deviceNumber;
    // 设备名称
    @ApiModelProperty(value = "设备名称", name = "device_name")
    private String deviceName;
    // 设备型号
    @ApiModelProperty(value = "设备型号", name = "device_model")
    private String deviceModel;
    // 制作厂商
    @ApiModelProperty(value = "制作厂商", name = "manufacturer")
    private String manufacturer;
    // 车间
    @ApiModelProperty(value = "车间", name = "workshop")
    private String workshop;
    // 站别
    @ApiModelProperty(value = "站别", name = "station")
    private String station;
    // 位置
    @ApiModelProperty(value = "位置", name = "location")
    private String location;
    // 设备状态
    @ApiModelProperty(value = "设备状态", name = "device_status")
    private String deviceStatus;
    // 是否有效
    @ApiModelProperty(value = "是否有效", name = "is_valid")
    private Boolean isValid;
    // 保养规则名
    @ApiModelProperty(value = "保养规则名", name = "rule_name")
    private String ruleName;
    // 启用日期
    @ApiModelProperty(value = "启用日期", name = "enable_date")
    private Integer enableDate;
    // 保养基准文号
    @ApiModelProperty(value = "保养基准文号", name = "benchmark_document_number")
    private String benchmarkDocumentNumber;
    // OIS文号
    @ApiModelProperty(value = "OIS文号", name = "ois_document_number")
    private String oisDocumentNumber;
    // 每日设备巡检基准
    @ApiModelProperty(value = "每日设备巡检基准", name = "device_inspection_benchmark")
    private String deviceInspectionBenchmark;
    // 变更日期
    @ApiModelProperty(value = "变更日期", name = "change_date")
    private Date changeDate;
}

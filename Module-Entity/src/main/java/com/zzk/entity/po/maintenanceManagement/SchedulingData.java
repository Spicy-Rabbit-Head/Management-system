package com.zzk.entity.po.maintenanceManagement;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@TableName("maintenance_management.scheduling_data")
@ApiModel(description = "保养排程数据", value = "SchedulingData")
public class SchedulingData extends Model<SchedulingData> {
    // 主键id
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "排程数据表主键", name = "id")
    private Integer id;
    // 车间
    @ApiModelProperty(value = "车间", name = "workshop")
    private String workshop;
    // 设备编号
    @ApiModelProperty(value = "设备编号", name = "equipment_number")
    private String equipmentNumber;
    // 设备型号
    @ApiModelProperty(value = "设备型号", name = "equipment_model_number")
    private String equipmentModelNumber;
    // 设备名称
    @ApiModelProperty(value = "设备名称", name = "equipment_name")
    private String equipmentName;
    // 保养周期
    @ApiModelProperty(value = "保养周期", name = "maintenance_cycle")
    private String maintenanceCycle;
    // 计划时间
    @ApiModelProperty(value = "计划时间", name = "plan_time")
    private LocalDate planTime;
    // 排定时间
    @ApiModelProperty(value = "排定时间", name = "scheduling_time")
    private String schedulingTime;
    // 负责人
    @ApiModelProperty(value = "负责人", name = "person_in_charge")
    private String personInCharge;
    // 成员
    @ApiModelProperty(value = "成员", name = "member")
    private String member;
    // 作业时间
    @ApiModelProperty(value = "作业时间", name = "operation_time")
    private String operationTime;
    // 排程状态
    @ApiModelProperty(value = "排程状态", name = "scheduling_status")
    private Boolean schedulingStatus;
}

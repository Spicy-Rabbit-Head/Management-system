package com.zzk.entity.po.maintenanceManagement;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 保养排程实体类
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("maintenance_management.module_scheduling")
@ApiModel(description = "保养排程数据", value = "ModuleScheduling")
public class ModuleScheduling extends Model<SchedulingData> {
    // id
    private Integer id;
    // 模组名称
    private String moduleName;

    // 模组编号
    private String moduleNumber;

    // 保养数量
    private Integer maintenanceQuantity;

    // 模组型号
    private String modelNumber;

    // 保养人员
    private String maintenancePersonnel;

    // 排定保养时间
    private String schedulingTime;
}

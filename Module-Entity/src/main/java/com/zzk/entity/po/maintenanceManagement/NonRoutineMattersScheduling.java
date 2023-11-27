package com.zzk.entity.po.maintenanceManagement;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 非例行事项排程数据
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("maintenance_management.non_routine_matters_scheduling")
@ApiModel(description = "保养排程数据", value = "NonRoutineMattersScheduling")
public class NonRoutineMattersScheduling extends Model<NonRoutineMattersScheduling> {
    // id
    private Integer id;

    // 事项名称
    private String mattersName;

    // 事项描述
    private String mattersDescription;

    // 成员
    private String member;

    // 验收佐证
    private String acceptanceEvidence;

    // 事项时间
    private String mattersTime;
}

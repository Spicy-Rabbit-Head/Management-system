package com.zzk.entity.po.maintenanceReserve;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 机台对应规则表(com.zzk.entity.po.maintenanceReserve.MachineCorrespondenceRules)实体类<br>
 * <p>
 * <p>
 * 1.0版本：机台对应规则表实体类构建<br>
 * <p>
 *
 * @author 鹿九
 * @version 1.0
 * @since 2023-02-15
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("machine_correspondence_rules")
@ApiModel(description = "机台对应规则表", value = "MachineCorrespondenceRules")
public class MachineCorrespondenceRules extends Model<MachineCorrespondenceRules> {

    @ApiModelProperty("機器名稱")
    private String machineName;

    @ApiModelProperty("機器站別")
    private String noo;

    @ApiModelProperty("機器編號")
    private String machineNum;

    @ApiModelProperty("規則")
    private String rule;

    @TableField(exist = false)
    private Rules rules;

    @Override
    public Serializable pkVal() {
        return this.machineName;
    }
}

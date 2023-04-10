package com.zzk.entity.po.maintenanceReserve;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 规则表(com.zzk.entity.po.maintenanceReserve.Rules)实体类<br>
 * <p>
 * <p>
 * 1.0版本：规则表实体类构建<br>
 * <p>
 *
 * @author 鹿九
 * @version 1.0
 * @since 2023-02-15
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("rules")
@ApiModel(description = "规则表", value = "Rules")
public class Rules extends Model<Rules> {
    @ApiModelProperty(value = "規則名称", name = "rule")
    private String rule;

    @ApiModelProperty(value = "一月", name = "january")
    private String january;

    @ApiModelProperty(value = "二月", name = "february")
    private String february;

    @ApiModelProperty(value = "三月", name = "march")
    private String march;

    @ApiModelProperty(value = "四月", name = "april")
    private String april;

    @ApiModelProperty(value = "五月", name = "may")
    private String may;

    @ApiModelProperty(value = "六月", name = "june")
    private String june;

    @ApiModelProperty(value = "七月", name = "july")
    private String july;

    @ApiModelProperty(value = "八月", name = "august")
    private String august;

    @ApiModelProperty(value = "九月", name = "september")
    private String september;

    @ApiModelProperty(value = "十月", name = "october")
    private String october;

    @ApiModelProperty(value = "十一月", name = "november")
    private String november;

    @ApiModelProperty(value = "十二月", name = "december")
    private String december;

    @Override
    public Serializable pkVal() {
        return this.rule;
    }
}

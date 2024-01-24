package com.zzk.entity.po.formManagement;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 表单结构(com.zzk.entity.po.formManagement.FormStructure)实体类<br/>
 * <p>
 * <p>
 * 1.0版本：表单结构实体类构建<br/>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2024-01-23 10:14
 */
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@TableName("form_management.form_structure")
@ApiModel(description = "表单结构", value = "FormStructure")
public class FormStructure extends Model<FormStructure> {
    // 表单编号
    @TableId(value = "id")
    @ApiModelProperty(value = "表单编号", name = "id")
    private Integer id;
    // 表单名称
    @ApiModelProperty(value = "表单名称", name = "form_name")
    private String formName;
    // 表单描述
    @ApiModelProperty(value = "表单描述", name = "form_desc")
    private String formDesc;
    // 表单类型
    @ApiModelProperty(value = "表单类型", name = "form_type")
    private String formType;
    // 表单结构
    @ApiModelProperty(value = "表单结构", name = "form_content")
    private String formContent;
}

package com.zzk.entity.po.UserPermissionsRelated;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 角色与操作权限外键表(com.zzk.entity.po.UserPermissionsRelated.RoleOperationLink)实体类<br>
 * <p>
 * <p>
 * 1.0版本：角色与操作权限外键表构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-03 13:39
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("role_operation_link")
@ApiModel(description = "角色与操作权限外键表", value = "RoleOperationLink")
public class RoleOperationLink extends Model<RoleOperationLink> {
    // 角色与操作权限表主键
    @TableId(value = "role_operation_link_id", type = IdType.AUTO)
    @ApiModelProperty(value = "角色与操作权限表主键", name = "roleOperationLinkId")
    private Integer roleOperationLinkId;
    // 角色外键
    @ApiModelProperty(value = "角色外键", name = "roleId")
    private Integer roleId;
    // 操作权限外键
    @ApiModelProperty(value = "操作权限外键", name = "operationId")
    private Integer operationId;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.roleOperationLinkId;
    }
}


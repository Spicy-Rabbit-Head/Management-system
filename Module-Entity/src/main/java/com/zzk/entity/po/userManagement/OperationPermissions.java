package com.zzk.entity.po.userManagement;

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
 * 操作权限表(com.zzk.entity.po.UserPermissionsRelated.OperationPermissions)实体类<br>
 * <p>
 * <p>
 * 1.0版本：操作权限表实体类构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-03 13:21
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("user_management.operation_permissions")
@ApiModel(description = "操作权限表", value = "OperationPermissions")
public class OperationPermissions extends Model<OperationPermissions> {
    // 操作权限表主键
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "操作权限表主键", name = "id")
    private Integer id;
    // 操作名
    @ApiModelProperty(value = "操作名", name = "operationName")
    private String operationName;
    // 权限名
    @ApiModelProperty(value = "权限名", name = "permissionName")
    private String permissionName;
    // 方法
    @ApiModelProperty(value = "方法类型", name = "methodType")
    private String methodType;
    // 地址
    @ApiModelProperty(value = "地址", name = "url")
    private String url;
    // 标识
    @ApiModelProperty(value = "标识", name = "pid")
    private Integer pid;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.id;
    }
}


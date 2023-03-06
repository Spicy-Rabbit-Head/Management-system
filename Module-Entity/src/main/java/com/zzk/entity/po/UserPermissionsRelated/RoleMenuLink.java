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
 * 角色与菜单权限外键表(com.zzk.entity.po.UserPermissionsRelated.RoleMenuLink)表实体类
 *
 * @author zhaozikui
 * @since 2023-03-03 13:39
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("role_menu_link")
@ApiModel(description = "角色与菜单权限外键表", value = "RoleMenuLink")
public class RoleMenuLink extends Model<RoleMenuLink> {
    // 角色与菜单权限外键表主键
    @TableId(value = "role_menu_link_id", type = IdType.AUTO)
    @ApiModelProperty(value = "角色与菜单权限外键表主键", name = "roleMenuLinkId")
    private Integer roleMenuLinkId;
    // 角色外键
    @ApiModelProperty(value = "角色外键", name = "roleId")
    private Integer roleId;
    // 菜单权限外键
    @ApiModelProperty(value = "菜单权限外键", name = "menuId")
    private Integer menuId;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.roleMenuLinkId;
    }
}


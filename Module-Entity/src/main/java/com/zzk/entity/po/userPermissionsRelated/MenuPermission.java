package com.zzk.entity.po.userPermissionsRelated;

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
 * 菜单权限表(com.zzk.entity.po.UserPermissionsRelated.MenuPermission)实体类<br>
 * <p>
 * <p>
 * 1.0版本：菜单权限表实体类构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-03 13:20
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("menu_permissions")
@ApiModel(description = "菜单权限表", value = "MenuPermission")
public class MenuPermission extends Model<MenuPermission> {
    // 菜单权限表主键
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "菜单权限表主键", name = "id")
    private Integer id;
    // 分组
    @ApiModelProperty(value = "分组", name = "group_name")
    private String groupName;
    // 菜单名
    @ApiModelProperty(value = "菜单名", name = "menuName")
    private String menuName;
    // 父菜单标识
    @ApiModelProperty(value = "父菜单标识", name = "parent_id")
    private Integer parentId;
    // 地址
    @ApiModelProperty(value = "地址", name = "url")
    private String path;
    // 图标
    @ApiModelProperty(value = "图标", name = "icon")
    private String icon;
    // 菜单描述
    @ApiModelProperty(value = "菜单描述", name = "menu_desc")
    private String menuDesc;

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


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
 * 菜单权限表(com.zzk.entity.po.UserPermissionsRelated.MenuPermission)表实体类<br>
 * <p>
 * <p>
 * 1.0版本：菜单权限表实体类构建<br>
 * <p>
 *
 * @author zhaozikui
 * @since 2023-03-03 13:20
 * version 1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("menu_permission")
@ApiModel(description = "菜单权限表", value = "MenuPermission")
public class MenuPermission extends Model<MenuPermission> {
    // 菜单权限表主键
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "菜单权限表主键", name = "id")
    private Integer id;
    // 菜单名
    @ApiModelProperty(value = "菜单名", name = "menuName")
    private String menuName;
    // 父菜单名
    @ApiModelProperty(value = "父菜单名", name = "parentMenuName")
    private String parentMenuName;
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


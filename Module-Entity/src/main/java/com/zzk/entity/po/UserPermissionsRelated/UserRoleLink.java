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
 * 用户与角色外键表(com.zzk.entity.po.UserPermissionsRelated.UserRoleLink)实体类<br>
 * <p>
 * <p>
 * 1.0版本：用户与角色外键表实体类构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-03 13:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("user_role_link")
@ApiModel(description = "用户与角色外键表", value = "UserRoleLink")
public class UserRoleLink extends Model<UserRoleLink> {
    // 用户与角色外键表主键
    @TableId(value = "user_role_link_id", type = IdType.AUTO)
    @ApiModelProperty(value = "用户与角色外键表主键", name = "userRoleLinkId")
    private Integer userRoleLinkId;
    // 用户外键
    @ApiModelProperty(value = "用户外键", name = "userId")
    private Integer userId;
    // 角色外键
    @ApiModelProperty(value = "角色外键", name = "roleId")
    private Integer roleId;

    /**
     * 获取主键值
     *
     * @return 主键值
     */
    @Override
    public Serializable pkVal() {
        return this.userRoleLinkId;
    }
}


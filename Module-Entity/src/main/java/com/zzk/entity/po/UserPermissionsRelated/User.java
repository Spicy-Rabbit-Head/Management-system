package com.zzk.entity.po.UserPermissionsRelated;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 用户表(com.zzk.entity.po.UserPermissionsRelated.User)表实体类<br>
 * <p>
 * <p>
 * 1.0版本：用户表实体类构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-03 11:27
 */

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@TableName("user")
@ApiModel(description = "用户表", value = "User")
public class User extends Model<User> {
    // 用户表主键
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "用户表主键", name = "id")
    private Integer id;
    // 用户名
    @ApiModelProperty(value = "用户名", name = "username")
    private String username;
    // 密码
    @ApiModelProperty(value = "密码", name = "password")
    private String password;

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


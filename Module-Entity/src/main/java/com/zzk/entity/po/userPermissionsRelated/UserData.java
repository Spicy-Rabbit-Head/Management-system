package com.zzk.entity.po.userPermissionsRelated;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 用户表(com.zzk.entity.po.UserPermissionsRelated.User)实体类<br>
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
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_management.user_data")
@ApiModel(description = "用户表", value = "User")
public class UserData extends Model<UserData> {
    public UserData(String username) {
        this.username = username;
    }

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
    // 邮箱
    @ApiModelProperty(value = "邮箱", name = "email")
    private String email;
    // 通用唯一标识符
    @ApiModelProperty(value = "通用唯一标识符", name = "uuid")
    private String uuid;

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


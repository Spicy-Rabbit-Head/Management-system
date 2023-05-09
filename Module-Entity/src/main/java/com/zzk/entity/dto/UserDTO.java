package com.zzk.entity.dto;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@ApiModel(description = "用户表", value = "User")
public class UserDTO extends Model<UserDTO> {
    @ApiModelProperty(value = "用户表主键", name = "id")
    private Integer id;
    // 用户名
    @ApiModelProperty(value = "用户名", name = "username")
    private String username;
    // 密码
    @ApiModelProperty(value = "密码", name = "password")
    private String password;
    // 重复密码
    @ApiModelProperty(value = "重复密码", name = "repeatPassword")
    private String repeatPassword;


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

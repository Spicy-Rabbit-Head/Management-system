package com.zzk.entity.po;

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
 * 角色表(com.zzk.entity.po.Role)表实体类
 *
 * @author zhaozikui
 * @since 2023-03-03 13:16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("role")
@ApiModel(description = "角色表", value = "Role")
public class Role extends Model<Role> {
    // 角色表主键
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "角色表主键", name = "id")
    private Integer id;
    // 角色名
    @ApiModelProperty(value = "角色名", name = "roleName")
    private String roleName;

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


package com.zzk.entity.po.maintenanceReserve;

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
 * 文件表(com.zzk.entity.po.maintenanceReserve.Files)实体类<br>
 * <p>
 * <p>
 * 1.0版本：文件表实体类构建<br>
 * <p>
 *
 * @author zhaozikui
 * @since 2023-04-10 14:57
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("file")
@ApiModel(description = "文件表", value = "Files")
public class Files extends Model<Files> {
    // 文件表主键
    @TableId(type = IdType.AUTO)
    @ApiModelProperty(value = "文件表主键", name = "id")
    private Integer id;
    // 文件名
    @ApiModelProperty(value = "文件名", name = "name")
    private String name;
    // 文件类型
    @ApiModelProperty(value = "文件类型", name = "type")
    private String type;
    // 文件大小
    @ApiModelProperty(value = "文件大小", name = "size")
    private Long size;
    // 文件md5值
    @ApiModelProperty(value = "文件md5值", name = "md5")
    private String md5;
    // 文件地址
    @ApiModelProperty(value = "文件地址", name = "url")
    private String url;
    // 是否删除
    @ApiModelProperty(value = "是否删除", name = "isDelete")
    private Boolean isDelete;
    // 是否启用
    @ApiModelProperty(value = "是否启用", name = "enable")
    private Boolean enable;

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

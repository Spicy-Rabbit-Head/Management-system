package com.zzk.entity.po.sparePartsManagement;

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
 * 备品数据表(com.zzk.entity.po.SparePartsManagement.SparePartsData)实体类<br>
 * <p>
 * <p>
 * 1.0版本：备品数据表实体类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-11-17 13:39
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("spare_parts_management.spare_parts_data")
@ApiModel(description = "备品数据表", value = "SparePartsData")
public class SparePartsData extends Model<SparePartsData> {
    // 备品数据表主键
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "备品数据表主键", name = "id")
    private Integer id;
    // 备品编号
    @ApiModelProperty(value = "备品编号", name = "spare_parts_number")
    private String sparePartsNumber;
    // 备品料号
    @ApiModelProperty(value = "备品料号", name = "part_number")
    private String partNumber;
    // 备品名称
    @ApiModelProperty(value = "备品名称", name = "spare_parts_name")
    private String sparePartsName;
    // 品牌
    @ApiModelProperty(value = "品牌", name = "brand")
    private String brand;
    // 图号
    @ApiModelProperty(value = "图号", name = "drawing_number")
    private String drawingNumber;
    // 图片链接
    @ApiModelProperty(value = "图片链接", name = "image_link")
    private String imageLink;
    // 价格
    @ApiModelProperty(value = "价格", name = "price")
    private Float price;

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

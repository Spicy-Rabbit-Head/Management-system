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
 * 方形IG備品表(com.zzk.entity.po.maintenanceReserve.SquareIGPartsList)实体类<br>
 * <p>
 * <p>
 * 1.0版本：方形IG備品表实体类构建<br>
 * <p>
 *
 * @author 鹿九
 * @version 1.0
 * @since 2023-03-16
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("square_ig_parts_list")
@ApiModel(description = "方形IG備品列表", value = "SquareIGPartsList")
public class SquareIGPartsList extends Model<SquareIGPartsList> {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "方形IG備品列表主鍵", name = "id")
    private Integer id;

    @ApiModelProperty(value = "序號", name = "serialNumber")
    private String serialNumber;

    @ApiModelProperty(value = "備品名稱", name = "partName")
    private String partName;

    @ApiModelProperty(value = "備品料號", name = "partNumber")
    private String partNumber;

    @ApiModelProperty(value = "使用壽命(月）", name = "serviceLife")
    private String serviceLife;

    @ApiModelProperty(value = "單次價格", name = "unitPrice")
    private Float unitPrice;

    @ApiModelProperty(value = "使用量", name = "amount")
    private String amount;

    @ApiModelProperty(value = "單位", name = "unit")
    private String unit;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}

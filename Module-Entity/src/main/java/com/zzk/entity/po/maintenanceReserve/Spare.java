package com.zzk.entity.po.maintenanceReserve;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

/**
 * 备品表(com.zzk.entity.po.maintenanceReserve.Spare)实体类<br>
 * <p>
 * <p>
 * 1.0版本：备品表实体类构建<br>
 * <p>
 *
 * @author 鹿九
 * @since 2023-02-10
 */
@EqualsAndHashCode(callSuper = true)
@Data
@ApiModel(description = "备品表", value = "Spare")
public class Spare extends Model<Spare> {

    @Serial
    private static final long serialVersionUID = 1L;
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "备品表主键", name = "id")
    private Integer id;

    @ApiModelProperty(value = "备品编号", name = "numbering")
    private String numbering;

    @ApiModelProperty(value = "備品料號", name = "partNumber")
    private String partNumber;

    @ApiModelProperty(value = "備品名稱", name = "partName")
    private String partName;

    @ApiModelProperty(value = "品牌", name = "brand")
    private String brand;

    @ApiModelProperty(value = "圖號", name = "figureNumber")
    private String figureNumber;

    @ApiModelProperty(value = "照片鏈接", name = "imageUrl")
    private String imageUrl;

    @ApiModelProperty(value = "單次價格", name = "unitPrice")
    private Float unitPrice;

    @ApiModelProperty(value = "库存量", name = "stock")
    private Integer stock;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}

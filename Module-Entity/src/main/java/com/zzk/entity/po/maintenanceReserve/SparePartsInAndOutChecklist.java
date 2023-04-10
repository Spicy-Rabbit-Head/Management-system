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
import java.time.LocalDateTime;

/**
 * 备品进出清单表(com.zzk.entity.po.maintenanceReserve.SparePartsInAndOutChecklist)实体类<br>
 * <p>
 * <p>
 * 1.0版本：备品进出清单实体类构建<br>
 * <p>
 *
 * @author 鹿九
 * @version 1.0
 * @since 2023-03-01
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("spare_parts_in_and_out_checklist")
@ApiModel(description = "备品进出清单", value = "SparePartsInAndOutChecklist")
public class SparePartsInAndOutChecklist extends Model<SparePartsInAndOutChecklist> {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "备品进出清单主键", name = "id")
    private Integer id;

    @ApiModelProperty(value = "單據編號", name = "documentNumber")
    private String documentNumber;

    @ApiModelProperty(value = "交收日期", name = "settlementDate")
    private LocalDateTime settlementDate;

    @ApiModelProperty(value = "交收類型", name = "settlementType")
    private String settlementType;

    @ApiModelProperty(value = "備品編號", name = "numbering")
    private String numbering;

    @ApiModelProperty(value = "備品名稱", name = "partName")
    private String partName;

    @ApiModelProperty(value = "數量", name = "amount")
    private Integer amount;

    @ApiModelProperty(value = "貨位號", name = "slotNumber")
    private String slotNumber;

    @ApiModelProperty(value = "執行人", name = "executor")
    private String executor;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}

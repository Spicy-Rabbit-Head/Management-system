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
 * 机台备品清单表(com.zzk.entity.po.maintenanceReserve.ListOfSparePartsAndMachine)实体类<br>
 * <p>
 * <p>
 * 1.0版本：机台备品清单表实体类构建<br>
 * <p>
 *
 * @author 鹿九
 * @version 1.0
 * @since 2023-02-20
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("list_of_spare_parts_and_machine")
@ApiModel(description = "机台备品清单", value = "ListOfSparePartsAndMachine")
public class ListOfSparePartsAndMachine extends Model<ListOfSparePartsAndMachine> {

    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value = "机台备品清单主键", name = "id")
    private Integer id;

    @ApiModelProperty(value = "機器名稱", name = "machineName")
    private String machineName;

    @ApiModelProperty(value = "機器編號", name = "machineNum")
    private String machineNum;

    @ApiModelProperty(value = "保養級別", name = "rule")
    private String rule;

    @ApiModelProperty(value = "保養項目", name = "maintenanceItems")
    private String maintenanceItems;

    @ApiModelProperty(value = "備品名稱", name = "partName")
    private String partName;

    @ApiModelProperty(value = "備品料號", name = "partNumber")
    private String partNumber;

    @ApiModelProperty(value = "使用數量", name = "amount")
    private Integer amount;

    @ApiModelProperty(value = "單次價格", name = "unitPrice")
    private Float unitPrice;

    @Override
    public Serializable pkVal() {
        return this.id;
    }
}

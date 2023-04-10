package com.zzk.entity.po.maintenanceReserve;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 * IG使用記錄
 * </p>
 *
 * @author 鹿九
 * @since 2023-03-17
 */
@Getter
@Setter
@TableName("ig_working_with_records")
@ApiModel(value = "IgWorkingWithRecords对象", description = "IG使用記錄")
public class IgWorkingWithRecords implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("IG编号")
    private String ignumber;

    @ApiModelProperty("使用狀態：1 使用；2 備用")
    private Integer state;

    @ApiModelProperty("準備人員")
    private String executor;

    @ApiModelProperty("準備日期")
    private LocalDate preparationdate;

    @ApiModelProperty("上線使用日期")
    private LocalDate launchdate;

    @ApiModelProperty("上線使用幾台")
    private String machinenum;

    @ApiModelProperty("使用位置")
    private String location;

    @ApiModelProperty("使用情況 ：1 OK：2 NG")
    private Integer usage;

    @ApiModelProperty("料號規格")
    private String partnumber;

    @ApiModelProperty("濺鍍方式")
    private String sputteringmethod;

    @ApiModelProperty("H腔設定功率")
    private String hsetpower;

    @ApiModelProperty("H腔【1-7】")
    private String hformer;

    @ApiModelProperty("H腔【8-17】")
    private String hmiddle;

    @ApiModelProperty("H腔【18-24】")
    private String hafter;

    @ApiModelProperty("M腔設定功率")
    private String msetpower;

    @ApiModelProperty("M腔【1-7】")
    private String mformer;

    @ApiModelProperty("M腔【8-17】")
    private String mmiddle;

    @ApiModelProperty("M腔【18-24】")
    private String mafter;

    @ApiModelProperty("LL腔設定功率")
    private String llsetpower;

    @ApiModelProperty("LL腔【1-7】")
    private String llformer;

    @ApiModelProperty("LL腔【8-17】")
    private String llmiddle;

    @ApiModelProperty("LL腔【18-24】")
    private String llafter;

    @ApiModelProperty("機台設定功率")
    private String setpower;

    @ApiModelProperty("圓形IG使用功率")
    private String roundigpower;

    @ApiModelProperty("無功率原因")
    private String nopowerreason;

    @ApiModelProperty("保養日期")
    private LocalDate maintenancedate;

    @ApiModelProperty("保養負責人")
    private String maintenanceexecutor;

    @ApiModelProperty("產生費用【元】")
    private String expenses;

    @ApiModelProperty("驗收人員")
    private String acceptancepersonnel;

    @ApiModelProperty("驗收日期")
    private LocalDate acceptancedate;

    @ApiModelProperty("驗收情況")
    private String acceptanceinstructions;

    @ApiModelProperty("處理情況")
    private String handlingsituation;


}

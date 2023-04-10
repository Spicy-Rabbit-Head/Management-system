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
 * IG清單
 * </p>
 *
 * @author 鹿九
 * @since 2023-03-17
 */
@Getter
@Setter
@TableName("ig_list")
@ApiModel(value = "IgList对象", description = "IG清單")
public class IgList implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty("IG編號")
    private String ignumber;

    @ApiModelProperty("IG類型：1 方形IG；2  圓形插拔；3 圓形接線")
    private Integer type;

    @ApiModelProperty("使用狀態：1 使用；2備用；3 待保養；4 借出")
    private Integer state;

    @ApiModelProperty("保養次數")
    private Integer operatetimes;

    @ApiModelProperty("週期內保養次數")
    private Integer cycleoperatetimes;

    @ApiModelProperty("最近一次上線使用日期")
    private LocalDate dateoflastuse;

    @ApiModelProperty("最近一次保養日期")
    private LocalDate dataoflastoperate;

    @ApiModelProperty("配件0啟用日期")
    private LocalDate i000;

    @ApiModelProperty("配件1啟用日期")
    private LocalDate i001;

    @ApiModelProperty("配件2啟用日期")
    private LocalDate i002;

    @ApiModelProperty("配件3啟用日期")
    private LocalDate i003;

    @ApiModelProperty("配件4啟用日期")
    private LocalDate i004;

    @ApiModelProperty("配件5啟用日期")
    private LocalDate i005;

    @ApiModelProperty("配件6啟用日期")
    private LocalDate i006;

    @ApiModelProperty("配件7啟用日期")
    private LocalDate i007;

    @ApiModelProperty("配件8啟用日期")
    private LocalDate i008;

    @ApiModelProperty("配件9啟用日期")
    private LocalDate i009;

    @ApiModelProperty("配件10啟用日期")
    private LocalDate i010;

    @ApiModelProperty("配件11啟用日期")
    private LocalDate i011;

    @ApiModelProperty("配件12啟用日期")
    private LocalDate i012;

    @ApiModelProperty("配件13啟用日期")
    private LocalDate i013;

    @ApiModelProperty("配件14啟用日期")
    private LocalDate i014;

    @ApiModelProperty("配件15啟用日期")
    private LocalDate i015;

    @ApiModelProperty("配件16啟用日期")
    private LocalDate i016;

    @ApiModelProperty("配件17啟用日期")
    private LocalDate i017;

    @ApiModelProperty("配件18啟用日期")
    private LocalDate i018;

    @ApiModelProperty("配件19啟用日期")
    private LocalDate i019;

    @ApiModelProperty("配件20啟用日期")
    private LocalDate i020;

    @ApiModelProperty("配件21啟用日期")
    private LocalDate i021;

    @ApiModelProperty("配件22啟用日期")
    private LocalDate i022;

    @ApiModelProperty("配件23啟用日期")
    private LocalDate i023;

    @ApiModelProperty("配件24啟用日期")
    private LocalDate i024;

    @ApiModelProperty("配件25啟用日期")
    private LocalDate i025;

    @ApiModelProperty("配件26啟用日期")
    private LocalDate i026;

    @ApiModelProperty("配件27啟用日期")
    private LocalDate i027;

    @ApiModelProperty("配件28啟用日期")
    private LocalDate i028;

    @ApiModelProperty("配件29啟用日期")
    private LocalDate i029;

    @ApiModelProperty("配件30啟用日期")
    private LocalDate i030;

    @ApiModelProperty("配件31啟用日期")
    private LocalDate i031;

    @ApiModelProperty("配件32啟用日期")
    private LocalDate i032;

    @ApiModelProperty("配件33啟用日期")
    private LocalDate i033;

    @ApiModelProperty("配件34啟用日期")
    private LocalDate i034;

    @ApiModelProperty("配件35啟用日期")
    private LocalDate i035;

    @ApiModelProperty("配件36啟用日期")
    private LocalDate i036;

    @ApiModelProperty("配件37啟用日期")
    private LocalDate i037;

    @ApiModelProperty("配件38啟用日期")
    private LocalDate i038;

    @ApiModelProperty("配件39啟用日期")
    private LocalDate i039;

    @ApiModelProperty("配件40啟用日期")
    private LocalDate i040;

    @ApiModelProperty("配件41啟用日期")
    private LocalDate i041;

    @ApiModelProperty("配件42啟用日期")
    private LocalDate i042;

    @ApiModelProperty("配件43啟用日期")
    private LocalDate i043;

    @ApiModelProperty("配件44啟用日期")
    private LocalDate i044;

    @ApiModelProperty("配件45啟用日期")
    private LocalDate i045;

    @ApiModelProperty("配件46啟用日期")
    private LocalDate i046;

    @ApiModelProperty("配件47啟用日期")
    private LocalDate i047;

    @ApiModelProperty("配件48啟用日期")
    private LocalDate i048;


}

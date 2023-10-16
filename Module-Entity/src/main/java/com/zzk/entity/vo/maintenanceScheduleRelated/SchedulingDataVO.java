package com.zzk.entity.vo.maintenanceScheduleRelated;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

/**
 * 排程数据视图对象<br>
 * <p>
 * <p>
 * 1.0版本 : 2023-10-13 16:33<br>
 * 构建排程数据视图对象<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-10-13 16:33
 */
@Data
@AllArgsConstructor
public class SchedulingDataVO {
    // 主键id
    private Integer id;
    // 设备编号
    private String equipmentNumber;
    // 设备型号
    private String equipmentModelNumber;
    // 设备名称
    private String equipmentName;
    // 保养周期
    private String maintenanceCycle;
    // 计划时间
    private LocalDate planTime;
    // 排定时间
    private String schedulingTime;
    // 负责人
    private String personInCharge;
    // 成员
    private String member;
    // 排程状态
    private Boolean schedulingStatus;
    // 总计
    private Integer total;
}

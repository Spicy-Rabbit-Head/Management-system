package com.zzk.entity.dto.maintenanceScheduleRelated;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

/**
 * 排程选择传输对象<br>
 * <p>
 * <p>
 * 1.0 2023-10-16 16:28<br>
 * 构建排程选择传输对象<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-10-16 16:28
 */
@Getter
@ToString
@AllArgsConstructor
public class SchedulingSelectDTO {
    // 机台选择
    private Integer[] machineSelect;
    // 负责人
    private String personInCharge;
    // 成员选择
    private String[] memberSelect;
    // 排定时间
    private String schedulingTime;
    // 排程状态
    private Boolean status;
}

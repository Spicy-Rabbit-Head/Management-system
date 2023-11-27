package com.zzk.entity.po.maintenanceManagement;

import lombok.Data;

/**
 * 排程更新数据<br>
 * <p>
 * <p>
 * 1.0 2023-10-16 13:13<br>
 * 构建排程更新数据<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @apiNote 该类为排程更新数据
 * @since 2023-10-16 13:13
 */
@Data
public class ScheduleUpdateData {
    // 机台选择
    private Integer[] machineSelect;
    // 负责人
    private String personInCharge;
    // 成员
    private String member;
    // 排定时间
    private String schedulingTime;
    // 排程状态
    private Boolean status;
}

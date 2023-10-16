package com.zzk.entity.vo.maintenanceScheduleRelated;

import com.zzk.entity.po.userManagement.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 排程界面数据视图对象<br>
 * <p>
 * <p>
 * 1.0版本 : 2023-10-13 16:24<br>
 * 构建排程界面数据视图对象<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-10-13 16:24
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SchedulingInterfaceVO {
    // 成员列表
    private Member[] members;

    // 排程数据
    private SchedulingDataVO[] schedulingData;
}

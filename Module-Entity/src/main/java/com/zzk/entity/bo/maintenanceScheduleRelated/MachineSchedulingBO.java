package com.zzk.entity.bo.maintenanceScheduleRelated;

import com.zzk.entity.dto.maintenanceScheduleRelated.SchedulingSelectDTO;
import com.zzk.entity.po.maintenanceManagement.ScheduleUpdateData;
import lombok.Getter;

import java.util.StringJoiner;

/**
 * 排程业务对象<br>
 * <p>
 * <p>
 * 1.0 2023-10-16 16:28<br>
 * 构建排程业务对象<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-10-16 10:55
 */
@Getter
public class MachineSchedulingBO {
    // 排程更新数据
    private final ScheduleUpdateData scheduleUpdateData;

    /**
     * 构造
     *
     * @param schedulingSelectDTO 排程选择传输对象
     */
    public MachineSchedulingBO(SchedulingSelectDTO schedulingSelectDTO) {
        scheduleUpdateData = new ScheduleUpdateData();
        if (!schedulingSelectDTO.getStatus()) {
            System.out.println("排程选择传输对象状态为false");
            scheduleUpdateData.setMachineSelect(schedulingSelectDTO.getMachineSelect());
            scheduleUpdateData.setStatus(false);
            return;
        }
        System.out.println("排程选择传输对象状态为true");
        // 设置排程选择
        scheduleUpdateData.setMachineSelect(schedulingSelectDTO.getMachineSelect());
        // 设置负责人
        scheduleUpdateData.setPersonInCharge(schedulingSelectDTO.getPersonInCharge());
        // 设置排定时间
        scheduleUpdateData.setSchedulingTime(schedulingSelectDTO.getSchedulingTime());
        // 设定状态
        scheduleUpdateData.setStatus(schedulingSelectDTO.getStatus());
        // 对象转换
        transform(schedulingSelectDTO);
    }

    /**
     * 对象转换
     * <p>
     *
     * @param schedulingSelectDTO 排程选择传输对象
     *
     * @apiNote 该方法用于将排程选择传输对象转换为排程更新数据
     * @author zhao'zi'kui
     * @since 1.0
     */
    public void transform(SchedulingSelectDTO schedulingSelectDTO) {
        // 设置连接符
        StringJoiner joiner = new StringJoiner(" ");
        for (String memberSelect : schedulingSelectDTO.getMemberSelect()) {
            joiner.add(memberSelect);
        }
        // 设置成员选择
        scheduleUpdateData.setMember(joiner.toString());
    }
}

package com.zzk.service.maintenanceRelated;

import com.zzk.entity.bo.maintenanceScheduleRelated.MachineSchedulingBO;
import com.zzk.entity.po.maintenanceManagement.ModuleScheduling;
import com.zzk.entity.po.maintenanceManagement.NonRoutineMattersScheduling;
import com.zzk.entity.vo.maintenanceScheduleRelated.SchedulingDataVO;
import com.zzk.entity.vo.maintenanceScheduleRelated.SchedulingInterfaceVO;

/**
 * 保养排程相关服务接口<br>
 * <p>
 * <p>
 * 1.0版本：保养排程相关服务接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @apiNote 该接口用于保养排程相关服务
 * @since 2023-10-10 16:41
 */
public interface SchedulingService {
    /**
     * 排程界面数据<br>
     * 包括:成员列表、排程列表、分页信息
     *
     * @param workshop     车间 从哪个车间获取排程
     * @param offsetNumber 偏移量 从第几条数据开始
     * @param pageSize     页面大小 每页显示多少条数据
     *
     * @return Response 排程界面数据结果
     *
     * @since 1.0
     */
    SchedulingInterfaceVO getScheduleInterface(String workshop, Integer offsetNumber, Integer pageSize);

    /**
     * 按车间获取排程
     *
     * @param workshop 车间
     * @param offset   偏移量 从第几条数据开始
     * @param pageSize 页面大小 每页显示多少条数据
     *
     * @return R 按车间获取排程结果
     *
     * @since 1.0
     */
    SchedulingDataVO[] getScheduleByWorkshop(String workshop, Integer offset, Integer pageSize);

    /**
     * 修改排程数据
     *
     * @param schedulingSelect 排程选择数据
     *
     * @return Boolean 修改排程成功与否
     *
     * @since 1.0
     */
    Boolean updateSchedule(MachineSchedulingBO schedulingSelect);

    /**
     * 获取模组排程数据
     *
     * @return ModuleScheduling[] 模组排程数据
     */
    ModuleScheduling[] getModuleScheduling();

    /**
     * 获取非例行事项排程数据
     *
     * @return NonRoutineMattersScheduling[] 非例行事项排程数据
     */
    NonRoutineMattersScheduling[] getNonRoutineMattersScheduling();

    /**
     * 插入非例行事项排程数据
     */
    Boolean insertNonRoutineMattersScheduling(NonRoutineMattersScheduling nonRoutineMattersScheduling);

    /**
     * 查询保养成员
     */
    String[] getMaintenanceMember();
}

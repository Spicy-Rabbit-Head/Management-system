package com.zzk.service.maintenanceRelated.impl;

import com.zzk.dao.maintenanceScheduleRelated.ModuleSchedulingDao;
import com.zzk.dao.maintenanceScheduleRelated.NonRoutineMattersSchedulingDao;
import com.zzk.dao.maintenanceScheduleRelated.SchedulingDataDao;
import com.zzk.dao.userRelated.UserDataDao;
import com.zzk.entity.bo.maintenanceScheduleRelated.MachineSchedulingBO;
import com.zzk.entity.po.maintenanceManagement.ModuleScheduling;
import com.zzk.entity.po.maintenanceManagement.NonRoutineMattersScheduling;
import com.zzk.entity.vo.maintenanceScheduleRelated.SchedulingDataVO;
import com.zzk.entity.vo.maintenanceScheduleRelated.SchedulingInterfaceVO;
import com.zzk.service.maintenanceRelated.SchedulingService;
import org.springframework.stereotype.Service;

/**
 * 保养排程相关服务实现类<br>
 * <p>
 * <p>
 * 1.0版本：保养排程相关服务实现类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-10-10 16:46
 */
@Service
public class SchedulingServiceImpl implements SchedulingService {
    // 排程数据
    private final SchedulingDataDao schedulingDataDao;
    // 用户数据
    private final UserDataDao userDataDao;
    // 模组排程数据
    private final ModuleSchedulingDao moduleSchedulingDao;
    // 非例行事项排程数据
    private final NonRoutineMattersSchedulingDao nonRoutineMattersSchedulingDao;

    // 构造器注入
    public SchedulingServiceImpl(SchedulingDataDao schedulingDataDao, UserDataDao userDataDao, ModuleSchedulingDao moduleSchedulingDao, NonRoutineMattersSchedulingDao nonRoutineMattersSchedulingDao) {
        this.schedulingDataDao = schedulingDataDao;
        this.userDataDao = userDataDao;
        this.moduleSchedulingDao = moduleSchedulingDao;
        this.nonRoutineMattersSchedulingDao = nonRoutineMattersSchedulingDao;
    }


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
    @Override
    public SchedulingInterfaceVO getScheduleInterface(String workshop, Integer offsetNumber, Integer pageSize) {
        SchedulingInterfaceVO schedulingInterfaceVO = new SchedulingInterfaceVO();
        // 获取成员列表
        schedulingInterfaceVO.setMembers(userDataDao.selectAll());
        // 获取排程列表、分页信息
        schedulingInterfaceVO.setSchedulingData(schedulingDataDao.getSchedule(workshop, offsetNumber, pageSize));
        return schedulingInterfaceVO;
    }

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
    @Override
    public SchedulingDataVO[] getScheduleByWorkshop(String workshop, Integer offset, Integer pageSize) {
        return schedulingDataDao.getSchedule(workshop, offset, pageSize);
    }

    /**
     * 修改排程数据
     *
     * @param machineSchedulingBO 排程选择数据
     *
     * @return Boolean 修改排程成功与否
     *
     * @since 1.0
     */
    @Override
    public Boolean updateSchedule(MachineSchedulingBO machineSchedulingBO) {
        return schedulingDataDao.updateSchedulingStatusById(machineSchedulingBO.getScheduleUpdateData()) > 0;
    }

    /**
     * 获取模组排程数据
     *
     * @return ModuleScheduling[] 模组排程数据
     */
    @Override
    public ModuleScheduling[] getModuleScheduling() {
        return moduleSchedulingDao.getModuleScheduling();
    }

    /**
     * 获取非例行事项排程数据
     *
     * @return NonRoutineMattersScheduling[] 非例行事项排程数据
     */
    @Override
    public NonRoutineMattersScheduling[] getNonRoutineMattersScheduling() {
        return nonRoutineMattersSchedulingDao.getNonRoutineMattersScheduling();
    }

    /**
     * 插入非例行事项排程数据
     *
     * @param nonRoutineMattersScheduling 非例行事项排程数据
     */
    @Override
    public Boolean insertNonRoutineMattersScheduling(NonRoutineMattersScheduling nonRoutineMattersScheduling) {
        return nonRoutineMattersSchedulingDao.insertNonRoutineMattersScheduling(nonRoutineMattersScheduling) > 0;
    }

    /**
     * 查询保养成员
     */
    @Override
    public String[] getMaintenanceMember() {
        return userDataDao.selectAll();
    }
}

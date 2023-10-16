package com.zzk.api.maintenanceManagement;

import com.zzk.entity.dto.maintenanceScheduleRelated.SchedulingSelectDTO;
import com.zzk.entity.response.Response;
import com.zzk.entity.vo.maintenanceScheduleRelated.SchedulingDataVO;
import com.zzk.entity.vo.maintenanceScheduleRelated.SchedulingInterfaceVO;
import com.zzk.service.maintenanceRelated.SchedulingService;
import org.springframework.web.bind.annotation.*;

/**
 * 保养排程相关接口<br>
 * <p>
 * <p>
 * 1.0版本：保养排程相关接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-10-10 16:18
 */
@RestController
@RequestMapping("/schedule")
public class ScheduleController {
    // 排程数据服务
    private final SchedulingService schedulingService;

    // 构造器注入
    public ScheduleController(SchedulingService schedulingService) {
        this.schedulingService = schedulingService;
    }

    /**
     * 读取排程界面数据
     *
     * @param offset   偏移量 从第几条数据开始
     * @param pageSize 页面大小 每页显示多少条数据
     *
     * @return R 读取排程界面数据结果
     *
     * @since 1.0
     */
    @GetMapping("/getScheduleInterface")
    public Response<SchedulingInterfaceVO> getScheduleInterface(Integer offset, Integer pageSize) {
        return Response.success(200, "读取排程数据成功", schedulingService.getScheduleInterface("製造一部車間", offset, pageSize));
    }

    /**
     * 读取排程数据
     *
     * @param workshop 车间
     * @param offset   偏移量 从第几条数据开始
     * @param pageSize 页面大小 每页显示多少条数据
     *
     * @return R 读取排程数据结果
     *
     * @since 1.0
     */
    @GetMapping("/getSchedule")
    public Response<SchedulingDataVO[]> getSchedule(String workshop, Integer offset, Integer pageSize) {
        return Response.success(200, "读取排程数据成功", schedulingService.getScheduleByWorkshop(workshop, offset, pageSize));
    }

    /**
     * 修改排程数据
     *
     * @param schedulingSelect 排程数据
     *
     * @return Response 修改结果
     *
     * @since 1.0
     */
    @PostMapping("/updateSchedule")
    public Response<String> updateSchedule(@RequestBody SchedulingSelectDTO schedulingSelect) {
        schedulingService.updateSchedule(schedulingSelect);
        return Response.success(200, "修改排程数据成功", "修改排程数据成功");
    }


}

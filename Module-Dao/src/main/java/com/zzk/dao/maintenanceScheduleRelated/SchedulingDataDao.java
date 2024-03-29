package com.zzk.dao.maintenanceScheduleRelated;

import com.zzk.entity.po.maintenanceManagement.ScheduleUpdateData;
import com.zzk.entity.po.maintenanceManagement.SchedulingData;
import com.zzk.entity.vo.maintenanceScheduleRelated.SchedulingDataVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 排程数据表(SchedulingData)表数据库访问层<br>
 * <p>
 * <p>
 * 1.0版本：2023-10-10 16:13<br>
 * 构建排程相关数据访问层<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-10-10 16:13
 */
@Repository
public interface SchedulingDataDao {
    /**
     * 获取排程数据
     *
     * @param workshop     车间
     * @param offsetNumber 偏移量
     * @param pageSize     页面大小
     * @return 排程数据
     * @since 1.0
     */
    SchedulingDataVO[] getSchedule(String workshop, Integer offsetNumber, Integer pageSize);

    /**
     * 获取已排程数据
     */
    @Select("SELECT * FROM maintenance_management.scheduling_data WHERE scheduling_status = TRUE ORDER BY workshop")
    SchedulingData[] getScheduledData();

    /**
     * 根据主键数组更新排程状态
     *
     * @param schedulingSelect 排程选择数据
     * @return 影响行数
     * @since 1.0
     */
    Integer updateSchedulingStatusById(ScheduleUpdateData scheduleUpdateData);

    /**
     * 通过设备编号查询单条数据
     *
     * @param deviceNumber 设备编号
     * @return 实例对象
     * @since 1.0
     */
    @Select("SELECT * FROM maintenance_management.scheduling_data WHERE equipment_number = #{deviceNumber}")
    SchedulingData queryByDeviceNumber(String deviceNumber);

    /**
     * 排程归档
     *
     * @param schedulingData 排程数据
     * @return 影响行数
     */
    Integer archiveScheduling(SchedulingData schedulingData);

    /**
     * 按设备编号删除排程数据
     *
     * @param deviceNumber 设备编号
     * @return 影响行数
     */
    @Delete("DELETE FROM maintenance_management.scheduling_data WHERE equipment_number = #{deviceNumber}")
    Integer deleteByDeviceNumber(String deviceNumber);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<SchedulingData> 实例对象列表
     * @return 影响行数
     * @since 1.0
     */
    int insertBatch(@Param("entities") List<SchedulingData> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<SchedulingData> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     * @since 1.0
     */
    int insertOrUpdateBatch(@Param("entities") List<SchedulingData> entities);
}

package com.zzk.dao.maintenanceScheduleRelated;

import com.zzk.entity.po.maintenanceManagement.ModuleScheduling;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 模组排程数据持久层
 */
@Repository
public interface ModuleSchedulingDao {
    /**
     * 读取模组排程数据
     *
     * @return ModuleScheduling[] 模组排程数据
     */
    @Select("SELECT * FROM maintenance_management.module_scheduling")
    ModuleScheduling[] getModuleScheduling();
}

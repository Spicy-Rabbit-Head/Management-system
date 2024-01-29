package com.zzk.dao.maintenanceScheduleRelated;

import com.zzk.entity.po.maintenanceManagement.NonRoutineMattersScheduling;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

/**
 * 非例行事项排程数据持久层
 */
@Repository
public interface NonRoutineMattersSchedulingDao {
    /**
     * 读取非例行事项排程数据
     *
     * @return NonRoutineMattersScheduling[] 非例行事项排程数据
     */
    @Select("SELECT * FROM maintenance_management.non_routine_matters_scheduling ORDER BY id")
    NonRoutineMattersScheduling[] getNonRoutineMattersScheduling();

    /**
     * 插入非例行事项排程数据
     *
     * @param nonRoutineMattersScheduling 非例行事项排程数据
     */
    @Insert("INSERT INTO maintenance_management.non_routine_matters_scheduling (matters_name, matters_description, member, matters_time) VALUES (#{mattersName},#{mattersDescription},#{member},#{mattersTime})")
    Integer insertNonRoutineMattersScheduling(NonRoutineMattersScheduling nonRoutineMattersScheduling);

    /**
     * 删除非例行事项排程数据
     *
     * @param id 非例行事项排程数据id
     */
    @Delete("DELETE FROM maintenance_management.non_routine_matters_scheduling WHERE id=#{id}")
    Integer deleteNonRoutineMattersScheduling(Integer id);

    /**
     * 更新非例行事项排程数据
     *
     * @param nonRoutineMattersScheduling 非例行事项排程数据
     */
    @Update("UPDATE maintenance_management.non_routine_matters_scheduling SET matters_name = #{mattersName},matters_description = #{mattersDescription},member = #{member},matters_time = #{mattersTime} WHERE id=#{id}")
    Integer updateNonRoutineMattersScheduling(NonRoutineMattersScheduling nonRoutineMattersScheduling);
}

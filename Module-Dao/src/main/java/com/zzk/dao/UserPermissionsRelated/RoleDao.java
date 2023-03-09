package com.zzk.dao.UserPermissionsRelated;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzk.entity.po.UserPermissionsRelated.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 角色表(Role)表数据库访问层
 *
 * @author zhaozikui
 * @since 2023-03-06 19:01
 */
public interface RoleDao extends BaseMapper<Role> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Role> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Role> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Role> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Role> entities);
}


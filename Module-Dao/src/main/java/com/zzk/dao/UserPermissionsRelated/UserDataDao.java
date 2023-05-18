package com.zzk.dao.UserPermissionsRelated;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzk.entity.po.UserPermissionsRelated.UserData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 用户表(User)表数据库访问层<br>
 * <p>
 * <p>
 * 1.0版本：使用 MyBatis-Plus 实现基本的 CRUD 操作<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-06 19:01
 */
@Repository
public interface UserDataDao extends BaseMapper<UserData> {

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     * @since 1.0
     */
    int insertBatch(@Param("entities") List<UserData> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     * @since 1.0
     */
    int insertOrUpdateBatch(@Param("entities") List<UserData> entities);

    /**
     * 更新指定用户的UUID
     *
     * @param id   用户ID
     * @param uuid UUID
     * @return 影响行数
     * @since 1.0
     */
    int updateUUID(@Param("id") Integer id, @Param("uuid") String uuid);

}
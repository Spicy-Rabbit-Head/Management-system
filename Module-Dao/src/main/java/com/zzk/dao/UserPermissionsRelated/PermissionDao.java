package com.zzk.dao.UserPermissionsRelated;

import com.zzk.entity.po.userPermissionsRelated.MenuPermission;
import com.zzk.entity.po.userPermissionsRelated.OperationPermissions;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 权限集合数据库访问层<br>
 * <p>
 * <p>
 * 1.0版本：查询用户的权限集合<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-05-18 10:16
 */
@Repository
public interface PermissionDao {
    /**
     * 查询用户的菜单权限集合
     *
     * @param userId 用户id
     * @return 菜单权限集合
     * @since 1.0
     */
    List<MenuPermission> selectMenuPermissionsByUserId(@Param("userId") Integer userId);

    /**
     * 查询用户的操作权限集合
     *
     * @param userId 用户id
     * @return 操作权限集合
     * @since 1.0
     */
    List<OperationPermissions> selectOperationPermissionsByUserId(@Param("userId") Integer userId);

    /**
     * 根据用户id查询用户角色名称
     *
     * @param userId 用户id
     * @return 角色名称
     * @since 1.0
     */
    String selectRoleNameByUserId(@Param("userId") Integer userId);

    /**
     * 根据用户id查询用户角色id
     *
     * @param userId 用户id
     * @return 角色id
     * @since 1.0
     */
    Integer selectRoleIdByUserId(@Param("userId") Integer userId);
}

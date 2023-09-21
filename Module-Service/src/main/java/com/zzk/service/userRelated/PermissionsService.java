package com.zzk.service.userRelated;

import com.zzk.entity.response.R;

/**
 * 权限相关服务接口<br>
 * <p>
 * <p>
 * 1.0版本：权限相关服务接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @apiNote 该接口用于权限相关服务
 * @since 2023-09-21 15:45
 */

public interface PermissionsService {
    /**
     * 获取菜单列表
     *
     * @return String 菜单列表
     * @since 1.0
     */
    R getMenuList();
}

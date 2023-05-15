package com.zzk.service.userRelated;

import com.zzk.entity.po.UserPermissionsRelated.UserData;

/**
 * 用户服务接口<br>
 * <p>
 * <p>
 * 1.0版本：用户服务接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @apiNote 该接口用于用户服务
 * @since 2023-05-09 15:23
 */
public interface UserService {
    /**
     * 判断用户是否存在
     *
     * @param username 用户名
     * @return Boolean 用户是否存在
     * @since 1.0
     */
    Boolean whetherTheUserExists(String username);

    /**
     * 用户添加
     *
     * @param user 用户信息
     * @return Boolean 用户是否添加成功
     * @since 1.0
     */
    Boolean userAddition(UserData user);
}

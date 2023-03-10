package com.zzk.service.permissionRelatedServices.userAuthenticationAuthorization;

import org.springframework.security.core.userdetails.UserDetails;

/**
 * 用户认证授权服务接口<br>
 * <p>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2021-03-10 16:13
 */
public interface UserAuthenticationService {
    /**
     * 用户认证
     *
     * @param username 用户名
     * @return UserDetails 用户信息
     * @since 1.0
     */
    UserDetails authentication(String username);

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回 true，登录失败返回 false
     * @since 1.0
     */
    boolean login(String username, String password);

    /**
     * 用户登出
     *
     * @param username 用户名
     * @return 登出成功返回 true，登出失败返回 false
     * @since 1.0
     */
    boolean logout(String username);
}

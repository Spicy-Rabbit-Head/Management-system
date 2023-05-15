package com.zzk.service.loginRelated;

import com.zzk.entity.dto.UserDTO;
import com.zzk.entity.response.R;

/**
 * 登录服务接口<br>
 * <p>
 * <p>
 * 1.0版本：登录服务接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @apiNote 该接口用于登录注册登出服务
 * @since 2023-03-28 11:06
 */
public interface LoginService {
    /**
     * 登录
     *
     * @param user 用户信息
     * @return R<String> 登录结果
     * @since 1.0
     */
    R login(UserDTO user);

    /**
     * 登出
     *
     * @return R 登出结果
     * @since 1.0
     */
    R logout();

    /**
     * 注册
     *
     * @param user 用户信息
     * @return R 注册结果
     * @since 1.0
     */
    R register(UserDTO user);

    /**
     * 重置密码
     *
     * @param username 用户名
     * @return R 重置密码结果
     * @since 1.0
     */
    R resetPassword(String username);

}

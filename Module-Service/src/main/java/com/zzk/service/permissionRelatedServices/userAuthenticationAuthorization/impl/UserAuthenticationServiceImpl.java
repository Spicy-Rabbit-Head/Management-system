package com.zzk.service.permissionRelatedServices.userAuthenticationAuthorization.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zzk.dao.UserPermissionsRelated.UserDao;
import com.zzk.entity.po.UserPermissionsRelated.User;
import com.zzk.service.permissionRelatedServices.userAuthenticationAuthorization.UserAuthenticationService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * 用户认证授权服务实现类<br>
 * <p>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2021-03-10 16:16
 */
@Service
public class UserAuthenticationServiceImpl implements UserAuthenticationService {
    private final UserDao userDao;

    public UserAuthenticationServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 用户认证
     *
     * @param username 用户名
     * @return UserDetails 用户信息
     * @since 1.0
     */
    @Override
    public UserDetails authentication(String username) {
        // 根据用户名查询用户
        User user = userDao.selectOne(new LambdaQueryWrapper<User>().eq(User::getUsername, username));
        // 判断用户是否存在
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户不存在");
        }
        // 封装 UserDetails
        return null;
    }

    /**
     * 用户登录
     *
     * @param username 用户名
     * @param password 密码
     * @return 登录成功返回 true，登录失败返回 false
     * @since 1.0
     */
    @Override
    public boolean login(String username, String password) {

        return false;

    }

    /**
     * 用户登出
     *
     * @param username 用户名
     * @return 登出成功返回 true，登出失败返回 false
     * @since 1.0
     */
    @Override
    public boolean logout(String username) {
        return false;
    }
}

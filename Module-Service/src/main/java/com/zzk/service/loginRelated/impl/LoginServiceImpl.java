package com.zzk.service.loginRelated.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zzk.dao.UserPermissionsRelated.UserDao;
import com.zzk.entity.dto.UserDTO;
import com.zzk.entity.permissions.LoginUser;
import com.zzk.entity.po.UserPermissionsRelated.User;
import com.zzk.entity.response.R;
import com.zzk.service.loginRelated.LoginService;
import com.zzk.utils.JwtUtils;
import com.zzk.utils.RedisSerializationUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

/**
 * 登录服务实现类<br>
 * <p>
 * <p>
 * 1.0版本：登录服务实现类构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-28 11:06
 */
@Service
public class LoginServiceImpl implements LoginService {
    // 认证管理器
    private final AuthenticationManager authenticationManager;
    // redis 序列化工具
    private final RedisSerializationUtils redisSerializationUtils;
    // 用户数据访问对象
    private final UserDao userDao;

    // 构造器注入认证管理器
    public LoginServiceImpl(AuthenticationManager authenticationManager, RedisSerializationUtils redisSerializationUtils, UserDao userDao) {
        this.authenticationManager = authenticationManager;
        this.redisSerializationUtils = redisSerializationUtils;
        this.userDao = userDao;
    }

    /**
     * 登录
     *
     * @param user 用户信息
     * @return R<String> 登录结果
     * @since 1.0
     */
    @Override
    public R login(User user) {
        Authentication authenticate;
        // 封装用户信息
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        // 调用认证管理器的认证方法
        // 认证失败抛出 AuthenticationException 身份认证异常
        authenticate = authenticationManager.authenticate(authenticationToken);
        // 获取认证成功后的用户信息
        LoginUser principal = (LoginUser) authenticate.getPrincipal();
        // 生成 token
        String jwt = JwtUtils.generateToken(principal.getUsername(), principal.getUser().getId().toString());
        // 将 token 存入 redis
        redisSerializationUtils.setString(user.getUsername(), jwt);
        // 认证成功
        return new R(1, "登录成功", true, jwt);
    }

    /**
     * 登出
     *
     * @return R 登出结果
     */
    @Override
    public R logout() {
        // 获取当前用户信息
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        LoginUser principal = (LoginUser) authenticationToken.getPrincipal();
        // 删除 redis 中的 token
        redisSerializationUtils.deleteString(principal.getUsername());
        return new R(1, "登出成功", true);
    }

    @Override
    public Boolean register(UserDTO user) {
        // 查询用户是否存在
        return userDao.selectCount(new QueryWrapper<User>().eq("username", user.getUsername())) > 0;
    }
}

package com.zzk.service.loginRelated.impl;

import com.zzk.entity.dto.UserDTO;
import com.zzk.entity.permissions.LoginUser;
import com.zzk.entity.po.UserPermissionsRelated.User;
import com.zzk.entity.response.R;
import com.zzk.service.loginRelated.LoginService;
import com.zzk.service.userRelated.UserService;
import com.zzk.utils.JwtUtils;
import com.zzk.utils.RedisSerializationUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * 登录服务实现类<br>
 * <p>
 * <p>
 * 1.0版本：登录服务实现类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @apiNote 该类用于登录注册登出服务的实现
 * @since 2023-03-28 11:06
 */
@Service
public class LoginServiceImpl implements LoginService {
    // 认证管理器
    private final AuthenticationManager authenticationManager;
    // redis 序列化工具
    private final RedisSerializationUtils redisSerializationUtils;
    // 用户服务
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    // 构造器注入认证管理器
    public LoginServiceImpl(AuthenticationManager authenticationManager, RedisSerializationUtils redisSerializationUtils, UserService userService, PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.redisSerializationUtils = redisSerializationUtils;
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
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
     * @since 1.0
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

    /**
     * 注册
     *
     * @param user 用户信息
     * @return Boolean 注册结果
     * @since 1.0
     */
    @Override
    public R register(UserDTO user) {
        // 查询用户是否存在
        if (userService.whetherTheUserExists(user.getUsername())) {
            return new R(2, "注册失败,用户已存在", false);
        } else {
            // 用户不存在，注册用户
            if (!userService.userAddition(new User(null, user.getUsername(), passwordEncoder.encode(user.getPassword()))))
                return new R(2, "注册失败,注册异常", false);
            return new R(1, "注册成功", true);
        }
    }
}

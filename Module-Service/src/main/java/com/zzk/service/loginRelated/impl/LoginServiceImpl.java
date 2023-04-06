package com.zzk.service.loginRelated.impl;

import com.zzk.entity.po.UserPermissionsRelated.User;
import com.zzk.entity.response.R;
import com.zzk.service.loginRelated.LoginService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
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

    // 构造器注入认证管理器
    public LoginServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
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
        try {
            // 封装用户信息
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
            // 调用认证管理器的认证方法
            authenticationManager.authenticate(authenticationToken);
        } catch (AuthenticationException e) {
            // 认证失败
            return new R(0, "登录失败");
        }
        // 认证成功
        return new R(1, "登录成功");
    }
}

package com.zzk.service.loginRelated.impl;

import com.zzk.entity.po.UserPermissionsRelated.User;
import com.zzk.entity.response.R;
import com.zzk.service.loginRelated.LoginService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    public R<String> login(User user) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword());
        authenticationManager.authenticate(authenticationToken);
        return new R<>(1, "登录成功");
    }
}

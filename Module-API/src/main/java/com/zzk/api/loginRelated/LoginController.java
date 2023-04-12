package com.zzk.api.loginRelated;

import com.zzk.entity.po.UserPermissionsRelated.User;
import com.zzk.entity.response.R;
import com.zzk.service.loginRelated.LoginService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录相关接口<br>
 * <p>
 * <p>
 * 1.0版本：登录相关接口构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-27 15:18
 */
@RestController
@RequestMapping("/loginRelated")
public class LoginController {
    // 登录服务
    private final LoginService loginService;

    // 构造器注入登录服务
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    /**
     * 登录接口
     *
     * @return 登录结果
     * @since 1.0
     */
    @PostMapping("/login")
    public R login(@RequestBody User user) {
        return loginService.login(user);
    }

    /**
     * 登出接口
     *
     * @return 登出结果
     * @since 1.0
     */
    @PostMapping("/logout")
    public R logout() {
        return null;
    }
}

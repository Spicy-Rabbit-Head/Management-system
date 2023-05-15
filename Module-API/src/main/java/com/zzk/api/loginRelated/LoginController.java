package com.zzk.api.loginRelated;

import com.zzk.entity.dto.UserDTO;
import com.zzk.entity.response.R;
import com.zzk.service.loginRelated.LoginService;
import org.springframework.web.bind.annotation.*;

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
    public R login(@RequestBody UserDTO user) {
        return loginService.login(user);
    }

    /**
     * 登出接口
     *
     * @return 登出结果
     * @since 1.0
     */
    @GetMapping("/logout")
    public R logout() {
        return loginService.logout();
    }

    /**
     * 注册接口
     *
     * @return 注册结果
     * @since 1.0
     */
    @PostMapping("/register")
    public R register(@RequestBody UserDTO user) {
        return loginService.register(user);
    }
}

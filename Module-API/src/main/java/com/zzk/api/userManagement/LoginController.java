package com.zzk.api.userManagement;

import com.zzk.entity.dto.UserDTO;
import com.zzk.entity.response.R;
import com.zzk.service.userRelated.LoginService;
import org.springframework.web.bind.annotation.*;

/**
 * 登录相关接口<br>
 * <p>
 * <p>
 * 1.0版本：登录相关接口构建<br>
 * <p>
 *
 * @author zhao'zi'kui
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
     * @return R 登录结果
     * @since 1.0
     */
    @PostMapping("/login")
    public R login(@RequestBody UserDTO user) {
        return loginService.login(user);
    }

    /**
     * 验证登录
     *
     * @return R 验证登录结果
     * @since 1.0
     */
    @GetMapping("/isLogin")
    public R isLogin() {
        return loginService.isLogin();
    }

    /**
     * 登出接口
     *
     * @return R 登出结果
     * @since 1.0
     */
    @GetMapping("/logout")
    public R logout() {
        return loginService.logout();
    }

    /**
     * 注册接口
     *
     * @return R 注册结果
     * @since 1.0
     */
    @PostMapping("/register")
    public R register(@RequestBody UserDTO user) {
        return loginService.register(user);
    }
}

package com.zzk.exceptionhandler;

import com.zzk.entity.response.R;
import com.zzk.exception.TokenAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 权限异常处理器<br>
 * <p>
 * <p>
 * 1.0版本：权限异常处理器构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-04-06 21:09
 */
@RestControllerAdvice
public class PermissionExceptionHandler {
    /**
     * 处理身份认证异常
     *
     * @since 1.0
     */
    @ExceptionHandler(AuthenticationException.class)
    public R handleAuthenticationException(Exception e) {
        return new R(403, e.getMessage());
    }


    /**
     * 处理 Token 异常
     *
     * @since 1.0
     */
    @ExceptionHandler(TokenAuthenticationException.class)
    public R handleTokenAuthenticationException() {
        return new R(404, "Token 异常");
    }
    // IllegalStateException
    // AccessDeniedException

    /**
     * 处理其他异常
     *
     * @since 1.0
     */
    @ExceptionHandler(Exception.class)
    public R handleException() {
        return new R(500, "服务器异常");
    }
}

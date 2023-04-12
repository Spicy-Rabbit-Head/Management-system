package com.zzk.exceptionhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzk.entity.response.R;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

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
     * 身份认证异常处理<br>
     * 过滤器链中的异常处理器<br>
     * <p>
     *
     * @param httpServletRequest  请求
     * @param httpServletResponse 响应
     * @param e                   异常
     * @throws IOException 异常
     * @since 1.0
     */
    public static void handleFilterAuthenticationException(HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException {
        httpServletResponse.setCharacterEncoding("UTF-8");
        ObjectMapper objectMapper = new ObjectMapper();
        httpServletResponse.getWriter().write(objectMapper.writeValueAsString(new R(401, "未登录或登录已过期")));
    }

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

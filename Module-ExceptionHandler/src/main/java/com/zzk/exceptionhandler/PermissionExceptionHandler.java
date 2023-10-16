package com.zzk.exceptionhandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzk.entity.response.Response;
import com.zzk.exception.TokenAuthenticationException;
import com.zzk.exception.TokenInvalidationException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
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
    // @ExceptionHandler(AuthenticationException.class)
    public Response<Void> handleAuthenticationException(Exception e) {
        return Response.failed(403, e.getMessage());
    }

    // @ExceptionHandler(InsufficientAuthenticationException.class)
    public Response<Void> handleInsufficientAuthenticationException(Exception e) {
        return Response.failed(403, "无访问权限");
    }

    /**
     * Token认证异常处理<br>
     * 过滤器链中的异常处理器<br>
     * <p>
     *
     * @param httpServletRequest  请求
     * @param httpServletResponse 响应
     * @param e                   异常
     *
     * @throws IOException 异常
     * @since 1.0
     */
    public static void handleFilterAuthenticationException(HttpServletRequest httpServletRequest, @NotNull HttpServletResponse httpServletResponse, Exception e) throws IOException {
        System.out.println("Token异常类:" + e.getClass());
        System.out.println("Token异常信息:" + e.getMessage());
        ObjectMapper objectMapper = new ObjectMapper();
        httpServletResponse.setContentType("application/json");
        if (e instanceof TokenAuthenticationException) {
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(Response.failed(100000, e.getMessage(), "Token验证流程异常")));
        } else if (e instanceof TokenInvalidationException) {
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(Response.failed(100001, e.getMessage(), "Token验证流程异常")));
        } else {
            httpServletResponse.getWriter().write(objectMapper.writeValueAsString(Response.failed(100002, e.getMessage(), "Token验证流程异常")));
        }
    }

    /**
     * 处理其他异常
     *
     * @since 1.0
     */
    // @ExceptionHandler(Exception.class)
    public Response<Void> handleException(Exception e) {
        return Response.failed(500, "服务器异常");
    }
}

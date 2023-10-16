package com.zzk.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzk.entity.response.Response;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 身份认证异常处理器<br>
 * <p>
 * <p>
 * 1.0版本：身份认证异常处理器构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-05-18 16:58
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {

    private final ObjectMapper objectMapper;

    public AuthenticationEntryPointImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        System.out.println("认证异常类: " + authException.getClass());
        System.out.println("认证异常信息: " + authException.getMessage());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(Response.failed(402, authException.getMessage(), "认证验证流程异常")));
    }
}

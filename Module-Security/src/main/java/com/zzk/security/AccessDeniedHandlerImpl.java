package com.zzk.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zzk.entity.response.Response;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 授权异常处理器<br>
 * <p>
 * <p>
 * 1.0版本：授权异常处理器构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-05-18 16:55
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    private final ObjectMapper objectMapper;

    public AccessDeniedHandlerImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        System.out.println("授权异常类: " + accessDeniedException.getClass());
        System.out.println("授权异常信息: " + accessDeniedException.getMessage());
        response.setContentType("application/json");
        response.getWriter().write(objectMapper.writeValueAsString(Response.failed(403, accessDeniedException.getMessage(), "授权验证流程异常")));
    }
}

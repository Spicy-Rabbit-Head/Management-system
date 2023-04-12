package com.zzk.filter;

import com.zzk.entity.permissions.TokenInfo;
import com.zzk.exceptionhandler.PermissionExceptionHandler;
import com.zzk.utils.JwtUtils;
import com.zzk.utils.RedisSerializationUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

/**
 * JWT 认证过滤器<br>
 * <p>
 * <p>
 * 1.0版本：JWT 认证过滤器构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-04-06 20:06
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
    // Redis 工具类
    private final RedisSerializationUtils redisSerializationUtils;

    public JwtAuthenticationTokenFilter(RedisSerializationUtils redisSerializationUtils) {
        this.redisSerializationUtils = redisSerializationUtils;
    }

    @Override
    protected void doFilterInternal(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws IOException, ServletException {
        // 获取请求头中的 token
        String token = request.getHeader("token");
        // 如果请求头中没有 token
        if (!StringUtils.hasText(token)) {
            // 放行
            filterChain.doFilter(request, response);
            return;
        }
        // 解析 token
        TokenInfo tokenInfo;
        try {
            tokenInfo = JwtUtils.verifyToken(token);
            // 判断 token 是否失效
            assert tokenInfo != null;
            String stringToken = redisSerializationUtils.getString(tokenInfo.name());
            if (!token.equals(stringToken)) {
                PermissionExceptionHandler.handleFilterAuthenticationException(request, response, null);
                return;
            }
        } catch (Exception e) {
            PermissionExceptionHandler.handleFilterAuthenticationException(request, response, null);
            return;
        }
        // 如果 token 有效
        // 将 token 中的用户信息设置到 Spring Security 的上下文中
        // TODO: 获取权限消息封装到 Authentication 中
        SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(tokenInfo.name(), null, null));
        // 放行
        filterChain.doFilter(request, response);
    }
}

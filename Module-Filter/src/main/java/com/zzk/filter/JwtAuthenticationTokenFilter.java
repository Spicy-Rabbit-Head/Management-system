package com.zzk.filter;

import com.zzk.entity.permissions.UserDataDetails;
import com.zzk.exception.TokenAuthenticationException;
import com.zzk.exception.TokenInvalidationException;
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
        System.out.println(token);
        // 如果请求头中没有 token
        if (!StringUtils.hasText(token)) {
            // 放行
            filterChain.doFilter(request, response);
            return;
        }
        // 解析 token
        UserDataDetails userDetail;
        try {
            // 解析 token
            String secretKey = JwtUtils.verifyTokenString(token);
            // 判断 token 是否失效
            if (secretKey == null) {
                throw new TokenAuthenticationException("token 验证异常");
            }
            // 从 Redis 中获取用户信息详情
            userDetail = redisSerializationUtils.getString(secretKey, UserDataDetails.class);
            if (userDetail == null) {
                throw new TokenInvalidationException("token 已失效");
            }
        } catch (Exception e) {
            PermissionExceptionHandler.handleFilterAuthenticationException(request, response, e);
            return;
        }
        // 如果 token 有效
        // 将 token 中的用户信息详情设置到 Spring Security 的上下文中
        SecurityContextHolder.getContext().setAuthentication(UsernamePasswordAuthenticationToken.authenticated(userDetail, null, userDetail.getAuthorities()));
        // 放行
        filterChain.doFilter(request, response);
    }
}

package com.zzk.config;

import com.zzk.exceptionhandler.PermissionExceptionHandler;
import com.zzk.filter.JwtAuthenticationTokenFilter;
import jakarta.annotation.Resource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * Spring Security 配置类<br>
 * <p>
 * <p>
 * 1.0版本：Spring Security 配置类构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-23 16:10
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    /**
     * 密码加密器
     *
     * @return BCryptPasswordEncoder 密码加密器
     * @since 1.0
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 认证管理器
     *
     * @param authenticationConfiguration 认证配置
     * @return AuthenticationManager 认证管理器
     * @throws Exception 异常
     * @since 1.0
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // 注入 JwtAuthenticationTokenFilter 过滤器
    @Resource
    private JwtAuthenticationTokenFilter JwtAuthenticationTokenFilter;

    /**
     * 安全过滤器链
     *
     * @param http HttpSecurity
     * @return SecurityFilterChain 安全过滤器链
     * @throws Exception 异常
     * @since 1.0
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                // 关闭跨域保护
                .csrf().disable()
                // 关闭session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 授权HTTP请求
                .authorizeHttpRequests()
                // 登录相关接口不需要认证
                .requestMatchers("/loginRelated/login").anonymous()
                // 登出相关接口不需要认证
                .requestMatchers("/loginRelated/logout").anonymous()
                // 其他接口需要认证
                .anyRequest().authenticated()
                .and()
                // 异常处理
                .exceptionHandling()
                // 身份认证异常处理
                .authenticationEntryPoint(PermissionExceptionHandler::handleFilterAuthenticationException)
                .and()
                // 添加过滤器
                .addFilterBefore(JwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // .addFilterBefore(JwtAuthenticationTokenFilter, CorsFilter.class)
                .build();
    }
}

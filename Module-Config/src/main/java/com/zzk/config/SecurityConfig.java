package com.zzk.config;

import com.zzk.filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

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
@EnableMethodSecurity
public class SecurityConfig {
    // 注入 JwtAuthenticationTokenFilter 过滤器
    private final JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    // 注入 AuthenticationEntryPoint 身份认证异常处理器
    private final AuthenticationEntryPoint authenticationEntryPoint;
    // 注入 AccessDeniedHandler 授权认证异常处理器
    private final AccessDeniedHandler accessDeniedHandler;

    public SecurityConfig(com.zzk.filter.JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter, AuthenticationEntryPoint authenticationEntryPoint, AccessDeniedHandler accessDeniedHandler) {
        this.jwtAuthenticationTokenFilter = jwtAuthenticationTokenFilter;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.accessDeniedHandler = accessDeniedHandler;
    }

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
                // 授权HTTP请求
                .authorizeHttpRequests()
                // 登录登出相关接口不需要认证
                .requestMatchers("/loginRelated/**").permitAll()
                // 其他接口需要认证
                .anyRequest().authenticated()
                .and()
                // 异常处理
                .exceptionHandling()
                // 身份认证异常处理
                .authenticationEntryPoint(authenticationEntryPoint)
                // 授权认证异常处理
                .accessDeniedHandler(accessDeniedHandler)
                .and()
                // 关闭session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // 关闭跨域保护
                .cors().configurationSource(this.corsConfigurationSource()).and()
                .csrf().disable()
                // 添加过滤器
                .addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class)
                // .addFilterBefore(JwtAuthenticationTokenFilter, CorsFilter.class)
                .build();
    }

    // 注入跨域配置源
    @Value("${thisCors.url}")
    private String url;

    /**
     * 跨域配置源
     */
    private CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration cors = new CorsConfiguration();
        // 允许跨域的域名
        cors.addAllowedOriginPattern(this.url);
        // 允许跨域的请求是否携带cookie
        cors.setAllowCredentials(true);
        // 允许跨域的请求头
        cors.addAllowedHeader("*");
        // 允许跨域的请求方法
        cors.addAllowedMethod("*");
        // 允许跨域的暴露头
        cors.addExposedHeader("*");
        // 跨域配置源
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // 配置所有请求
        source.registerCorsConfiguration("/**", cors);
        return source;
    }
}

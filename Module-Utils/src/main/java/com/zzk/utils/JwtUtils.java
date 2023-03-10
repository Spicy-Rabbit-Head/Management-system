package com.zzk.utils;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTUtil;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * JWT工具类，用于生成和验证JWT<br>基于 hutool工具包封装
 * <p>
 * <p>
 * 1.0版本：使用Hutool工具包中的JWTUtil工具类,封装生成和验证JWT<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2021-03-06 21:07
 */
@Component
public final class JwtUtils {
    // 私有化构造器，防止实例化
    private JwtUtils() {
    }

    // JWT 密钥
    private static final String JWT_KEY = "zhaozikui";
    // JWT 过期时间(7天)
    // private final long JWT_TTL = 1000 * 60 * 60 * 24 * 7;

    /**
     * 生成一个JWT
     *
     * @param username 用户名
     * @param role     角色
     * @return 生成的JWT字符串
     * @since 1.0
     */
    public static String generateToken(String username, String role) {
        // 创建一个Payload对象
        Map<String, Object> payload = new HashMap<>();
        // 将用户名和角色存入Payload
        payload.put("username", username);
        payload.put("role", role);
        // 使用JwtUtil创建一个JWT，并返回字符串形式
        return JWTUtil.createToken(payload, JWT_KEY.getBytes());
    }

    // 验证token
    public boolean verify(String token) {
        // 调用Hutool-jwt的方法验证token是否有效
        return JWTUtil.verify(token, JWT_KEY.getBytes());
    }

    /**
     * 验证一个JWT，并返回有效载荷（payload）中的信息，如果验证失败则返回null
     *
     * @param token 要验证的JWT字符串
     * @return 一个包含有效载荷中信息的对象，或者null（如果验证失败）
     * @since 1.0
     */
    public static TokenInfo verifyToken(String token) {
        try {
            // 使用JwtUtil解析一个JWT，并获取Jwt对象
            JWT jwt = JWTUtil.parseToken(token);
            // 获取用户名和角色，并封装到一个TokenInfo对象中返回
            return new TokenInfo(jwt.getPayload("username").toString(), jwt.getPayload("role").toString());
        } catch (Exception e) {
            // 如果解析失败，说明token无效或者已过期，返回null
            return null;
        }
    }

    /**
     * 一个简单的类，用于表示有效载荷（payload）中的信息
     *
     * @since 1.0
     */
    public static class TokenInfo {
        private String name; // 用户名
        private String role; // 角色

        public TokenInfo(String name, String role) {
            this.name = name;
            this.role = role;
        }
    }
}

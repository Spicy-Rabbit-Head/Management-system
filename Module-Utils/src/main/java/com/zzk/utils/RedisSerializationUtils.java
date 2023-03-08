package com.zzk.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * 基于 StringRedisTemplate 的 Redis 序列化工具类
 * 使用 Jackson 作为序列化和反序列化的库
 *
 * @author zhaozikui
 * @since 2021-03-08 15:57
 */
@Component
public class RedisSerializationUtils {
    // StringRedisTemplate 实例
    private final StringRedisTemplate stringRedisTemplate;

    // 注入 StringRedisTemplate 实例
    public RedisSerializationUtils(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    // 创建 ObjectMapper 实例，用于转换对象和 JSON 字符串
    private static final ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 将字符串存储到 Redis 中
     *
     * @param key   键
     * @param value 值（字符串）
     */
    public void setString(String key, String value) {
        // 调用 StringRedisTemplate 的 set 方法，存储到 Redis 中
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 从 Redis 中获取字符串
     *
     * @param key 键
     * @return 字符串值，如果不存在则返回 null
     */
    public String getString(String key) {
        // 调用 StringRedisTemplate 的 get 方法，从 Redis 中获取字符串
        return stringRedisTemplate.opsForValue().get(key);
    }


    /**
     * 将对象序列化为 JSON 字符串并存储到 Redis 中
     *
     * @param key   键
     * @param value 值（任意对象）
     */
    public void setObject(String key, Object value) {
        try {
            // 将对象转换为 JSON 字符串
            String json = objectMapper.writeValueAsString(value);
            // 调用 StringRedisTemplate 的 set 方法，存储到 Redis 中
            stringRedisTemplate.opsForValue().set(key, json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从 Redis 中获取 JSON 字符串并反序列化为对象
     *
     * @param key   键
     * @param clazz 值的类型（Class 对象）
     * @return 反序列化后的对象，如果不存在则返回 null
     */
    public <T> T getObject(String key, Class<T> clazz) {
        try {
            // 调用 StringRedisTemplate 的 get 方法，从 Redis 中获取 JSON 字符串
            String json = stringRedisTemplate.opsForValue().get(key);
            if (json != null) {
                // 将 JSON 字符串转换为对象并返回
                return objectMapper.readValue(json, clazz);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

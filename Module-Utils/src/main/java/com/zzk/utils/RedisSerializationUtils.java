package com.zzk.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * 基于 StringRedisTemplate 的 Redis 序列化工具类 <br>使用 Jackson 作为序列化和反序列化的库
 * <p>
 * <p>
 * 1.0版本：使用 StringRedisTemplate 实现 Redis 的基本操作<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-08 15:57
 */
@Component
public class RedisSerializationUtils {
    // 创建 ObjectMapper 实例，用于转换对象和 JSON 字符串
    private static final ObjectMapper objectMapper = new ObjectMapper();
    // StringRedisTemplate 实例
    private final StringRedisTemplate stringRedisTemplate;

    // 注入 StringRedisTemplate 实例
    public RedisSerializationUtils(StringRedisTemplate stringRedisTemplate) {
        this.stringRedisTemplate = stringRedisTemplate;
    }

    /**
     * 将字符串存储到 Redis 中
     *
     * @param key   键
     * @param value 值（字符串）
     * @since 1.0
     */
    public void setString(String key, String value) {
        // 调用 StringRedisTemplate 的 set 方法，存储到 Redis 中
        stringRedisTemplate.opsForValue().set(key, value);
    }

    /**
     * 将对象序列化为 JSON 字符串并存储到 Redis 中
     *
     * @param key   键
     * @param value 值（任意对象）
     * @since 1.0
     */
    public void setString(String key, Object value) {
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
     * 从 Redis 中获取字符串
     *
     * @param key 键
     * @return 字符串值，如果不存在则返回 null
     * @since 1.0
     */
    public String getString(String key) {
        // 调用 StringRedisTemplate 的 get 方法，从 Redis 中获取字符串
        return stringRedisTemplate.opsForValue().get(key);
    }

    /**
     * 从 Redis 中获取 JSON 字符串并反序列化为对象
     *
     * @param key   键
     * @param clazz 值的类型（Class 对象）
     * @return 反序列化后的对象，如果不存在则返回 null
     * @since 1.0
     */
    public <T> T getString(String key, Class<T> clazz) {
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

    /**
     * 将 redis 中的字符串删除
     */
    public void deleteString(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * 将 Map 集合存储到 Redis 中的 Hash 类型
     *
     * @param key 键
     * @param map 值（Map 集合）
     * @since 1.0
     */
    public void setHash(String key, Map<String, String> map) {
        // 调用 StringRedisTemplate 的 opsForHash 方法，获取 HashOperations 对象
        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        // 调用 putAll 方法，将 Map 集合存储到 Redis 中的 Hash 类型
        hashOperations.putAll(key, map);
    }

    /**
     * 将对象转换为 JSON 字符串后存储到 Redis 中的 Hash 类型
     *
     * @param key     键
     * @param hashKey 哈希键
     * @param object  值（对象）
     * @since 1.0
     */
    public void setHash(String key, String hashKey, Object object) {
        // 调用 StringRedisTemplate 的 opsForHash 方法，获取 HashOperations 对象
        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        // 调用 put 方法，将对象转换为 JSON 字符串后存储到 Redis 中的 Hash 类型（键值对）
        try {
            // 将对象转换为 JSON 字符串
            hashOperations.put(key, hashKey, objectMapper.writeValueAsString(object));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 从 Redis 中获取 Hash 类型的数据，并转换为 Map 集合
     *
     * @param key 键
     * @return Map 集合，如果不存在则返回 null
     * @since 1.0
     */
    public Map<String, String> getHash(String key) {
        // 调用 StringRedisTemplate 的 opsForHash 方法，获取 HashOperations 对象
        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        // 调用 entries 方法，从 Redis 中获取 Hash 类型的数据，并转换为 Map 集合
        return hashOperations.entries(key);
    }

    /**
     * 从 Redis 中获取 Hash 类型的数据，并转换为对象
     *
     * @param key     键
     * @param hashKey 哈希键
     * @param clazz   对象类型（Class 对象）
     * @return 对象，如果不存在则返回 null
     * @since 1.0
     */
    public <T> T getHash(String key, String hashKey, Class<T> clazz) {
        // 调用 StringRedisTemplate 的 opsForHash 方法，获取 HashOperations 对象
        HashOperations<String, String, String> hashOperations = stringRedisTemplate.opsForHash();
        // 调用 get 方法，从 Redis 中获取 Hash 类型的数据，并转换为 JSON 字符串
        String json = hashOperations.get(key, hashKey);
        // 判断 JSON 字符串是否为空或空字符串，如果是则返回 null
        if (json == null || json.isEmpty()) {
            return null;
        }
        try {
            // 将 JSON 字符串转换为对象并返回
            return objectMapper.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

package com.zzk.entrance.hutool;

import com.zzk.utils.JwtUtils;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Hutool工具包JWT测试类<br>
 * <p>
 * <p>
 * 1.0版本：Hutool工具包JWT测试类构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2021-03-27 14:28
 */
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JwtUtilsText {

    // 测试用jwt字符串
    private static String jwtValue;

    /**
     * 测试生成JWT
     *
     * @apiNote 使用Hutool工具包中的JWTUtil工具类, 生成JWT
     * @since 1.0
     */
    @Test
    @Order(1)
    void getJwt() {
        jwtValue = JwtUtils.generateToken("admin", "admin");
        System.out.println(jwtValue);
    }

    /**
     * 测试解析JWT
     *
     * @apiNote 使用Hutool工具包中的JWTUtil工具类, 解析JWT
     * @since 1.0
     */
    @Test
    @Order(2)
    void parseJwt() {
        System.out.println(JwtUtils.verifyToken(jwtValue));
    }
}

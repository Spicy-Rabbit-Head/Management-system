package com.zzk.entrance.securityTexts;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 安全框架密码编码器测试<br>
 * <p>
 * <p>
 * 1.0版本：测试密码编码器<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-23 15:56
 */

@SpringBootTest
public class PasswordEncoderText {
    // 密码编码器
    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * 密码编码测试<br>
     *
     * @apiNote 通过密码编码器的encode方法进行编码<br>
     * @since 1.0
     */
    @Test
    void EncoderText() {
        String encode1 = passwordEncoder.encode("123456");
        String encode2 = passwordEncoder.encode("123456");
        System.out.println(encode1);
        System.out.println(encode2);
    }

    /**
     * 密码比较测试<br>
     *
     * @apiNote 通过密码编码器的matches方法进行比较<br>
     * @since 1.0
     */
    @Test
    void MatchesText() {
        System.out.println(passwordEncoder.matches("123456", "$2a$10$r3EDy4dhh3QYoGNHPJu9PeSvmhJcamaKOY9I6Rxr6RTyCRY1wm8JS"));
    }
}

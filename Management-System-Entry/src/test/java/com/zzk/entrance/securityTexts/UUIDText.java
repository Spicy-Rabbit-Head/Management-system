package com.zzk.entrance.securityTexts;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

/**
 * UUID 测试类<br>
 * <p>
 * <p>
 * 1.0版本：UUID 测试类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-05-14 18:11
 */
@SpringBootTest
public class UUIDText {
    @Test
    void UUIDPrint() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }
}

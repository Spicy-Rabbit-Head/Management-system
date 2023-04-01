package com.zzk.entrance;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * 模块入口
 * <p>
 * 1. @SpringBootApplication：标注一个主程序类，说明这是一个Spring Boot应用
 * <p>
 * 2. @ComponentScan：组件扫描，扫描所有的组件，包括配置类
 * <p>
 * 3. @MapperScan：扫描所有的Mapper接口
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-02-20 19:01
 */

@Slf4j
@SpringBootApplication
// 开启方法级别的安全认证
// @EnableMethodSecurity(securedEnabled = true, jsr250Enabled = true)
// 组件扫描
@ComponentScan(basePackages = "com.zzk")
@MapperScan(basePackages = "com.zzk.dao")
// @ConfigurationPropertiesScan(basePackages = "com.zzk")
public class ModuleEntranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleEntranceApplication.class, args);
    }
}

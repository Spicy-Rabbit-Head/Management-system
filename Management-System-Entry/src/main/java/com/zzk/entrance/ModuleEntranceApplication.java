package com.zzk.entrance;

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
 * @since 2021-02-20 19:01
 */

@SpringBootApplication
// 组件扫描
@ComponentScan(basePackages = "com.zzk")
@MapperScan(basePackages = "com.zzk.dao")
public class ModuleEntranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleEntranceApplication.class, args);
    }
}

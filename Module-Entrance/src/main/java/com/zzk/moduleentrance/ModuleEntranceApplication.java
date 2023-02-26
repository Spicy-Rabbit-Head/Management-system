package com.zzk.moduleentrance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 组件扫描
@ComponentScan(basePackages = "com.zzk")
public class ModuleEntranceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ModuleEntranceApplication.class, args);
    }

}

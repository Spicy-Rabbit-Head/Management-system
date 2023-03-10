package com.zzk.config;

import com.alibaba.druid.spring.boot.autoconfigure.properties.DruidStatProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties // 开启配置属性支持
public class DruidConfig {
    // @Bean
    @ConfigurationProperties(prefix = "spring.datasource") // 读取配置文件中以spring.datasource.druid开头的配置
    public DruidStatProperties druidProperties() {
        return new DruidStatProperties();
    }
}

package com.zzk.entity.record;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@ConfigurationProperties(prefix = "jwt")
@EnableConfigurationProperties(JwtRecord.class)
public record JwtRecord(String key) {

}

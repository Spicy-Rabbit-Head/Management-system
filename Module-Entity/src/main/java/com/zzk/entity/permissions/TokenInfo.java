package com.zzk.entity.permissions;

/**
 * Token 信息记录类<br>
 * <p>
 * <p>
 * 1.0版本：Token 信息记录类构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2023-04-07 13:43
 */
public record TokenInfo(String name, String role) {
    @Override
    public String toString() {
        return "TokenInfo{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}

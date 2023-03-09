package com.zzk.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 统一响应实体类
 *
 * @param <T> 响应数据类型
 * @author zhaozikui
 * @since 2021-03-05 16:00
 */
@Data
@AllArgsConstructor
public class R<T> {
    private Integer code; // 响应码
    private String message; // 响应消息
    private T data; // 响应数据

    public R(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}

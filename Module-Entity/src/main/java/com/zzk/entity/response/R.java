package com.zzk.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 统一响应实体类<br>
 * <p>
 * <p>
 * 1.0版本：使用泛型实现响应数据的类型转换 , 以及响应数据的封装<br>
 * <p>
 *
 * @param <T> 响应数据类型
 * @author zhaozikui
 * @version 1.0
 * @since 2021-03-06 16:00
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

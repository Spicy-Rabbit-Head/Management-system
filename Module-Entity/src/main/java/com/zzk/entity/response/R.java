package com.zzk.entity.response;

import lombok.AllArgsConstructor;
import lombok.Data;

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

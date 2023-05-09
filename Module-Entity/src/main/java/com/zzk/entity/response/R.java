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
 * @author zhaozikui
 * @version 1.0
 * @since 2023-03-06 16:00
 */
@Data
@AllArgsConstructor
public class R {
    // 响应码
    private Integer code;
    // 响应消息
    private String message;
    // 响应状态
    private Boolean status;
    // 响应数据
    private Object data;

    public R(Integer code, String message, Boolean status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }
}

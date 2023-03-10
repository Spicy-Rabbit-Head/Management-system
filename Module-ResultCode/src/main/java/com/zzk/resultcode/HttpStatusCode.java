package com.zzk.resultcode;

/**
 * 系统状态码<br>
 * 错误码：10000 - 10499 系统错误<br>
 * 提示码：10500 - 10999 系统提示<br>
 * <p>
 * <p>
 * 1.0版本：HTTP状态码构建<br>
 * <p>
 *
 * @author zhaozikui
 * @version 1.0
 * @since 2021-03-08 20:31
 */
public enum HttpStatusCode {
    /**
     * 系统HTTP错误
     *
     * @since 1.0
     */
    SYSTEM_HTTP_ERROR_ADD_FAIL(11000, "添加用户失败"),

    /**
     * 系统HTTP提示
     * @since 1.0
     */
    SYSTEM_HTTP_INFO_ADD_SUCCESS(11001, "添加用户成功");

    private final Integer code;
    private final String message;

    HttpStatusCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

package com.zzk.resultcode;

/**
 * 系统状态码
 *
 * @author zhaozikui
 * @since 2021-03-08 19:39
 * 10000 - 11000 系统状态码
 */
public enum SystemStatusCode {
    /**
     * 错误
     * 10000 - 10499 系统错误
     */
    SYSTEM_USER_ERROR_ADD_FAIL(10000, "添加用户失败"),

    /**
     * 提示
     * 10500 - 10999 系统提示
     */
    SYSTEM_USER_INFO_ADD_SUCCESS(10001, "添加用户成功");

    private final Integer code;
    private final String message;

    SystemStatusCode(int code, String message) {
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

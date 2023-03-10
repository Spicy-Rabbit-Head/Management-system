package com.zzk.resultcode;

/**
 * 系统状态码<br>
 * 错误码：10000 - 10499 系统错误<br>
 * 提示码：10500 - 10999 系统提示<br>
 * <p>
 * <p>
 * 1.0版本：系统状态码构建<br>
 * <p>
 *
 * @author zhaozikui
 * @since 2021-03-08 19:39
 */
public enum SystemStatusCode {
    /**
     * 系统错误添加用户失败
     *
     * @since 1.0
     */
    SYSTEM_USER_ERROR_ADD_FAIL(10000, "添加用户失败"),

    /**
     * 系统提示添加用户成功
     * @since 1.0
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

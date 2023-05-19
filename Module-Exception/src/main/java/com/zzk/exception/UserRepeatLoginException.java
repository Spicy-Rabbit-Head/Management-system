package com.zzk.exception;

/**
 * 用户重复登录异常类<br>
 * <p>
 * <p>
 * 1.0版本：用户重复登录异常类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-05-18 21:31
 */
public class UserRepeatLoginException extends RuntimeException {
    public UserRepeatLoginException(String message) {
        super(message);
    }
}

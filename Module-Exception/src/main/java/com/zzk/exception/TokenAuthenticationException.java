package com.zzk.exception;

/**
 * Token 验证异常类<br>
 * <p>
 * <p>
 * 1.0版本：Token 验证异常类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-05-18 21:28
 */
public class TokenAuthenticationException extends RuntimeException {
    public TokenAuthenticationException(String message) {
        super(message);
    }
}

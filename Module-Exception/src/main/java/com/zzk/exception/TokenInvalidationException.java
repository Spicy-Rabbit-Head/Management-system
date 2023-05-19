package com.zzk.exception;

/**
 * Token 失效异常类<br>
 * <p>
 * <p>
 * 1.0版本：Token 失效异常类构建<br>
 * <p>
 *
 * @author zhao'zi'kui
 * @version 1.0
 * @since 2023-05-18 21:30
 */

public class TokenInvalidationException extends RuntimeException {
    public TokenInvalidationException(String message) {
        super(message);
    }
}

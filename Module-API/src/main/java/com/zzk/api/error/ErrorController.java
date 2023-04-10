package com.zzk.api.error;

import com.zzk.exception.TokenAuthenticationException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error")
public class ErrorController {

    @RequestMapping("/tokenError")
    public void error() {
        throw new TokenAuthenticationException("Token 异常");
    }
}

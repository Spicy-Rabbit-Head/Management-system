package com.zzk.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Text")
public class TextController {
    // 测试
    @GetMapping("/getUser")
    @PreAuthorize("hasAuthority('USER:EXPENSE:FILLIN')")
    public String text1() {
        return "on";
    }

    // 测试
    @GetMapping("/getSys")
    @PreAuthorize("hasAnyAuthority('user:expense:fillIn','ROLE_SYS')")
    public String text2() {
        return "off";
    }
}

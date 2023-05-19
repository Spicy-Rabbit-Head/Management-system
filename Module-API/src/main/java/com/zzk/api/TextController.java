package com.zzk.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Text")
@PreAuthorize("hasRole('ROLE_USER')")
public class TextController {

    // 测试
    @GetMapping("/getUser")
    @PreAuthorize("hasAnyAuthority('SCHEDULING:SELECT')")
    public String text1() {
        return "on";
    }

    // 测试
    @GetMapping("/getSys")
    @PreAuthorize("hasAnyAuthority('EXPENSE:UPDATE')")
    public String text2() {
        return "off";
    }
}

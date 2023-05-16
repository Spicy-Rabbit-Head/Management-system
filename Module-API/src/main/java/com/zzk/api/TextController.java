package com.zzk.api;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Text")
public class TextController {
    @GetMapping("/getUser")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String text1() {
        return "on";
    }

    @GetMapping("/getSys")
    @PreAuthorize("hasAuthority('ROLE_SYS')")
    public String text2() {
        return "off";
    }
}

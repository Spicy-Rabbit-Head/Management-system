package com.zzk.api;

import com.zzk.service.TextService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Text")
public class TextController {
    private final TextService service;


    public TextController(TextService service) {
        this.service = service;
    }

    @GetMapping("/gettext")
    public String text() {
        service.Print();
        return "ok";
    }
}

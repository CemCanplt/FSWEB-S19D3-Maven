package com.workintech.s19d2.controller;

import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/welcome")
@AllArgsConstructor
@RestController
@Validated
public class WelcomeController {

    @GetMapping
    public String welcome() {
        return "Welcome";
    }

}

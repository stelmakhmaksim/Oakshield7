package com.dms.lab7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/constructor")
public class ConstructorController {

    @GetMapping
    public String main() {
        return "constructor";
    }
}
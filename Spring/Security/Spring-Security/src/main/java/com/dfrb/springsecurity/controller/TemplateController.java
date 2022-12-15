package com.dfrb.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {
    @GetMapping(path = "login")
    public String getLogin() {
        return "login";
    }

    @GetMapping(path = "products")
    public String getProducts() {
        return "products";
    }
}

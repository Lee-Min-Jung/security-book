package com.example.securitybook.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MainPageController {

    @GetMapping("/hello")
    public String hello(){
        return "get hello";
    }

    @PostMapping("/hello")
    public String postHello(){
        return "post hello";
    }
}

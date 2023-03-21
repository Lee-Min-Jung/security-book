package com.example.securitybook.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainPageController {

    @GetMapping("/hello")
    public String hello(){
        return "hello!";
    }

    @GetMapping("/ciao")
    public String ciao(){
        return "ciao!";
    }

    @GetMapping("/hola")
    public String hola(){
        return "hola!";
    }
}

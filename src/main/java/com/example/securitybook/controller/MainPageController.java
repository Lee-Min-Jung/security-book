package com.example.securitybook.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainPageController {

    @PostMapping("/a")
    public String postEndPointA(){
        return "Works!";
    }

    @GetMapping("/a")
    public String getEndPointA(){
        return "Works!";
    }

    @GetMapping("/a/b")
    public String getEnpintB(){
        return "Works!";
    }

    @GetMapping("a/b/c")
    public String getEnpointC(){
        return "Works!";
    }
}

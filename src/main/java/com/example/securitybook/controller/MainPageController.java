package com.example.securitybook.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainPageController {

    @GetMapping("/video/{country}/{language}")
    public String video(@PathVariable String country, @PathVariable String language) {
        return "Video allowed for" + country + " " + language;
    }
}

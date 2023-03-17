package com.example.securitybook.controller;

import com.example.securitybook.entity.Product;
import com.example.securitybook.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainPageController {

    @Autowired
    private ProductService productService;

    @GetMapping("/main")
    public List<Product> main(Authentication a){
        return productService.findAll();
    }
}

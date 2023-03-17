package com.example.securitybook.service;

import com.example.securitybook.entity.Product;
import com.example.securitybook.repository.ProductRepository;
import com.example.securitybook.repository.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ProductServiceTest {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductService productService;

    @Test
    public void 제품목록() throws Exception{
        //Given

        //When
        List<Product> productList = productService.findAll();
        //Then
        Assertions.assertThat(productList).isEqualTo(productRepository.findAll());
    }
}
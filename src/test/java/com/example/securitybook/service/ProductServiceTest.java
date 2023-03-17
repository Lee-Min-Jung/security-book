package com.example.securitybook.service;

import com.example.securitybook.entity.Product;
import com.example.securitybook.entity.enums.Currency;
import com.example.securitybook.repository.ProductRepository;
import com.example.securitybook.repository.UserRepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
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
    @DisplayName("제품목록 성공 테스트")
    public void 제품목록() throws Exception{
        //Given

        //When
        List<Product> productList = productService.findAll();
        //Then
        Assertions.assertThat(productList).isEqualTo(productRepository.findAll());
    }

    @Test
    @DisplayName("제품목록 실패 테스트")
    public void 제품목록오류() throws Exception{
        //Given
        Product p = new Product(10, "apple", 10, Currency.USD);
        //When
        List<Product> productList = new ArrayList<>();
        productList.add(p);
        //Then
        Assertions.assertThat(productList).isNotEqualTo(productRepository.findAll());
    }
}
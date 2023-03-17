package com.example.securitybook.controller;

import com.example.securitybook.entity.User;
import com.example.securitybook.entity.enums.EncryptionAlgorithm;
import com.example.securitybook.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class MainPageControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Autowired
    private UserRepository userRepository;


    @Test
    @DisplayName("로그인 성공")
    public void 로그인성공() throws Exception{
        // given
        String username = "john";
        String password = "12345";

        // when
        mockMvc.perform(formLogin().user(username).password(password))
                .andDo(print())

        // then
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/main"));
    }

    @Test
    @DisplayName("로그인 실패")
    public void 로그인실패() throws Exception{
        // given
        String username = "john";
        String password = "123456";

        // when
        mockMvc.perform(formLogin().user(username).password(password))
                .andDo(print())

                // then
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/login?error"));
    }



}
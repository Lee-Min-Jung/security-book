package com.example.securitybook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {
// UserDetailService와 PasswordEncoder를 configure로 설정
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // 사용자를 메모리에 저장하기 위해
        var userDetailService = new InMemoryUserDetailsManager();

        // 새 사용자 생성
        var user = User.withUsername("john")
                .password("12345")
                .authorities("read")
                .build();

        // userDetailService에서 관리하도록 사용자 추가
        userDetailService.createUser(user);

        // userDetailService 및 PasswordEncoder 구성
        auth.userDetailsService(userDetailService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    // 권한 부여 등에 변경사항을 주고 싶을 때 WebSecurityConfigureAdapter를 확장 한 후 configure 메서드를 오버라이드
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .anyRequest().authenticated();

    }
}

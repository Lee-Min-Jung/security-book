package com.example.securitybook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
    @Bean
    public UserDetailsService userDetailsService(){
        // userDetailService를 재정의 하기 위해 스프링 시큐리티에 구현되어 있는 InMemoryUserDetailManager를 사용
        var userDetailService = new InMemoryUserDetailsManager();

        // 사용자 이름 및 암호가 있는 사용자 만들기
        var user = User.withUsername("john")
                .password("12345")
                .authorities("read")
                .build();
        // 사용자를 UserDetailService에서 관리하도록 추가
        userDetailService.createUser(user);

        return userDetailService;
    }
    // UserDetailService를 재정의해서 passwordEncoder도 재정의 해야 함
    @Bean
    public PasswordEncoder passwordEncoder(){
        // NoOpPasswordEncoder는 암호에 암호화나 해시를 적용하지 않고 일반 텍스트처럼 처리한다. 그래서 운영 단계에서 사용하면 안 되기 때문에
        // 클래스 개발자가 deprecated라고 지정해놓음.
        return NoOpPasswordEncoder.getInstance();
    }

    // 권한 부여 등에 변경사항을 주고 싶을 때 WebSecurityConfigureAdapter를 확장 한 후 configure 메서드를 오버라이드
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .anyRequest().authenticated();
//        http.authorizeRequests()
//                .anyRequest().permitAll();
    }
}

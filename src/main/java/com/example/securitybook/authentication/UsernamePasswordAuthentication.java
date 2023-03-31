package com.example.securitybook.authentication;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
//UsernamePasswordAuthenticationToken은 Authentication 인터페이스의 구현 클래스 중 하나

public class UsernamePasswordAuthentication extends UsernamePasswordAuthenticationToken {
    public UsernamePasswordAuthentication(Object principal, Object credentials, Collection<? extends GrantedAuthority> authorities){
        super(principal, credentials, authorities);
    }

    public UsernamePasswordAuthentication(Object principal, Object credentials){
        super(principal, credentials);
    }
}

package com.example.securitybook.repository;

import com.example.securitybook.entity.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaTokenRepository extends JpaRepository<Token, Integer> {
    Optional<Token> findTokenByIdentifier(String identifier);
}


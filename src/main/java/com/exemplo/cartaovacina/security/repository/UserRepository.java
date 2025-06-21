package com.exemplo.cartaovacina.security.repository;

import com.exemplo.cartaovacina.security.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

// Esse é o repositório de usuários
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
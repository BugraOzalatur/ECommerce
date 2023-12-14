package com.bulutmd.authService.repository;

import com.bulutmd.authService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    User getUserByEmail(String email);
}

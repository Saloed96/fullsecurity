package com.example.demo.auth;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface ApplicationUserDao {

    Optional<ApplicationUser> selectUserByUsername(String username);
}

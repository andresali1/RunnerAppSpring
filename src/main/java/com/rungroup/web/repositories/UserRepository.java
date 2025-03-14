package com.rungroup.web.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rungroup.web.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findByEmail(String email);

    UserEntity findByUsername(String username);
}

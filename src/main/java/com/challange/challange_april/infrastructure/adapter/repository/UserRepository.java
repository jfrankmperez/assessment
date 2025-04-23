package com.challange.challange_april.infrastructure.adapter.repository;

import com.challange.challange_april.domain.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByEmail (String email);
}

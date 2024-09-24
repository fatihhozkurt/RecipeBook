package com.fatih.recipeBook.repository;

import java.util.Optional;
import java.util.UUID;

import com.fatih.recipeBook.entity.UserEntity;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, UUID> {

  Optional<UserEntity> findByEmail(String email);

  Optional<UserEntity> findByPhone(String phone);
}

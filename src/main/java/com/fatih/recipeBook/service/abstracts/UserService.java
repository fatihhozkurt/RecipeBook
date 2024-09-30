package com.fatih.recipeBook.service.abstracts;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.entity.UserEntity;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
  void createUser(UserEntity requestEntity);

  UserEntity updateUser(UserEntity requestEntity, UUID uuid);

  void deleteUser(UUID uuid);

  List<UserEntity> getAllUsers();

  UserEntity getUserById(UUID uuid);
}

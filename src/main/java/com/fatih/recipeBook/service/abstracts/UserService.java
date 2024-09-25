package com.fatih.recipeBook.service.abstracts;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.entity.UserEntity;

import org.springframework.stereotype.Service;

@Service
public interface UserService {
  UserEntity createUser(UserEntity userEntity);

  UserEntity getUserById(UUID id);

  List<UserEntity> getAllUsers();

  UserEntity updateUser(UserEntity requestedUserEntity, UUID id);

  void deleteUser(UUID id);
}

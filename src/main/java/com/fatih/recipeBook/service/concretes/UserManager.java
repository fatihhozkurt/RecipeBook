package com.fatih.recipeBook.service.concretes;

import static com.fatih.recipeBook.constants.SoftDeleteConstants.ACTIVE;
import static com.fatih.recipeBook.constants.SoftDeleteConstants.PASSIVE;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.entity.UserEntity;
import com.fatih.recipeBook.exception.DataAlreadyExistException;
import com.fatih.recipeBook.exception.ResourceNotFoundException;
import com.fatih.recipeBook.mapper.UserMapper;
import com.fatih.recipeBook.repository.UserRepository;
import com.fatih.recipeBook.service.abstracts.UserService;

import org.springframework.stereotype.Service;

@Service
public class UserManager implements UserService {

  private final UserRepository userRepository;

  public UserManager(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public void createUser(UserEntity requestEntity) {
    userRepository.findByPhone(requestEntity.getPhone()).ifPresent(existing -> {
      throw new DataAlreadyExistException("This phone is already in use with another account!");
    });

    userRepository.findByEmail(requestEntity.getEmail()).ifPresent(existing -> {
      throw new DataAlreadyExistException("This email is already in use with another account!");
    });

    requestEntity.setRecordStatus(ACTIVE);
    userRepository.save(requestEntity);
  }

  @Override
  public UserEntity updateUser(UserEntity requestEntity, UUID uuid) {
    UserEntity existingUser =
        userRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("User not found!"));

    userRepository.findByEmail(requestEntity.getEmail()).ifPresent(existingRequestEmail -> {
      throw new DataAlreadyExistException("This email is already in use with another account!");
    });

    userRepository.findByPhone(requestEntity.getPhone()).ifPresent(existingRequestPhone -> {
      throw new DataAlreadyExistException("This phone is already in use with another account!");
    });

    UserMapper.INSTANCE.updateUserFromRequest(requestEntity, existingUser);

    return userRepository.save(existingUser);
  }

  @Override
  public void deleteUser(UUID uuid) {
    UserEntity existingUser =
        userRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("User not found!"));

    existingUser.setRecordStatus(PASSIVE);
  }

  @Override
  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
  }
}
package com.fatih.recipeBook.service.concretes;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.entity.UserEntity;
import com.fatih.recipeBook.exception.DataAlreadyExistException;
import com.fatih.recipeBook.exception.ResourceNotFoundException;
import com.fatih.recipeBook.mapper.UserMapper;
import com.fatih.recipeBook.repository.CategoryRepository;
import com.fatih.recipeBook.repository.UserRepository;
import com.fatih.recipeBook.service.abstracts.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserManager implements UserService {

  private final UserRepository userRepository;

  public UserManager(UserRepository userRepository, CategoryRepository categoryRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional
  public UserEntity createUser(UserEntity userEntity) {

    userRepository.findByEmail(userEntity.getEmail()).ifPresent(existingUser -> {
      throw new DataAlreadyExistException("This email already exists");
    });

    userRepository.findByPhone(userEntity.getPhone()).ifPresent(existingUser -> {
      throw new DataAlreadyExistException("This phone already exists");
    });

    userEntity.setRecordStatus(0);
    return userRepository.save(userEntity);
  }

  @Override
  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public UserEntity getUserById(UUID id) {
    return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User ID!"));
  }

  @Override
  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  @Transactional
  public UserEntity updateUser(UserEntity requestedUserEntity, UUID id) {
    UserEntity existingUserEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid User ID!"));

    UserMapper.INSTANCE.updateToExistingUserWithIgnoreNulls(requestedUserEntity, existingUserEntity);

    existingUserEntity.setRecordStatus(0);
    return userRepository.save(existingUserEntity);
    }
}
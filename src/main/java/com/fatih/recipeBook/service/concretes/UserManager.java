package com.fatih.recipeBook.service.concretes;

import static com.fatih.recipeBook.constants.SoftDeleteConstants.ACTIVE;
import static com.fatih.recipeBook.constants.SoftDeleteConstants.PASSIVE;

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
      throw new DataAlreadyExistException("This email is already exists");
    });

    userRepository.findByPhone(userEntity.getPhone()).ifPresent(existingUser -> {
      throw new DataAlreadyExistException("This phone is already exists");
    });

    userEntity.setRecordStatus(ACTIVE);
    return userRepository.save(userEntity);
  }

  @Override
  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public UserEntity getUserById(UUID id) {
    return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trying to get an invalid user ID!"));
  }

  @Override
  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public List<UserEntity> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  @Transactional
  public UserEntity updateUser(UserEntity requestedUserEntity, UUID id) {
    UserEntity existingUserEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trying to update an invalid user ID!"));

    UserMapper.INSTANCE.updateToExistingUserWithIgnoreNulls(requestedUserEntity, existingUserEntity);

    existingUserEntity.setRecordStatus(ACTIVE);
    return userRepository.save(existingUserEntity);
    }

  @Override
  @Transactional
  public void deleteUser(UUID id) {
    UserEntity userEntity = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trying to delete an invalid user ID!"));
    userEntity.setRecordStatus(PASSIVE);
  }
}
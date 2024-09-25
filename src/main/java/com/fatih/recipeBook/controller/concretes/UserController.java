package com.fatih.recipeBook.controller.concretes;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import com.fatih.recipeBook.controller.abstracts.UserApi;
import com.fatih.recipeBook.dto.request.user.CreateUserRequest;
import com.fatih.recipeBook.dto.request.user.UpdateUserRequest;
import com.fatih.recipeBook.dto.response.user.UserCardResponse;
import com.fatih.recipeBook.dto.response.user.UserResponse;
import com.fatih.recipeBook.entity.UserEntity;
import com.fatih.recipeBook.mapper.UserMapper;
import com.fatih.recipeBook.service.abstracts.UserService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Override
  public ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest) {
    UserEntity userEntity = UserMapper.INSTANCE.toCreateEntity(createUserRequest);
    UserEntity savedUserEntity = userService.createUser(userEntity);
    UserResponse userResponse = UserMapper.INSTANCE.toUserResponse(savedUserEntity);
    return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<UserResponse> getUserById(UUID id) {

    UserEntity userEntity = userService.getUserById(id);
    UserResponse userResponse = UserMapper.INSTANCE.toUserResponse(userEntity);
    return new ResponseEntity<>(userResponse,HttpStatus.FOUND);
  }

  @Override
  public ResponseEntity<List<UserResponse>> getAllUsers() {
    List<UserEntity> userEntity = userService.getAllUsers();
    List<UserResponse> userResponse = UserMapper.INSTANCE.toUserResponseList(userEntity);
    return new ResponseEntity<>(userResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<UserCardResponse> getUserCardById(UUID id) {
    UserEntity userEntity = userService.getUserById(id);
    UserCardResponse userCardResponse = UserMapper.INSTANCE.toUserCardResponse(userEntity);
    return new ResponseEntity<>(userCardResponse, HttpStatus.FOUND);
  }

  @Override
  public ResponseEntity<UserResponse> updateUser(UpdateUserRequest updateUserRequest, UUID id) {
    UserEntity userEntity = UserMapper.INSTANCE.toUpdateEntity(updateUserRequest);
    UserEntity updatedUser = userService.updateUser(userEntity,id);
    UserResponse userResponse = UserMapper.INSTANCE.toUserResponse(updatedUser);
    return new ResponseEntity<>(userResponse, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<HttpStatus> deleteUser(UUID id) {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}

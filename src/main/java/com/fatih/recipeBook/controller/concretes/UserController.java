package com.fatih.recipeBook.controller.concretes;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.controller.abstracts.UserApi;
import com.fatih.recipeBook.dto.request.user.CreateUserRequest;
import com.fatih.recipeBook.dto.request.user.UpdateUserRequest;
import com.fatih.recipeBook.dto.response.user.UserUpdateResponse;
import com.fatih.recipeBook.entity.UserEntity;
import com.fatih.recipeBook.mapper.UserMapper;
import com.fatih.recipeBook.service.abstracts.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController implements UserApi {

  @Autowired
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @Override
  public ResponseEntity<HttpStatus> createUser(CreateUserRequest createUserRequest) {
    ;
    UserEntity requestEntity = UserMapper.INSTANCE.toUserEntity(createUserRequest);
    userService.createUser(requestEntity);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<UserUpdateResponse> updateUser(UpdateUserRequest updateUserRequest, UUID uuid) {
    UserEntity requestEntity = UserMapper.INSTANCE.toUserEntity(updateUserRequest);
    UserEntity updatedUser = userService.updateUser(requestEntity, uuid);
    UserUpdateResponse userUpdateResponse = UserMapper.INSTANCE.toUserUpdateResponse(updatedUser);
    return new ResponseEntity<>(userUpdateResponse, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<HttpStatus> deleteUser(UUID uuid) {
    userService.deleteUser(uuid);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<List<UserBaseResponse>> getAllBaseUsers() {
    List<UserEntity> allUsers = userService.getAllUsers();
    List<UserBaseResponse> userBaseResponses = UserMapper.INSTANCE.toUserBaseResponseList(allUsers);
    return new ResponseEntity<>(userBaseResponses, HttpStatus.OK);
  }
}

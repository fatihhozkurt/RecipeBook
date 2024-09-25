package com.fatih.recipeBook.controller.abstracts;

import static com.fatih.recipeBook.constants.URLConstants.ALL;
import static com.fatih.recipeBook.constants.URLConstants.BASE;
import static com.fatih.recipeBook.constants.URLConstants.CARD;
import static com.fatih.recipeBook.constants.URLConstants.ID;
import static com.fatih.recipeBook.constants.URLConstants.PAGE;
import static com.fatih.recipeBook.constants.URLConstants.REQUEST;
import static com.fatih.recipeBook.constants.URLConstants.USER;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import com.fatih.recipeBook.dto.request.user.CreateUserRequest;
import com.fatih.recipeBook.dto.request.user.UpdateUserRequest;
import com.fatih.recipeBook.dto.response.user.UserCardResponse;
import com.fatih.recipeBook.dto.response.user.UserResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping(USER)
public interface UserApi {

  @PostMapping(BASE + REQUEST)
  ResponseEntity<UserResponse> createUser(@Valid @RequestBody CreateUserRequest createUserRequest);

  @PutMapping(BASE + REQUEST + ID)
  ResponseEntity<UserResponse> updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest,
                                          @RequestParam UUID id);

  @DeleteMapping(BASE + ID)
  ResponseEntity<HttpStatus> deleteUser(@Valid @RequestParam UUID id);

  @GetMapping(BASE + ID)
  ResponseEntity<UserResponse> getUserById(@RequestParam("id") UUID id);

  @GetMapping(BASE + ALL)
  ResponseEntity<List<UserResponse>> getAllUsers();

  @GetMapping(PAGE + ID)
  ResponseEntity<UserCardResponse> getUserCardById(@RequestParam("id") UUID id);
}
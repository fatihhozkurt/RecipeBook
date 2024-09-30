package com.fatih.recipeBook.controller.abstracts;

import static com.fatih.recipeBook.constants.URLConstants.ALL;
import static com.fatih.recipeBook.constants.URLConstants.BASE;
import static com.fatih.recipeBook.constants.URLConstants.ID;
import static com.fatih.recipeBook.constants.URLConstants.PAGE;
import static com.fatih.recipeBook.constants.URLConstants.REQUEST;
import static com.fatih.recipeBook.constants.URLConstants.USER;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import com.fatih.recipeBook.dto.request.user.CreateUserRequest;
import com.fatih.recipeBook.dto.request.user.UpdateUserRequest;
import com.fatih.recipeBook.dto.response.user.UserBaseResponse;
import com.fatih.recipeBook.dto.response.user.UserPageResponse;
import com.fatih.recipeBook.dto.response.user.UserUpdateResponse;

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

  @PostMapping(PAGE + REQUEST)
  ResponseEntity<HttpStatus> createUser(@Valid @RequestBody CreateUserRequest createUserRequest);

  @PutMapping(PAGE + REQUEST)
  ResponseEntity<UserUpdateResponse> updateUser(@Valid @RequestBody UpdateUserRequest updateUserRequest,
                                                @RequestParam UUID uuid);

  @DeleteMapping(BASE + ID)
  ResponseEntity<HttpStatus> deleteUser(@RequestParam UUID uuid);

  @GetMapping(BASE + ALL)
  ResponseEntity<List<UserBaseResponse>> getAllBaseUsers();

  @GetMapping(BASE + ID)
  ResponseEntity<UserBaseResponse> getBaseUserById(@RequestParam UUID uuid);

  @GetMapping(PAGE + ID)
  ResponseEntity<UserPageResponse> getPageUserById(@RequestParam UUID uuid);
}

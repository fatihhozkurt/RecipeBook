package com.fatih.recipeBook.controller.abstracts;

import static com.fatih.recipeBook.constants.URLConstants.ALL;
import static com.fatih.recipeBook.constants.URLConstants.BASE;
import static com.fatih.recipeBook.constants.URLConstants.COMMENT;
import static com.fatih.recipeBook.constants.URLConstants.ID;
import static com.fatih.recipeBook.constants.URLConstants.PAGE;
import static com.fatih.recipeBook.constants.URLConstants.RECIPE;
import static com.fatih.recipeBook.constants.URLConstants.REQUEST;
import static com.fatih.recipeBook.constants.URLConstants.USER;

import java.util.List;
import java.util.UUID;

import jakarta.validation.Valid;

import com.fatih.recipeBook.dto.request.comment.CreateCommentRequest;
import com.fatih.recipeBook.dto.response.comment.CommentBaseResponse;
import com.fatih.recipeBook.dto.response.comment.CommentPageResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping(COMMENT)
public interface CommentApi {

  @PostMapping(PAGE + REQUEST)
  ResponseEntity<HttpStatus> createComment(@Valid @RequestBody CreateCommentRequest createCommentRequest);

  @DeleteMapping(PAGE + ID)
  ResponseEntity<HttpStatus> deleteComment(@RequestParam("uuid") UUID uuid);

  @GetMapping(BASE + ALL)
  ResponseEntity<List<CommentBaseResponse>> getAllBaseUsers();

  @GetMapping(BASE + ID)
  ResponseEntity<CommentBaseResponse> getBaseComment(@RequestParam UUID uuid);

  @GetMapping(PAGE + RECIPE + ID)
  ResponseEntity<List<CommentPageResponse>> getAllCommentsByRecipeID(UUID uuid);

  @GetMapping(PAGE + USER + ID)
  ResponseEntity<List<CommentPageResponse>> getAllCommentsByUserID(UUID uuid);
}

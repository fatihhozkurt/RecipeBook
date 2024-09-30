package com.fatih.recipeBook.controller.concretes;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.controller.abstracts.CommentApi;
import com.fatih.recipeBook.dto.request.comment.CreateCommentRequest;
import com.fatih.recipeBook.dto.response.comment.CommentBaseResponse;
import com.fatih.recipeBook.dto.response.comment.CommentPageResponse;
import com.fatih.recipeBook.entity.CommentEntity;
import com.fatih.recipeBook.mapper.CommentMapper;
import com.fatih.recipeBook.service.abstracts.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController implements CommentApi {

  @Autowired
  private final CommentService commentService;

  public CommentController(CommentService commentService) {
    this.commentService = commentService;
  }

  @Override
  public ResponseEntity<HttpStatus> createComment(CreateCommentRequest createCommentRequest) {
    CommentEntity requestEntity = CommentMapper.INSTANCE.toCommentEntity(createCommentRequest);
    commentService.createComment(requestEntity);
    return new ResponseEntity<>(HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<HttpStatus> deleteComment(UUID uuid) {
    commentService.deleteComment(uuid);
    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  @Override
  public ResponseEntity<List<CommentBaseResponse>> getAllBaseUsers() {
    List<CommentEntity> commentEntities = commentService.getAllComments();
    List<CommentBaseResponse> commentBaseResponses = CommentMapper.INSTANCE.toCommentBaseResponseList(commentEntities);
    return new ResponseEntity<>(commentBaseResponses, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<CommentBaseResponse> getBaseComment(UUID uuid) {
    CommentEntity commentEntity = commentService.getCommentById(uuid);
    CommentBaseResponse commentBaseResponse = CommentMapper.INSTANCE.toCommentBaseResponse(commentEntity);
    return new ResponseEntity<>(commentBaseResponse, HttpStatus.FOUND);
  }

  @Override
  public ResponseEntity<List<CommentPageResponse>> getAllCommentsByRecipeID(UUID uuid) {
    List<CommentEntity> commentEntities = commentService.getCommentByRecipeID(uuid);
    List<CommentPageResponse> commentPageResponses = CommentMapper.INSTANCE.toCommentPageResponseList(commentEntities);
    return new ResponseEntity<>(commentPageResponses, HttpStatus.FOUND);
  }

  @Override
  public ResponseEntity<List<CommentPageResponse>> getAllCommentsByUserID(UUID uuid) {
    List<CommentEntity> commentEntities = commentService.getCommentByUserID(uuid);
    List<CommentPageResponse> commentPageResponses = CommentMapper.INSTANCE.toCommentPageResponseList(commentEntities);
    return new ResponseEntity<>(commentPageResponses, HttpStatus.FOUND);
  }

}

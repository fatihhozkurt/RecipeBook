package com.fatih.recipeBook.service.abstracts;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.dto.request.comment.CreateCommentRequest;
import com.fatih.recipeBook.entity.CommentEntity;

import org.springframework.stereotype.Service;

@Service
public interface CommentService {
  void createComment(CommentEntity requestedEntity);

  void deleteComment(UUID uuid);

  List<CommentEntity> getAllComments();

  CommentEntity getCommentById(UUID uuid);

  List<CommentEntity> getCommentByRecipeID(UUID uuid);

  List<CommentEntity> getCommentByUserID(UUID uuid);
}

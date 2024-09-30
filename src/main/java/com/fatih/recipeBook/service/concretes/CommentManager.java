package com.fatih.recipeBook.service.concretes;

import static com.fatih.recipeBook.constants.SoftDeleteConstants.ACTIVE;
import static com.fatih.recipeBook.constants.SoftDeleteConstants.PASSIVE;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.entity.CommentEntity;
import com.fatih.recipeBook.exception.ResourceNotFoundException;
import com.fatih.recipeBook.repository.CommentRepository;
import com.fatih.recipeBook.service.abstracts.CommentService;
import com.fatih.recipeBook.service.abstracts.RecipeService;
import com.fatih.recipeBook.service.abstracts.UserService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CommentManager implements CommentService {

  private final CommentRepository commentRepository;
  private final UserService userService;
  private final RecipeService recipeService;

  public CommentManager(CommentRepository commentRepository, UserService userService, RecipeService recipeService) {
    this.commentRepository = commentRepository;
    this.userService = userService;
    this.recipeService = recipeService;
  }


  @Override
  @Transactional
  public void createComment(CommentEntity requestedEntity) {
    userService.getUserById(requestedEntity.getUser().getId());
    //recipeService.getRecipeById(requestedEntity.getRecipe().getId());

    requestedEntity.setRecordStatus(ACTIVE);
    commentRepository.save(requestedEntity);
  }

  @Override
  public void deleteComment(UUID uuid) {
    CommentEntity commentEntity =
        commentRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("Comment not found!"));

    commentEntity.setRecordStatus(PASSIVE);
    commentRepository.save(commentEntity);
  }

  @Override
  public List<CommentEntity> getAllComments() {
    return commentRepository.findAll();
  }

  @Override
  public CommentEntity getCommentById(UUID uuid) {
    return commentRepository.findById(uuid).orElseThrow(() -> new ResourceNotFoundException("Comment nor found!"));
  }

  @Override
  public List<CommentEntity> getCommentByRecipeID(UUID uuid) {
    //recipeService.getRecipeById(uuid);
    return commentRepository.findAllByRecipeId(uuid);
  }

  @Override
  public List<CommentEntity> getCommentByUserID(UUID uuid) {
    userService.getUserById(uuid);
    return commentRepository.findAllByUserId(userService);
  }
}

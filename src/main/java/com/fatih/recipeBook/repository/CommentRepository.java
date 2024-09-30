package com.fatih.recipeBook.repository;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.entity.CommentEntity;
import com.fatih.recipeBook.service.abstracts.UserService;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {
  List<CommentEntity> findAllByRecipeId(UUID uuid);

  List<CommentEntity> findAllByUserId(UserService userService);
}

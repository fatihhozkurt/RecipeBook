package com.fatih.recipeBook.entity;


import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.SQLRestriction;

@Entity
@SQLRestriction("record_status <> '1'")
@Table(name = "likes")
public class LikeEntity extends BaseEntity {

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "recipe_id")
  private RecipeEntity recipe;

  public LikeEntity(UUID id, Integer recordStatus, LocalDateTime recordStatusChangeTime,
                    LocalDateTime createTime, LocalDateTime updateTime, UserEntity user,
                    RecipeEntity recipe) {
    super(id, recordStatus, recordStatusChangeTime, createTime, updateTime);
    this.user = user;
    this.recipe = recipe;
  }

  public LikeEntity(UserEntity user, RecipeEntity recipe) {
    this.user = user;
    this.recipe = recipe;
  }

  public LikeEntity() {
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public RecipeEntity getRecipe() {
    return recipe;
  }

  public void setRecipe(RecipeEntity recipe) {
    this.recipe = recipe;
  }
}

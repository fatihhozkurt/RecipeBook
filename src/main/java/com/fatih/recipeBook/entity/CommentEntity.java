package com.fatih.recipeBook.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.SQLRestriction;

@Entity
@SQLRestriction("record_status <> '1'")
@Table(name = "comments")
public class CommentEntity extends BaseEntity {

  @Column(name = "title", nullable = false, length = 25)
  private String title;

  @Column(name = "detail", nullable = false, columnDefinition = "TEXT")
  private String detail;

  @ManyToOne(optional = false, fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne
  @JoinColumn(name = "recipe_id")
  private RecipeEntity recipe;

  public CommentEntity(UUID id, Integer recordStatus, LocalDateTime recordStatusChangeTime,
                       LocalDateTime createTime, LocalDateTime updateTime, String title, String detail, UserEntity user,
                       RecipeEntity recipe) {
    super(id, recordStatus, recordStatusChangeTime, createTime, updateTime);
    this.title = title;
    this.detail = detail;
    this.user = user;
    this.recipe = recipe;
  }

  public CommentEntity(String title, String detail, UserEntity user, RecipeEntity recipe) {
    this.title = title;
    this.detail = detail;
    this.user = user;
    this.recipe = recipe;
  }

  public CommentEntity() {
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDetail() {
    return detail;
  }

  public void setDetail(String detail) {
    this.detail = detail;
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


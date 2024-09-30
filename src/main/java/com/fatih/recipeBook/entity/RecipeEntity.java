package com.fatih.recipeBook.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "recipes")
@SQLRestriction("record_status <> '1'")
public class RecipeEntity extends BaseEntity {

  @Column(name = "name", nullable = false, length = 30)
  private String name;

  @Column(name = "description", nullable = false, columnDefinition = "TEXT")
  private String description;

  @Column(name = "reading_time", nullable = false)
  private Integer readingTime;

  @Column(name = "recipe_count", nullable = false)
  private Long recipeCount;

  @ManyToOne(optional = false)
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "category_id")
  private CategoryEntity category;

  @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<CommentEntity> commentEntities;

  @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<LikeEntity> likeEntities;

  public RecipeEntity(UUID id, Integer recordStatus, LocalDateTime recordStatusChangeTime,
                      LocalDateTime createTime, LocalDateTime updateTime, String name,
                      String description, Integer readingTime, Long recipeCount, UserEntity user,
                      CategoryEntity category,
                      List<CommentEntity> commentEntities, List<LikeEntity> likeEntities) {
    super(id, recordStatus, recordStatusChangeTime, createTime, updateTime);
    this.name = name;
    this.description = description;
    this.readingTime = readingTime;
    this.recipeCount = recipeCount;
    this.user = user;
    this.category = category;
    this.commentEntities = commentEntities;
    this.likeEntities = likeEntities;
  }

  public RecipeEntity(String name, String description, Integer readingTime, Long recipeCount, UserEntity user,
                      CategoryEntity category, List<CommentEntity> commentEntities, List<LikeEntity> likeEntities) {
    this.name = name;
    this.description = description;
    this.readingTime = readingTime;
    this.recipeCount = recipeCount;
    this.user = user;
    this.category = category;
    this.commentEntities = commentEntities;
    this.likeEntities = likeEntities;
  }

  public RecipeEntity() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Integer getReadingTime() {
    return readingTime;
  }

  public void setReadingTime(Integer readingTime) {
    this.readingTime = readingTime;
  }

  public Long getRecipeCount() {
    return recipeCount;
  }

  public void setRecipeCount(Long recipeCount) {
    this.recipeCount = recipeCount;
  }

  public UserEntity getUser() {
    return user;
  }

  public void setUser(UserEntity user) {
    this.user = user;
  }

  public CategoryEntity getCategory() {
    return category;
  }

  public void setCategory(CategoryEntity category) {
    this.category = category;
  }

  public List<CommentEntity> getCommentEntities() {
    return commentEntities;
  }

  public void setCommentEntities(List<CommentEntity> commentEntities) {
    this.commentEntities = commentEntities;
  }

  public List<LikeEntity> getLikeEntities() {
    return likeEntities;
  }

  public void setLikeEntities(List<LikeEntity> likeEntities) {
    this.likeEntities = likeEntities;
  }
}

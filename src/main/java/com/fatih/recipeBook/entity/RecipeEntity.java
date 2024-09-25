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
public class RecipeEntity extends BaseEntity{

  @Column(name = "name", nullable = false, length = 30)
  private String name;

  @Column(name = "description", nullable = false, columnDefinition = "TEXT")
  private String description;

  @Column(name = "reading_time", nullable = false)
  private Integer readingTime;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserEntity user;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "category_id")
  private CategoryEntity category;

  @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<ImageEntity> images;

  public RecipeEntity(UUID id, Integer recordStatus, LocalDateTime recordChangeTime, String name, String description,
                      Integer readingTime, UserEntity user, CategoryEntity category, List<ImageEntity> images) {
    super(id, recordStatus, recordChangeTime);
    this.name = name;
    this.description = description;
    this.readingTime = readingTime;
    this.user = user;
    this.category = category;
    this.images = images;
  }

  public RecipeEntity(String name, String description, Integer readingTime, UserEntity user, CategoryEntity category,
                      List<ImageEntity> images) {
    this.name = name;
    this.description = description;
    this.readingTime = readingTime;
    this.user = user;
    this.category = category;
    this.images = images;
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

  public List<ImageEntity> getImages() {
    return images;
  }

  public void setImages(List<ImageEntity> images) {
    this.images = images;
  }
}

package com.fatih.recipeBook.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "images")
public class ImageEntity extends BaseEntity {

  @Column(name = "file_path", nullable = false, length = 200)
  private String filePath;

  @Column(name = "upload_date", nullable = false)
  private LocalDateTime uploadDate;

  @Column(name = "description", nullable = false, length = 200)
  private String description;

  @ManyToOne
  @JoinColumn(name = "recipe_id")
  private RecipeEntity recipe;

  public ImageEntity(UUID id, Integer recordStatus, LocalDateTime recordChangeTime, String filePath,
                     LocalDateTime uploadDate, String description, RecipeEntity recipe) {
    super(id, recordStatus, recordChangeTime);
    this.filePath = filePath;
    this.uploadDate = uploadDate;
    this.description = description;
    this.recipe = recipe;
  }

  public ImageEntity(String filePath, LocalDateTime uploadDate, String description, RecipeEntity recipe) {
    this.filePath = filePath;
    this.uploadDate = uploadDate;
    this.description = description;
    this.recipe = recipe;
  }

  public ImageEntity() {
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public LocalDateTime getUploadDate() {
    return uploadDate;
  }

  public void setUploadDate(LocalDateTime uploadDate) {
    this.uploadDate = uploadDate;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public RecipeEntity getRecipe() {
    return recipe;
  }

  public void setRecipe(RecipeEntity recipe) {
    this.recipe = recipe;
  }
}

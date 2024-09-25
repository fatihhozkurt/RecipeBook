package com.fatih.recipeBook.entity;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "images")
public class ImageEntity extends BaseEntity {

  @Lob
  @Column(name = "data", nullable = false, columnDefinition = "LONGBLOB")
  private byte[] data;

  @Column(name = "file_name", nullable = false)
  private String fileName;

  @Column(name = "file_type", nullable = false)
  private String fileType;

  @Column(name = "upload_date", nullable = false)
  private transient LocalDateTime uploadDate;

  @ManyToOne
  @JoinColumn(name = "recipe_id")
  private RecipeEntity recipe;

  public ImageEntity(UUID id, Integer recordStatus, LocalDateTime recordStatusChangeTime, byte[] data, String fileName,
                     String fileType, LocalDateTime uploadDate, RecipeEntity recipe) {
    super(id, recordStatus, recordStatusChangeTime);
    this.data = data;
    this.fileName = fileName;
    this.fileType = fileType;
    this.uploadDate = uploadDate;
    this.recipe = recipe;
  }

  public ImageEntity(byte[] data, String fileName, String fileType, LocalDateTime uploadDate,
                     RecipeEntity recipe) {
    this.data = data;
    this.fileName = fileName;
    this.fileType = fileType;
    this.uploadDate = uploadDate;
    this.recipe = recipe;
  }

  public ImageEntity() {
  }

  public byte[] getData() {
    return data;
  }

  public void setData(byte[] data) {
    this.data = data;
  }

  public String getFileName() {
    return fileName;
  }

  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  public String getFileType() {
    return fileType;
  }

  public void setFileType(String fileType) {
    this.fileType = fileType;
  }


  public LocalDateTime getUploadDate() {
    return uploadDate;
  }

  public void setUploadDate(LocalDateTime uploadDate) {
    this.uploadDate = uploadDate;
  }

  public RecipeEntity getRecipe() {
    return recipe;
  }

  public void setRecipe(RecipeEntity recipe) {
    this.recipe = recipe;
  }
}
package com.fatih.recipeBook.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "categories")
@SQLRestriction("record_status <> '1'")
public class CategoryEntity extends BaseEntity {

  @Column(name = "name", nullable = false, length = 20)
  private String name;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<RecipeEntity> recipes;

  public CategoryEntity(UUID id, Integer recordStatus, LocalDateTime recordStatusChangeTime,
                        LocalDateTime createTime, LocalDateTime updateTime, String name,
                        List<RecipeEntity> recipes) {
    super(id, recordStatus, recordStatusChangeTime, createTime, updateTime);
    this.name = name;
    this.recipes = recipes;
  }

  public CategoryEntity(String name, List<RecipeEntity> recipes) {
    this.name = name;
    this.recipes = recipes;
  }

  public CategoryEntity() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public List<RecipeEntity> getRecipes() {
    return recipes;
  }

  public void setRecipes(List<RecipeEntity> recipes) {
    this.recipes = recipes;
  }
}
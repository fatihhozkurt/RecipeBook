package com.fatih.recipeBook.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "categories")
public class CategoryEntity extends BaseEntity{

  @Column(name = "name", nullable = false, length = 15, unique = true)
  private String name;

  @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<RecipeEntity> recipes;

  public CategoryEntity(UUID id, Integer recordStatus, LocalDateTime recordChangeTime, String name,
                        List<RecipeEntity> recipes) {
    super(id, recordStatus, recordChangeTime);
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
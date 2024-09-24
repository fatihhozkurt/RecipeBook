package com.fatih.recipeBook.repository;

import java.util.UUID;

import com.fatih.recipeBook.entity.RecipeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<RecipeEntity, UUID> {
}

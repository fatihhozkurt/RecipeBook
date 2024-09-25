package com.fatih.recipeBook.repository;

import java.util.Optional;
import java.util.UUID;

import com.fatih.recipeBook.entity.CategoryEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity, UUID> {

  Optional<CategoryEntity> findByName(String name);

}

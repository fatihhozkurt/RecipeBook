package com.fatih.recipeBook.repository;

import java.util.UUID;

import com.fatih.recipeBook.entity.LikeEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends JpaRepository<LikeEntity, UUID> {
}

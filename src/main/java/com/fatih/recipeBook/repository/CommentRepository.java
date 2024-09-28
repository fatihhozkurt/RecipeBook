package com.fatih.recipeBook.repository;

import java.util.UUID;

import com.fatih.recipeBook.entity.CommentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<CommentEntity, UUID> {
}

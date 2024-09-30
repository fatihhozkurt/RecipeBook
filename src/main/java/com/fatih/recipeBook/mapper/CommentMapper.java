package com.fatih.recipeBook.mapper;

import java.util.List;

import com.fatih.recipeBook.dto.request.comment.CreateCommentRequest;
import com.fatih.recipeBook.dto.response.comment.CommentBaseResponse;
import com.fatih.recipeBook.dto.response.comment.CommentPageResponse;
import com.fatih.recipeBook.entity.CommentEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CommentMapper {

  CommentMapper INSTANCE = Mappers.getMapper(CommentMapper.class);

  @Mapping(source = "userID", target = "user.id")
  @Mapping(source = "recipeID", target = "recipe.id")
  CommentEntity toCommentEntity(CreateCommentRequest createCommentRequest);

  List<CommentBaseResponse> toCommentBaseResponseList(List<CommentEntity> commentEntities);
  CommentBaseResponse toCommentBaseResponse(CommentEntity commentEntity);

  List<CommentPageResponse> toCommentPageResponseList(List<CommentEntity> commentEntities);
}

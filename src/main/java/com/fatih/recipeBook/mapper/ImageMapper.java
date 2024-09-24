package com.fatih.recipeBook.mapper;

import java.util.List;

import com.fatih.recipeBook.dto.request.image.ImageRequest;
import com.fatih.recipeBook.dto.response.image.ImageResponse;
import com.fatih.recipeBook.entity.ImageEntity;
import com.fatih.recipeBook.entity.RecipeEntity;


import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ImageMapper {
  ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

  RecipeEntity toEntity(ImageRequest imageRequest);

  ImageResponse toImageResponse(ImageEntity imageEntity);

  List<ImageResponse> toImageResponseList(List<ImageEntity> imageEntities);
}

package com.fatih.recipeBook.mapper;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Base64;

import com.fatih.recipeBook.dto.response.image.ImageCardResponse;
import com.fatih.recipeBook.entity.ImageEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.cglib.core.Local;
import org.springframework.web.multipart.MultipartFile;

@Mapper
public interface ImageMapper {
  ImageMapper INSTANCE = Mappers.getMapper(ImageMapper.class);

  @Mapping(target = "base64Image", expression = "java(convertToBase64(imageEntity.getData()))")
  ImageCardResponse toImageCardResponse(ImageEntity imageEntity);

  default ImageEntity toImageEntity(MultipartFile file) {
    if (file == null) {
      return null;
    }

    ImageEntity imageEntity = new ImageEntity();
    try {
      byte[] data = file.getBytes();
      imageEntity.setData(data);
    } catch (IOException e) {
      throw new RuntimeException("Failed to read file data", e);
    }

    imageEntity.setFileName(file.getOriginalFilename());
    imageEntity.setFileType(file.getContentType());
    imageEntity.setUploadDate(LocalDateTime.now());

    return imageEntity;
  }

  default String convertToBase64(byte[] data) {
    return Base64.getEncoder().encodeToString(data);
  }
}

package com.fatih.recipeBook.service.abstracts;

import java.util.UUID;

import com.fatih.recipeBook.dto.response.image.ImageCardResponse;
import com.fatih.recipeBook.entity.ImageEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {

  ImageEntity createImage(MultipartFile file);
  ImageCardResponse updateImage(MultipartFile file, UUID id);
  void deleteImage(UUID id);
  ImageCardResponse getImage(UUID id);

  }

package com.fatih.recipeBook.service.abstracts;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.entity.ImageEntity;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {

  ImageEntity createImage(ImageEntity imageEntity);

  void deleteImage(UUID id);

  ImageEntity getImageById(UUID id);

  List<ImageEntity> getAllImages();
}

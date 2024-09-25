package com.fatih.recipeBook.controller.concretes;

import java.util.UUID;

import com.fatih.recipeBook.controller.abstracts.ImageApi;
import com.fatih.recipeBook.dto.response.image.ImageCardResponse;
import com.fatih.recipeBook.entity.ImageEntity;
import com.fatih.recipeBook.mapper.ImageMapper;
import com.fatih.recipeBook.service.abstracts.ImageService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class ImageController implements ImageApi {

  private final ImageService imageService;

  public ImageController(ImageService imageService) {
    this.imageService = imageService;
  }

  @Override
  public ResponseEntity<ImageCardResponse> createImage(MultipartFile multipartFile) {
    ImageEntity imageEntity = imageService.createImage(multipartFile);
    ImageCardResponse imageCardResponse = ImageMapper.INSTANCE.toImageCardResponse(imageEntity);
    return new ResponseEntity<>(imageCardResponse, HttpStatus.CREATED);
  }

  @Override
  public ResponseEntity<ImageCardResponse> getImageCardById(UUID id) {
    return null;
  }
}

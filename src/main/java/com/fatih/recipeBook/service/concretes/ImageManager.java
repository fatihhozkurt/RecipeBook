package com.fatih.recipeBook.service.concretes;

import static com.fatih.recipeBook.constants.SoftDeleteConstants.ACTIVE;

import java.util.UUID;

import com.fatih.recipeBook.dto.response.image.ImageCardResponse;
import com.fatih.recipeBook.entity.ImageEntity;
import com.fatih.recipeBook.mapper.ImageMapper;
import com.fatih.recipeBook.repository.ImageRepository;
import com.fatih.recipeBook.service.abstracts.ImageService;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageManager implements ImageService {

  private final ImageRepository imageRepository;

  public ImageManager(ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

  @Override
  public ImageEntity createImage(MultipartFile file) {

    ImageEntity imageEntity = ImageMapper.INSTANCE.toImageEntity(file);

    imageEntity.setRecordStatus(ACTIVE);
    return imageRepository.save(imageEntity);
  }

  @Override
  public ImageCardResponse updateImage(MultipartFile file, UUID id) {
    return null;
  }

  @Override
  public void deleteImage(UUID id) {

  }

  @Override
  public ImageCardResponse getImage(UUID id) {
    return null;
  }
}

package com.fatih.recipeBook.service.concretes;

import static com.fatih.recipeBook.constants.SoftDeleteConstants.ACTIVE;
import static com.fatih.recipeBook.constants.SoftDeleteConstants.PASSIVE;

import java.awt.Image;
import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.entity.ImageEntity;
import com.fatih.recipeBook.exception.ResourceNotFoundException;
import com.fatih.recipeBook.mapper.ImageMapper;
import com.fatih.recipeBook.repository.ImageRepository;
import com.fatih.recipeBook.service.abstracts.ImageService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageManager implements ImageService {

  private final ImageRepository imageRepository;

  public ImageManager(ImageRepository imageRepository) {
    this.imageRepository = imageRepository;
  }

  @Override
  @Transactional
  public ImageEntity createImage(ImageEntity imageEntity) {
    imageEntity.setRecordStatus(ACTIVE);
    return imageRepository.save(imageEntity);
  }

  @Override
  @Transactional
  public void deleteImage(UUID id) {
    ImageEntity foundedImage = imageRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Trying to delete an invalid category ID!"));

    foundedImage.setRecordStatus(PASSIVE);
  }

  @Override
  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public ImageEntity getImageById(UUID id) {
    return imageRepository.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("Trying to get invalid image ID!"));
  }

  @Override
  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public List<ImageEntity> getAllImages() {
    return imageRepository.findAll();
  }
}

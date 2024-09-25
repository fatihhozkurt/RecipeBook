package com.fatih.recipeBook.service.concretes;

import static com.fatih.recipeBook.constants.SoftDeleteConstants.ACTIVE;
import static com.fatih.recipeBook.constants.SoftDeleteConstants.PASSIVE;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.dto.request.category.CategoryRequest;
import com.fatih.recipeBook.entity.CategoryEntity;
import com.fatih.recipeBook.exception.DataAlreadyExistException;
import com.fatih.recipeBook.exception.ResourceNotFoundException;
import com.fatih.recipeBook.mapper.CategoryMapper;
import com.fatih.recipeBook.repository.CategoryRepository;
import com.fatih.recipeBook.service.abstracts.CategoryService;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryManager implements CategoryService {

  private final CategoryRepository categoryRepository;

  public CategoryManager(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Override
  @Transactional
  public CategoryEntity createCategory(CategoryEntity requestedCategory) {
    categoryRepository.findByName(requestedCategory.getName()).ifPresent(existingCategory -> {

      throw new DataAlreadyExistException("This category already exists!");
    });
    requestedCategory.setRecordStatus(ACTIVE);
    return categoryRepository.save(requestedCategory);
  }

  @Override
  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public List<CategoryEntity> getAllCategories() {
    return categoryRepository.findAll();
  }

  @Override
  @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
  public CategoryEntity getCategoryById(UUID id) {
    return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trying to get an invalid category ID!"));
  }

  @Override
  @Transactional
  public CategoryEntity updateCategory(CategoryEntity requestedCategory, UUID id) {
    CategoryEntity foundedCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trying to update an invalid category ID!!"));

    CategoryMapper.INSTANCE.updateToExistingCategoryWithIgnoringNulls(requestedCategory, foundedCategory);

    foundedCategory.setRecordStatus(ACTIVE);
    categoryRepository.save(foundedCategory);
    return foundedCategory;
  }

  @Override
  @Transactional
  public void deleteCategory(UUID id) {
    CategoryEntity foundedCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Trying to delete an invalid category ID!"));
    foundedCategory.setRecordStatus(PASSIVE);
  }
}

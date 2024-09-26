package com.fatih.recipeBook.controller.abstracts;

import static com.fatih.recipeBook.constants.URLConstants.ALL;
import static com.fatih.recipeBook.constants.URLConstants.BASE;
import static com.fatih.recipeBook.constants.URLConstants.ID;
import static com.fatih.recipeBook.constants.URLConstants.IMAGE;
import static com.fatih.recipeBook.constants.URLConstants.PAGE;
import static com.fatih.recipeBook.constants.URLConstants.REQUEST;

import java.util.List;
import java.util.UUID;

import com.fatih.recipeBook.dto.response.image.ImageBaseResponse;
import com.fatih.recipeBook.dto.response.image.ImageCardResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@RequestMapping(IMAGE)
public interface ImageApi {

  @PostMapping(BASE + REQUEST)
  ResponseEntity<ImageCardResponse> createImage(@RequestParam("file") MultipartFile multipartFile);

  @DeleteMapping(BASE + ID)
  ResponseEntity<HttpStatus> deleteImage(@RequestParam("id") UUID id);

  @GetMapping(PAGE + ID)
  ResponseEntity<ImageCardResponse> getImageCardById(@RequestParam("id") UUID id);

  @GetMapping(BASE + ALL)
  ResponseEntity<List<ImageBaseResponse>> getAllImages();
}
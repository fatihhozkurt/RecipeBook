package com.fatih.recipeBook.mapper;

import java.util.List;

import com.fatih.recipeBook.dto.request.user.CreateUserRequest;
import com.fatih.recipeBook.dto.request.user.UpdateUserRequest;
import com.fatih.recipeBook.dto.response.user.UserCardResponse;
import com.fatih.recipeBook.dto.response.user.UserResponse;
import com.fatih.recipeBook.entity.UserEntity;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
  UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

  UserEntity toCreateEntity(CreateUserRequest createUserRequest);

  UserEntity toUpdateEntity(UpdateUserRequest updateUserRequest);

  UserResponse toUserResponse(UserEntity userEntity);

  List<UserResponse> toUserResponseList(List<UserEntity> userEntities);

  UserCardResponse toUserCardResponse(UserEntity userEntity);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateToExistingUserWithIgnoreNulls(UserEntity userEntity, @MappingTarget UserEntity existingUser);
}
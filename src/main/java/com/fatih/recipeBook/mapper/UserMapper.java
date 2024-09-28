package com.fatih.recipeBook.mapper;

import com.fatih.recipeBook.dto.request.user.CreateUserRequest;
import com.fatih.recipeBook.dto.request.user.UpdateUserRequest;
import com.fatih.recipeBook.dto.response.user.UserUpdateResponse;
import com.fatih.recipeBook.entity.UserEntity;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

  UserMapper INSTANCE = Mappers.getMapper( UserMapper.class );

  UserEntity toUserEntity(CreateUserRequest createUserRequest);
  UserEntity toUserEntity(UpdateUserRequest updateUserRequest);

  UserUpdateResponse toUserUpdateResponse(UserEntity userEntity);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  void updateUserFromRequest(UserEntity requestEntity, @MappingTarget UserEntity existingUser);

}

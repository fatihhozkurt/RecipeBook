package com.fatih.recipeBook.entity;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import org.hibernate.annotations.SQLRestriction;

@Entity
@Table(name = "users")
@SQLRestriction("record_status <> '1'")
public class UserEntity extends BaseEntity {

  @Column(name = "name", nullable = false, length = 20)
  private String name;

  @Column(name = "surname", nullable = false, length = 20)
  private String surname;

  @Column(name = "email", nullable = false, length = 60)
  private String email;

  @Column(name = "phone", nullable = false, length = 13)
  private String phone;

  @Column(name = "age")
  private Integer age;

  @Column(name = "password", nullable = false, length = 16)
  private String password;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<RecipeEntity> recipes;

  public UserEntity(UUID id, Integer recordStatus, LocalDateTime recordStatusChangeTime, LocalDateTime createTime,
                    LocalDateTime updateTime, String name, String surname, String email, String phone, Integer age,
                    String password, List<RecipeEntity> recipes) {
    super(id, recordStatus, recordStatusChangeTime, createTime, updateTime);
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.phone = phone;
    this.age = age;
    this.password = password;
    this.recipes = recipes;
  }

  public UserEntity(String name, String surname, String email, String phone, Integer age, String password,
                    List<RecipeEntity> recipes) {
    this.name = name;
    this.surname = surname;
    this.email = email;
    this.phone = phone;
    this.age = age;
    this.password = password;
    this.recipes = recipes;
  }

  public UserEntity() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSurname() {
    return surname;
  }

  public void setSurname(String surname) {
    this.surname = surname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public List<RecipeEntity> getRecipes() {
    return recipes;
  }

  public void setRecipes(List<RecipeEntity> recipes) {
    this.recipes = recipes;
  }
}

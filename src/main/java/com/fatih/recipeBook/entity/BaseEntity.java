package com.fatih.recipeBook.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.annotation.PreDestroy;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

@MappedSuperclass
public class BaseEntity implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  @Column(name = "id", updatable = false, nullable = false)
  private UUID id;

  @Column(name = "record_status", nullable = false, columnDefinition = "int default 0")
  private Integer recordStatus;

  @Column(name = "record_change_time")
  private LocalDateTime recordStatusChangeTime;

  @Column(name = "createTime", nullable = false)
  private LocalDateTime createTime;

  @Column(name = "updateTime")
  private LocalDateTime updateTime;

  @PrePersist
  protected void onCreate() {
    this.createTime = LocalDateTime.now();
  }

  @PreUpdate
  protected void onUpdate() {
    this.updateTime = LocalDateTime.now();
  }

  public BaseEntity(UUID id, Integer recordStatus, LocalDateTime recordStatusChangeTime) {
    this.id = id;
    this.recordStatus = recordStatus;
    this.recordStatusChangeTime = recordStatusChangeTime;
  }

  public BaseEntity() {
  }

  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public Integer getRecordStatus() {
    return recordStatus;
  }

  public void setRecordStatus(Integer recordStatus) {
    this.recordStatus = recordStatus;
  }

  public LocalDateTime getRecordStatusChangeTime() {
    return recordStatusChangeTime;
  }

  public void setRecordStatusChangeTime(LocalDateTime recordStatusChangeTime) {
    this.recordStatusChangeTime = recordStatusChangeTime;
  }
}

package com.test.persistence.models.local;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.querydsl.core.annotations.QueryEntity;
import com.test.persistence.models.config.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.With;

@With
@Data
@Entity
@Builder
@QueryEntity
@DynamicInsert
@DynamicUpdate
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Person_JPA")
@EqualsAndHashCode(callSuper = true)
public class Person extends BaseEntity {

  private String reference;

  private String name;

  private String email;

  private String address;

  @Builder.Default
  private String phone = "+21256498763";

}

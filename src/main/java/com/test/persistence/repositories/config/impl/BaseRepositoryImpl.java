package com.test.persistence.repositories.config.impl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import com.test.persistence.repositories.config.AbstractDSLRepository;

import javax.persistence.EntityManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@Getter
@Setter
public abstract class BaseRepositoryImpl<T, U> extends SimpleJpaRepository<T, U>
    implements AbstractDSLRepository<T, U> {

  private final EntityManager entityManager;

  private final JPAQueryFactory jpaQueryFactory;

  protected BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
    super(domainClass, entityManager);
    this.entityManager = entityManager;
    this.jpaQueryFactory = new JPAQueryFactory(entityManager);
  }
}

package com.test.infrastructure.batch.reader;

import javax.persistence.EntityManagerFactory;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JpaPagingItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.test.persistence.config.LocalDB;
import com.test.persistence.models.local.Person;

@StepScope
@Component
public class PersonQueryItemReader extends JpaPagingItemReader<Person> {

  public PersonQueryItemReader(@Qualifier(LocalDB.EMF) EntityManagerFactory entityManagerFactory) {
    this.entityManagerFactory = entityManagerFactory;
    init();
  }

  private final EntityManagerFactory entityManagerFactory;

  private void init() {
    setEntityManagerFactory(entityManagerFactory);
    setQueryString("SELECT    p   FROM  Person p");
    setPageSize(100);
  }

}

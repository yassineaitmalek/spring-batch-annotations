package com.test.infrastructure.batch.reader;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.test.persistence.config.LocalDB;
import com.test.persistence.models.local.Person;

import lombok.RequiredArgsConstructor;

@StepScope
@Component
@RequiredArgsConstructor
public class PersonQueryDSItemReader extends JdbcCursorItemReader<Person> {

  @Qualifier(LocalDB.DS)
  private final DataSource dataSource;

  private final PersonRowMapper personRowMapper;

  @PostConstruct
  private void init() {
    setDataSource(dataSource);
    setSql("SELECT    ID, REFERENCE, NAME, EMAIL, ADDRESS, PHONE, DATE_INSERT   FROM  Person");
    setFetchSize(100);
    setRowMapper(personRowMapper);
  }

}

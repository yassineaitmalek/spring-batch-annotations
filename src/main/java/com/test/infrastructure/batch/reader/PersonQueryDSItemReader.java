package com.test.infrastructure.batch.reader;

import javax.sql.DataSource;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.test.persistence.config.LocalDB;
import com.test.persistence.models.local.Person;

@StepScope
@Component
public class PersonQueryDSItemReader extends JdbcCursorItemReader<Person> {

  public PersonQueryDSItemReader(@Qualifier(LocalDB.DS) DataSource dataSource, PersonRowMapper personRowMapper) {
    this.dataSource = dataSource;
    this.personRowMapper = personRowMapper;
    init();
  }

  private final DataSource dataSource;

  private final PersonRowMapper personRowMapper;

  private void init() {
    setDataSource(dataSource);
    setSql("SELECT    ID, REFERENCE, NAME, EMAIL, ADDRESS, PHONE, DATE_INSERT   FROM  Person");
    setFetchSize(100);
    setRowMapper(personRowMapper);
  }

}

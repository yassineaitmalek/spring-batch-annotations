package com.test.infrastructure.batch.reader;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.test.persistence.models.local.Person;

@Component
public class PersonRowMapper implements RowMapper<Person> {

  public Person mapRow(ResultSet rs, int rowNum) throws SQLException {

    Person person = new Person();

    person.setReference(rs.getString("REFERENCE"));
    person.setName(rs.getString("NAME"));
    person.setEmail(rs.getString("EMAIL"));
    person.setAddress(rs.getString("ADDRESS"));
    person.setPhone(rs.getString("PHONE"));

    return person;
  }

}

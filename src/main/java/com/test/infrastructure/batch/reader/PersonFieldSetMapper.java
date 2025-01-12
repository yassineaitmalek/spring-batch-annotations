package com.test.infrastructure.batch.reader;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindException;

import com.test.persistence.models.local.Person;

@Component
public class PersonFieldSetMapper implements FieldSetMapper<Person> {

  @Override
  public Person mapFieldSet(FieldSet fieldSet) throws BindException {

    Person person = new Person();

    person.setReference(fieldSet.readString(0));
    person.setName(fieldSet.readString(1));
    person.setEmail(fieldSet.readString(2));
    person.setAddress(fieldSet.readString(3));

    return person;
  }
}

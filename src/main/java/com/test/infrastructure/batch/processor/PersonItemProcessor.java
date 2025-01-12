package com.test.infrastructure.batch.processor;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.test.persistence.models.local.Person;

import lombok.RequiredArgsConstructor;

@StepScope
@Component
@RequiredArgsConstructor
public class PersonItemProcessor implements ItemProcessor<Person, Person> {

  @Override
  public Person process(@NonNull Person item) throws Exception {

    return item;
  }
}

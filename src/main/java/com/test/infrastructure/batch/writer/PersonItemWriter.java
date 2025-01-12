package com.test.infrastructure.batch.writer;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import com.test.persistence.models.local.Person;
import com.test.persistence.repositories.local.PersonRepository;

import lombok.RequiredArgsConstructor;

@StepScope
@Component
@RequiredArgsConstructor
public class PersonItemWriter implements ItemWriter<Person> {

  private final PersonRepository personRepository;

  @Override
  public void write(@NonNull List<? extends Person> items) throws Exception {

    Optional.ofNullable(items)
        .orElseGet(Collections::emptyList)
        .stream()
        .filter(Objects::nonNull)
        .collect(Collectors.collectingAndThen(Collectors.toList(), Optional::ofNullable))
        .ifPresent(personRepository::saveAll);

  }
}

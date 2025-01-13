package com.test.infrastructure.batch.reader;

import javax.annotation.PostConstruct;

import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Component;

import com.test.persistence.models.local.Person;

import lombok.RequiredArgsConstructor;

@StepScope
@Component
@RequiredArgsConstructor
public class PersonFileItemReader extends FlatFileItemReader<Person> {

  private final PersonFieldSetMapper personFieldSetMapper;

  @Value("${person.data}")
  private final String filePath;

  @PostConstruct
  private void init() {
    setResource(new FileSystemResource(filePath));
    setLineMapper(lineMapper());
    this.setLinesToSkip(1);
  }

  public DefaultLineMapper<Person> lineMapper() {
    DefaultLineMapper<Person> lineMapper = new DefaultLineMapper<>();
    lineMapper.setLineTokenizer(lineTokenizer());
    lineMapper.setFieldSetMapper(personFieldSetMapper);

    return lineMapper;
  }

  public LineTokenizer lineTokenizer() {
    DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
    tokenizer.setDelimiter(";;");
    tokenizer.setNames("reference", "name", "email", "address");
    return tokenizer;
  }

}

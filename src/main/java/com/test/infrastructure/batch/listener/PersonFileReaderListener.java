package com.test.infrastructure.batch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

import com.test.persistence.repositories.local.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class PersonFileReaderListener extends StepExecutionListenerSupport {

  private final PersonRepository personRepository;

  @Override
  public void beforeStep(StepExecution stepExecution) {
    log.info("Before step Delete all persons");
    personRepository.deleteAll();
    log.info("Before step Delete all persons done");
  }

  @Override
  public ExitStatus afterStep(StepExecution stepExecution) {

    return stepExecution.getExitStatus();
  }
}

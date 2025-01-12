package com.test.infrastructure.batch.listener;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.listener.StepExecutionListenerSupport;
import org.springframework.stereotype.Component;

import com.test.persistence.repositories.local.PersonRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PersonFileReaderListener extends StepExecutionListenerSupport {

  private final PersonRepository personRepository;

  @Override
  public void beforeStep(StepExecution stepExecution) {
    personRepository.deleteAll();
  }

  @Override
  public ExitStatus afterStep(StepExecution stepExecution) {

    return stepExecution.getExitStatus();
  }
}

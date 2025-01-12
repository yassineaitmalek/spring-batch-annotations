package com.test.infrastructure.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BatchJobs {

  @Autowired
  private JobBuilderFactory jobBuilderFactory;

  @Autowired
  @Qualifier("insert-person-from-file-step")
  private Step insert_person_from_file_step;

  @Autowired
  @Qualifier("insert-person-from-query-step")
  private Step insert_person_from_query_step;

  @Bean("insert-person-from-file-job")
  public Job getJobInsertPersonFromFile() {

    return jobBuilderFactory.get("insert-person-from-file-job")
        .start(insert_person_from_file_step)
        .build();
  }

  @Bean("insert-person-from-query-job")
  public Job getJobInsertPersonFromQuery() {

    return jobBuilderFactory.get("insert-person-from-query-job")
        .start(insert_person_from_query_step)
        .build();
  }

}

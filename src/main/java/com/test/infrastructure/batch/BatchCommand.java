package com.test.infrastructure.batch;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class BatchCommand implements CommandLineRunner {

  private final ApplicationContext applicationContext;

  private final BatchRun batchRun;

  @Override
  public void run(String... args) throws Exception {

    Try.run(() -> execute(args))
        .onFailure(e -> log.error(e.getMessage(), e));

    log.info("Shutting down application...");
    SpringApplication.exit(applicationContext, () -> 0);
  }

  public void execute(String... args) throws Exception {

    batchRun.runJobInsertPersonFromFile();
    batchRun.runJobInsertPersonFromQuery();

  }

}

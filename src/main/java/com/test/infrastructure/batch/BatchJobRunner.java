package com.test.infrastructure.batch;

import io.vavr.control.Try;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;

import com.test.persistence.exception.config.ServerSideException;
import com.test.common.utility.DateUtility;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BatchJobRunner implements Runnable {

  private Job job;

  private JobParametersBuilder params;

  private JobLauncher jobLauncher;

  private LocalDateTime creationDate;

  public static void execute(Job job, JobParametersBuilder params, JobLauncher jobLauncher) {
    new BatchJobRunner(job, params, jobLauncher, DateUtility.nowDateTime()).run();
  }

  @Override
  public void run() {
    params.addDate("run.date", new Date());
    params.addString("batchId", UUID.randomUUID().toString());
    Try.run(() -> jobLauncher.run(job, params.toJobParameters()))
        .onFailure(ServerSideException::reThrow);
  }

}

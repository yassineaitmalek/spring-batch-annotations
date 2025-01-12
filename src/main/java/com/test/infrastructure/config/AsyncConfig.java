package com.test.infrastructure.config;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Semaphore;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.test.infrastructure.config.properties.AppAsyncProperties;

@EnableAsync
@Configuration
@RequiredArgsConstructor
public class AsyncConfig {

  private final AppAsyncProperties appAsyncProperties;

  @Bean(name = "taskExecutor")
  public TaskExecutor getTaskExecutor() {
    ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
    executor.setQueueCapacity(appAsyncProperties.getQueueCapacity());
    executor.setCorePoolSize(appAsyncProperties.getCorePoolSize());
    executor.setMaxPoolSize(appAsyncProperties.getMaximumPoolSize());
    executor.setThreadNamePrefix("testThread-");
    executor.initialize();
    return executor;
  }

}

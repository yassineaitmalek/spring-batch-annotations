package com.test.infrastructure.config.properties;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "app.async")
public class AppAsyncProperties {

  private Integer corePoolSize;

  private Integer maximumPoolSize;

  private Integer queueCapacity;

  private Integer keepAliveTime;
}

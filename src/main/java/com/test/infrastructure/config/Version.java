package com.test.infrastructure.config;

import javax.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Version {

  @PostConstruct
  public void javaVersion() {

    log.info("JAVA version used in this service is {}", System.getProperty("java.version"));
  }
}

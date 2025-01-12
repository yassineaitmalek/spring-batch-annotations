package com.test.common.utility;

import java.util.Optional;
import lombok.experimental.UtilityClass;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.scope.context.StepContext;

@UtilityClass
public class BatchUtil {

  public <T> T getParam(String param, ChunkContext chunkContext, Class<T> clazz) {
    return Optional.ofNullable(chunkContext)
        .map(ChunkContext::getStepContext)
        .map(StepContext::getJobParameters)
        .filter(e -> e.containsKey(param))
        .map(e -> e.get(param))
        .filter(clazz::isInstance)
        .map(clazz::cast)
        .orElse(null);
  }

  public <T> T getParam(String param, StepExecution stepExecution, Class<T> clazz) {
    return Optional.ofNullable(stepExecution)
        .map(StepExecution::getJobParameters)
        .map(e -> e.getString(param))
        .filter(clazz::isInstance)
        .map(clazz::cast)
        .orElse(null);
  }
}

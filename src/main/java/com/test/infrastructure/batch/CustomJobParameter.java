package com.test.infrastructure.batch;

import java.util.UUID;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.batch.core.JobParameter;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomJobParameter<T> extends JobParameter {

  private transient T value;

  public CustomJobParameter(T customParam) {
    super(UUID.randomUUID().toString());
    this.value = customParam;
  }
}

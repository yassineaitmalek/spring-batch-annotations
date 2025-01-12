package com.test.common.utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.apache.commons.text.StringSubstitutor;

import com.test.persistence.exception.config.ServerSideException;

public final class StringTemplate {

  private String template;

  private Map<String, String> params = new HashMap<>();

  public StringTemplate(String template) {
    this.template = template;
  }

  public static StringTemplate template(String template) {
    if (Objects.isNull(template)) {
      throw new ServerSideException("NULL template");
    }
    return new StringTemplate(template);
  }

  public StringTemplate addParameter(String pramName, Object parmValue) {

    if (Objects.isNull(pramName)) {
      return this;
    }
    params.put(pramName, objectToString(parmValue));
    return this;
  }

  public String build() {
    return Optional.of(params)
        .map(StringSubstitutor::new)
        .map(e -> e.replace(template))
        .orElseGet(String::new);
  }

  public String objectToString(Object obj) {
    return Optional.ofNullable(obj).map(Object::toString).orElseGet(String::new);
  }
}

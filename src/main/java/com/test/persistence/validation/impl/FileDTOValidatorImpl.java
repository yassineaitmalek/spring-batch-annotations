package com.test.persistence.validation.impl;

import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.test.persistence.dto.FileDTO;
import com.test.persistence.validation.FileDTOValidator;

public class FileDTOValidatorImpl implements ConstraintValidator<FileDTOValidator, FileDTO> {

  @Override
  public boolean isValid(FileDTO fileDTO, ConstraintValidatorContext context) {

    return Stream.of(checkNull(fileDTO), checkFile(fileDTO)).noneMatch(Boolean.TRUE::equals);
  }

  private boolean checkNull(FileDTO fileDTO) {
    return Objects.isNull(fileDTO);
  }

  private boolean checkFile(FileDTO fileDTO) {
    return Optional.ofNullable(fileDTO)
        .map(e -> Objects.isNull(e.getFile()))
        .orElseGet(() -> Boolean.TRUE);
  }
}

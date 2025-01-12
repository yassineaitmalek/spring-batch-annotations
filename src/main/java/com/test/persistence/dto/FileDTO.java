package com.test.persistence.dto;

import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import com.test.persistence.validation.FileDTOValidator;

@FileDTOValidator
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {

  @NotNull
  private MultipartFile file;
}

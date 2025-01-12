package com.test.persistence.models.batch;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FinancialTransaction {

  private Long cptemouv;

  private LocalDate datemouv;

  private LocalDate datevale;

  private Double amount;

  private Double soldeDepart;
}

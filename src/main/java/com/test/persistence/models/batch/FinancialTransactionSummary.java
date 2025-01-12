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
public class FinancialTransactionSummary {

  private Long cptemouv;

  private LocalDate datemouv;

  private Long nbTransaction;

  private Double sumTransaction;

  private Double soldeDepart;

  private Double soldeFin;
}

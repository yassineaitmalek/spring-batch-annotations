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
public class CompteDateValeurGroup {

  private Long idCompte;

  private LocalDate dateValeur;
}

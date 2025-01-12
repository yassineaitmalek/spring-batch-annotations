package com.test.persistence.config;

import javax.sql.DataSource;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class Batch {

  @Bean("BatchJpaRepository")
  public JobRepository getJobRepository(
      @Qualifier(LocalDB.DB + BasePackage.DS) DataSource dataSource,
      @Qualifier(LocalDB.DB + BasePackage.TM) PlatformTransactionManager transactionManager)
      throws Exception {
    JobRepositoryFactoryBean factory = new JobRepositoryFactoryBean();
    factory.setTransactionManager(transactionManager);
    factory.setDatabaseType("ORACLE");
    factory.setIsolationLevelForCreate("ISOLATION_READ_COMMITTED");
    factory.setIsolationLevelForCreate("ISOLATION_SERIALIZABLE");
    factory.setTablePrefix("BATCH_");

    factory.setDataSource(dataSource);
    return factory.getObject();
  }
}

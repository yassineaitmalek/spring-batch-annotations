package com.test.infrastructure.batch;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import com.test.infrastructure.batch.listener.PersonFileReaderListener;
import com.test.infrastructure.batch.processor.PersonItemProcessor;
import com.test.infrastructure.batch.reader.PersonFileItemReader;
import com.test.infrastructure.batch.reader.PersonQueryDSItemReader;
import com.test.infrastructure.batch.reader.PersonQueryItemReader;
import com.test.infrastructure.batch.writer.PersonItemWriter;
import com.test.persistence.models.local.Person;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@RequiredArgsConstructor
public class BatchSteps {

        private final StepBuilderFactory stepBuilderFactory;

        private final PlatformTransactionManager platformTransactionManager;

        private final PersonFileItemReader personFileItemReader;

        private final PersonQueryItemReader personQueryItemReader;

        private final PersonQueryDSItemReader personQueryDSItemReader;

        private final PersonItemProcessor personItemProcessor;

        private final PersonItemWriter personItemWriter;

        private final PersonFileReaderListener personFileReaderListener;

        @Bean("insert-person-from-file-step")
        public Step getStepInsertPersonFromFile() {

                return stepBuilderFactory
                                .get("insert-person-from-file-step")
                                .<Person, Person>chunk(1000)
                                .reader(personFileItemReader)
                                .processor(personItemProcessor)
                                .writer(personItemWriter)
                                .listener(personFileReaderListener)
                                .transactionManager(platformTransactionManager)
                                .allowStartIfComplete(Boolean.TRUE)
                                .build();
        }

        @Bean("insert-person-from-query-step")
        public Step getStepInsertPersonFromQuery() {

                return stepBuilderFactory
                                .get("insert-person-from-query-step")
                                .<Person, Person>chunk(1000)
                                .reader(personQueryDSItemReader)
                                .processor(personItemProcessor)
                                .writer(personItemWriter)
                                .transactionManager(platformTransactionManager)
                                .allowStartIfComplete(Boolean.TRUE)
                                .build();
        }

}

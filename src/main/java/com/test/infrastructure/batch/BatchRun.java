package com.test.infrastructure.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class BatchRun {

    @Autowired
    private JobLauncher jobLauncher;

    @Autowired
    @Qualifier("insert-person-from-file-job")
    private Job insert_person_from_file_job;

    @Autowired
    @Qualifier("insert-person-from-query-job")
    private Job insert_person_from_query_job;

    public void runJobInsertPersonFromFile() {

        JobParametersBuilder params = new JobParametersBuilder();
        BatchJobRunner.execute(insert_person_from_file_job, params, jobLauncher);
    }

    public void runJobInsertPersonFromQuery() {

        JobParametersBuilder params = new JobParametersBuilder();
        BatchJobRunner.execute(insert_person_from_query_job, params, jobLauncher);
    }

}

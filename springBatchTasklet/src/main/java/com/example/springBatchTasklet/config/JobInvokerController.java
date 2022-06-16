package com.example.springBatchTasklet.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JobInvokerController {

	Logger logger = (Logger) LoggerFactory.getLogger(JobInvokerController.class);
	@Autowired
	JobLauncher jobLauncher;

	@Autowired
	Job helloWorldJob;

	@RequestMapping("/invokeJob")
	public String handle() throws Exception {
		logger.info("Task Batch job has been invoked");
		JobParameters jobParameters = new JobParametersBuilder().toJobParameters();
		jobLauncher.run(helloWorldJob, jobParameters);
		return "Task Batch job has been invoked";
	}
}

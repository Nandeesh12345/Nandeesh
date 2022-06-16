package com.example.springBatchTasklet.config;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecutionListener;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;




import java.io.File;

@Configuration

public class BatchConfig {

	
	Logger logger = (Logger) LoggerFactory.getLogger(BatchConfig.class);
	@Autowired
	private JobBuilderFactory jobFactory;

	@Autowired
	private StepBuilderFactory stepFactory;
    
    @Bean
	public Step step1() {
		return stepFactory.get("step1").tasklet(helloWorldTasklet()).build();
	}
    private Tasklet helloWorldTasklet() {
		return (new Tasklet() {
			@Override
			public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
				logger.info("Deleting a File");
				try {
					File f = new File("src\\main\\resources\\data2.txt");
					if (f.delete()) {
						logger.info(f.getName() + " deleted");
						
					} else {
						logger.info("file deletion is failed");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				return RepeatStatus.FINISHED;
			}
		});

	}

	@Bean
	public Job helloWorldJob() {
		return jobFactory.get("helloworld").flow(step1()).end().build();
	}

   
}

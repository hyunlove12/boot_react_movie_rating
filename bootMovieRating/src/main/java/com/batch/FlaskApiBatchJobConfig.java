package com.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FlaskApiBatchJobConfig {
	
	@Bean
	public Job flaskApiBatchJob(JobBuilderFactory jobBuilderFactory, Step flaskApiBatchJobStep) {
		return jobBuilderFactory.get("flaskApiBatchJob")	
				.preventRestart()
				.start(flaskApiBatchJobStep)
				.build();
	}
	
	@Bean
	public Step flaskApiBatchStep(StepBuilderFactory stepBuilderFactory) {
		return stepBuilderFactory.get("flaskApiBatchJob")
				.<FlaskBatchVO, FlaskBatchVO> chunk(10)
				.reader(flaskApiBatchReader())
				.processor(flaskApiBatchProcessor())
				.writer(flaskApiBatchWriter())
				.build();
	}
	
	@Bean
	@StepScope
	public QueueItemReader<FlaskBatchVO> flaskApiBatchReader() {
		List<FlaskBatchVO> flaskBatcResult = 
	}

	@Bean
	public ItemProcessor<FlaskBatchVO, FlaskBatchVO> flaskApiBatchProcessor() {
	    return user -> user.setInactive();
	}
	
	public ItemWriter<User> flaskApiBatchWriter() {
	    return ((List<? extends User> users) -> userRepository.saveAll(users));
	}
}

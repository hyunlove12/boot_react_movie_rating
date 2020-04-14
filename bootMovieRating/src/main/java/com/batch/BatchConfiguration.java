package com.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;

@Configuration
@EnableBatchProcessing
@ComponentScan("com.apress.springrecipes.springbatch")
// @PropertySource("classpath:/batch.properties")
public class BatchConfiguration {
	

	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public SimpleAsyncTaskExecutor taskExecutro() {
		return new SimpleAsyncTaskExecutor();
	}
	
	@Bean
	public Job flaskApiBatchJob(JobBuilderFactory jobBuilderFactory, Step flaskApiBatchJobStep) {		
		return jobBuilderFactory.get("flaskApiBatchJob")	
				.preventRestart()
				.start(flaskApiBatchJobStep)
				.build();
	}
	
	@Bean
	@JobScope
	public Step flaskApiBatchStep( @Value("#{jobParameters[key]}") String key) {
		System.out.println("key" + key);
		return stepBuilderFactory.get("flaskApiBatchJob")
				.<FlaskBatchVO, FlaskBatchVO> chunk(1)
				.reader(new FlaskBatchCallReader())
				.writer(new FlaskBatchCallWriter())
				.build();
	}
}

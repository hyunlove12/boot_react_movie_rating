package com.batch;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FlaskApiBatchJobConfig {
	
	/*
	 * @Bean public Job flaskApiBatchJob(JobBuilderFactory jobBuilderFactory, Step
	 * flaskApiBatchJobStep) { return jobBuilderFactory.get("flaskApiBatchJob")
	 * .preventRestart() .start(flaskApiBatchJobStep) .build(); }
	 * 
	 * @Bean public Step flaskApiBatchStep(StepBuilderFactory stepBuilderFactory) {
	 * return stepBuilderFactory.get("flaskApiBatchJob") .<FlaskBatchVO,
	 * FlaskBatchVO> chunk(10) .reader(new FlaskBatchCallReader()) .writer(new
	 * FlaskBatchCallWriter()) .build(); }
	 */
	
	/*@Bean
	@StepScope
	public QueueItemReader<FlaskBatchVO> flaskApiBatchReader() {
		RestTemplate restTemplate = new RestTemplate();
		
		List<FlaskBatchVO> flaskBatcResult = 
	}

	@Bean
	public ItemProcessor<FlaskBatchVO, FlaskBatchVO> flaskApiBatchProcessor() {
	    return user -> user.setInactive();
	}
	
	public ItemWriter<User> flaskApiBatchWriter() {
	    return ((List<? extends User> users) -> userRepository.saveAll(users));
	}*/
}

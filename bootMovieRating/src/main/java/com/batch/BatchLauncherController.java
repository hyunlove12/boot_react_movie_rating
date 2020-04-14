package com.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/batch/*")
public class BatchLauncherController {
	
	@Autowired
	JobLauncher jobLauncher;
	
	// @Autowired
	// JobRegistry jobRegistry;
	
	@Autowired
	Job job;
	
	// private ApplicationContext context = new AnnotationConfigApplicationContext(BatchConfiguration.class);
	
	@RequestMapping("/flaskJob/{bacthNo}")
	public void handle(@PathVariable("bacthNo") String bacthNo) throws Exception {
		// JobLauncher jobLauncher = context.getBean(JobLauncher.class);		                                   
		// Job job = context.getBean("flaskApiBatchJob", Job.class);		
		// jobLanuncher.run(jobRegistry.getJob("flaskApiBatchJob"), new JobParameters());	
		System.out.println("bacthNo" +bacthNo);
		this.jobLauncher.run(this.job, new JobParametersBuilder().addString("key", bacthNo).toJobParameters());
	}
}

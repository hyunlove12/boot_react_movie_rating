package com.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.JobRegistry;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/batch/*")
public class BatchLauncherController {
	
	@Autowired
	JobLauncher jobLanuncher;
	
	@Autowired
	JobRegistry jobRegistry;
	
	@Autowired
	Job job;
	
	@RequestMapping("/flaskJob")
	public void handle() throws Exception {
		jobLanuncher.run(jobRegistry.getJob("flaskApiBatchJob"), new JobParameters());
	}
}

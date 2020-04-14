package com.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.web.client.RestTemplate;

public class FlaskBatchCallReader implements ItemReader<FlaskBatchVO>{
	
	@Override
	public FlaskBatchVO read() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		FlaskBatchVO vo = new FlaskBatchVO();
		System.out.println("++++++++++++++++++++++++++");
		System.out.println(restTemplate.getForObject("http://localhost:5000/rating/batch", String.class));
		System.out.println(vo.toString());
		return vo;
	}
}

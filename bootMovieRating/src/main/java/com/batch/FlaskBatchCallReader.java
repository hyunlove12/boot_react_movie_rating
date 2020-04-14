package com.batch;

import org.springframework.batch.item.ItemReader;
import org.springframework.web.client.RestTemplate;

public class FlaskBatchCallReader implements ItemReader<FlaskBatchVO>{
	
	@Override
	public FlaskBatchVO read() throws Exception {
		RestTemplate restTemplate = new RestTemplate();
		FlaskBatchVO vo = new FlaskBatchVO();
		vo = restTemplate.getForObject("http://localhost:5000/rating/batch", FlaskBatchVO.class);
		return vo;
	}
}

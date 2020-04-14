package com.batch;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class FlaskBatchCallWriter implements ItemWriter<FlaskBatchVO>{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void write(List<? extends FlaskBatchVO> items) throws Exception {
		items.forEach(i -> this.write(i));
	}
	
	private void write(FlaskBatchVO vo) {
		sqlSession.insert("batch.insertBatchResult", vo);
	}
}

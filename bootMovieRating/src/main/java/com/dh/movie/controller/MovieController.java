package com.dh.movie.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dh.common.controller.ComController;
import com.dh.movie.service.MovieVO;
import com.dh.movie.serviceimpl.MovieServiceimpl;

@Controller
@RequestMapping("/api/movie/*")
public class MovieController extends ComController<MovieServiceimpl, MovieVO>{
	//web-inf 밑의 jsp가 루트 경로
	
	@Autowired
	MovieServiceimpl movieService;
	
	public MovieController() {
	}
	
	@ResponseBody 
	@RequestMapping("/ratingmovielist")
	public List<MovieVO> ratingmovielist() {
		System.out.println("호출!");
		List<MovieVO> ratingmovielist = new ArrayList<MovieVO>();
		ratingmovielist = movieService.ratingmovielist();	
		return ratingmovielist;
	}
	
	//flask연동 테스트
	@ResponseBody 
	@RequestMapping("/test")
	public String test() throws IOException, ParseException {
		System.out.println("호출!");
		URL url;
		try {
			url = new URL("http://localhost:5000/test");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
			conn.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
			// conn.setRequestMethod(METHOD_GET);
			conn.setRequestMethod(METHOD_POST);
			conn.setRequestProperty("Accept", "application/json");
			// 일반 form태그 방식
			// conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			conn.setRequestProperty("Content-Type", "application/json");
			
			
			

            //json으로 message를 전달하고자 할 때					
			conn.setDoInput(true);
			conn.setDoOutput(true); //POST 데이터를 OutputStream으로 넘겨 주겠다는 설정 
			conn.setUseCaches(false);
			conn.setDefaultUseCaches(false);
//			String parameter = String.format("param1=%s&param2=%s",URLEncoder.encode("param1"),URLEncoder.encode("param2"));
			String temp = String.format("param1=s1");
			Map<String, String> map = new HashMap<String, String>();
			map.put("d", "s");
			List<Map<String, String>> list = new ArrayList<Map<String, String>>();
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			OutputStream os = conn.getOutputStream();
			
			System.out.println(map.toString());
			
			JSONObject jsonObject = new JSONObject();

	        jsonObject.put("SECR_KEY", "ktko.tistory.com");
	        jsonObject.put("KEY", "ktko");
	        
	        JSONObject data = new JSONObject();
	        data.put("BANK_CD", "088");
	        data.put("SEARCH_ACCT_NO", "1231231234");
	        data.put("ACNM_NO", "123456");
	        data.put("ICHE_AMT", "0");
	        data.put("TRSC_SEQ_NO", "0000001");
	        
	        JSONArray req_array = new JSONArray();
	        req_array.add(data);
	        System.out.println(data);
	        jsonObject.put("REQ_DATA", req_array);


	        req_array.toString().getBytes("UTF-8");
	        System.out.println(req_array);
	        os.write(req_array.toString().getBytes("UTF-8"));
			// wr.write(req_array.toString().getBytes("UTF-8")); //json 형식의 message 전달 
			// wr.flush();
	        os.flush();

			
			
			
			StringBuilder sb = new StringBuilder();
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
				//Stream을 처리해줘야 하는 귀찮음이 있음. 
				BufferedReader br = new BufferedReader(
						new InputStreamReader(conn.getInputStream(), "utf-8"));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
				System.out.println("" + sb.toString());
			} else {
				System.out.println(conn.getResponseCode());
				System.out.println(conn.getResponseMessage());
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return "";
	}
	
}

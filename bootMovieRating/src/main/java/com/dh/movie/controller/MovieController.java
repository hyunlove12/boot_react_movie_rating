package com.dh.movie.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dh.common.controller.ComController;
import com.dh.movie.service.MovieVO;
import com.dh.movie.serviceimpl.MovieServiceimpl;

@Controller
@RequestMapping("/api/*")
public class MovieController extends ComController<MovieServiceimpl, MovieVO>{
	//web-inf 밑의 jsp가 루트 경로
	
	@Autowired
	MovieServiceimpl movieService;
	
	public MovieController() {
	}
	
	/**
	 * 평가해야 되는 6개의 랜덤 영화 출력
	 * @return
	 * @throws ParseException 
	 */
	@ResponseBody 
	@RequestMapping("/rating/movies")
	public List<MovieVO> ratingmovielist() throws ParseException {
		System.out.println("ratingmovielist");
		List<MovieVO> ratingmovielist = new ArrayList<MovieVO>();
		ratingmovielist = movieService.ratingmovielist();	
		
		JSONObject jsonObject = new JSONObject();
	//	jsonObject.put("success", "suc");
		
		
		JSONParser parser = new JSONParser();
		JSONArray req_array = new JSONArray();
		
		//(JSONArray) parser.parse(sb.toString());		
		//System.out.println(JSONArray.toJSONString(ratingmovielist));
		//req_array = (JSONArray) parser.parse(ratingmovielist.toString());
		
		//req_array.add(jsonObject);
		return ratingmovielist;
	}
	
	/**
	 * 영화 평가 후 영화 추천
	 * @param vo
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	@ResponseBody 
	@PostMapping("/rating")
	public List<MovieVO> rating(MovieVO vo) throws IOException, ParseException {
		System.out.println("rating");
		List<String> movieParam = new ArrayList<String>();
		List<MovieVO> suggetList = new ArrayList<MovieVO>();
		movieParam = this.getSuggestMovie();
		suggetList = movieService.suggestMovieList(movieParam);
		System.out.println(suggetList);
		return suggetList;
	}
		
	/**
	 * flask서버 연동하여 추천 영화 목록 가져오기
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	public JSONArray getSuggestMovie() throws IOException, ParseException {
		// rest템플릿 사용 방법
		// http객체 사용 방법
		
		System.out.println("getSuggestMovie");
		JSONArray req_array = new JSONArray();	
		URL url;
		url = new URL("http://localhost:5000/rating");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		try {			
			conn.setConnectTimeout(5000); //서버에 연결되는 Timeout 시간 설정
			conn.setReadTimeout(5000); // InputStream 읽어 오는 Timeout 시간 설정
			// conn.setRequestMethod(METHOD_GET);
			conn.setRequestMethod(METHOD_POST);
			// 수신받는 데이터 종류 -> aceept header
			conn.setRequestProperty("Accept", "application/json");
			// 일반 form태그 방식
			// conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			// json 방식
			conn.setRequestProperty("Content-Type", "application/json");
			
           			
			conn.setDoInput(true);
			conn.setDoOutput(true); //POST 데이터를 OutputStream으로 넘겨 주겠다는 설정 -> default는 true
			conn.setUseCaches(false);
			conn.setDefaultUseCaches(false);

			
			//OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
			OutputStream os = conn.getOutputStream();
			
			List<Integer> list1 = new ArrayList<Integer>();
	        list1.add(1);
	        list1.add(2);
	        list1.add(3);
	        list1.add(5);
	        list1.add(6);
	        list1.add(7);
	        
	        List<Integer> list2 = new ArrayList<Integer>();
	        list2.add(1);
	        list2.add(2);
	        list2.add(3);
	        list2.add(3);
	        list2.add(2);
	        list2.add(3);
			
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("movieid", list1);
			jsonObject.put("rating", list2);
			System.out.println(jsonObject);
	        
			JSONParser parser = new JSONParser();
			
	               
	       // jsonObject.put("REQ_DATA", req_array);
	       
	        
	        // os.write(data.toJSONString().getBytes("UTF-8"));
			// os.write(req_array.toJSONString().getBytes("UTF-8"));
			os.write(jsonObject.toString().getBytes("UTF-8"));
			os.flush();
			
			// String -> 일반 form형식 
	        //wr.write(temp);
			//wr.flush();

			
			StringBuilder sb = new StringBuilder();
			if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {				
				BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
				String line;
				// 1. buffer클래스란?
				// 2. 자바 list로 변환할 수는 없는가?
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
				req_array = (JSONArray) parser.parse(sb.toString());				
			} else {
				System.out.println(conn.getResponseCode());
				System.out.println(conn.getResponseMessage());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			conn.disconnect();
		}
		return req_array;
	}
	
}

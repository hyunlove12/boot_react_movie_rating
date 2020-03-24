package com.dh.movie.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dh.common.serviceimpl.ComServiceimpl;
import com.dh.movie.service.MovieService;
import com.dh.movie.service.MovieVO;


@Service
public class MovieServiceimpl extends ComServiceimpl<MovieServiceimpl, MovieMapper> implements MovieService {
	
	@Autowired
	MovieMapper movieMapper;
	
	// 랜덤 영화 6편 출력
	public List<MovieVO> ratingmovielist() {
		List<MovieVO> ratingmovielist = new ArrayList<MovieVO>(); 
		ratingmovielist = movieMapper.ratingmovielist();
		return ratingmovielist;
	}
	
	// 추천 영화 6편 출력
	public List<MovieVO> suggestMovieList(List<String> movieList) {
		List<MovieVO> ratingmovielist = new ArrayList<MovieVO>(); 
		ratingmovielist = movieMapper.suggestMovieList(movieList);
		return ratingmovielist;
	}
	
}

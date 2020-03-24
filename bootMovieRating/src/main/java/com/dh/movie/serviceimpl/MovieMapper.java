package com.dh.movie.serviceimpl;

import java.util.List;

import com.dh.movie.service.MovieVO;

public interface MovieMapper {
	
	// 랜덤 영화 6편 출력
	public List<MovieVO> ratingmovielist();
	
	// 추천 영화 6편 출력
	public List<MovieVO> suggestMovieList(List<String> movieList);
	
}
package com.dh.movie.service;

import java.util.List;

public interface MovieService {
	
	// 랜덤 영화 6편 출력
	public List<MovieVO> ratingmovielist();
	
	// 추천 영화 6편 출력
	public List<MovieVO> suggestMovieList(List<String> movieList);
	
}

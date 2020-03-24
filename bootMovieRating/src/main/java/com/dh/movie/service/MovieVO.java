package com.dh.movie.service;

import java.io.Serializable;

import com.dh.common.service.ComVO;

public class MovieVO extends ComVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1;	
	
	private String movieId = "";
	private String title = "";
	private String imgTitle = "";
	
	public String getMovieId() {
		return movieId;
	}
	public void setMovieId(String movieId) {
		this.movieId = movieId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getImgTitle() {
		return imgTitle;
	}
	public void setImgTitle(String imgTitle) {
		this.imgTitle = imgTitle;
	}
	
	
	
}

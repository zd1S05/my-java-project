package com.example.app.service;

import java.util.List;

import com.example.app.domain.Genre;

public interface GenreService {
	
	List<Genre> getGenreList() throws Exception;
	
	List<Genre> getGenreListByStyle(String style) throws Exception;
	
}

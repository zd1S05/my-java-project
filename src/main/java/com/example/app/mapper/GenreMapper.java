package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Genre;

public interface GenreMapper {
	
	List<Genre> selectAll() throws Exception;
	
	List<Genre> selectByStyle(String style) throws Exception;
	
}

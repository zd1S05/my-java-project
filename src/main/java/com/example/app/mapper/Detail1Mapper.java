package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Detail1;

public interface Detail1Mapper {
	
	List<Detail1> selectAll() throws Exception;
	
	List<Detail1> selectByGenre(String genre) throws Exception;

}

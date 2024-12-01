package com.example.app.service;

import java.util.List;

import com.example.app.domain.Detail1;

public interface Detail1Service {

	List<Detail1> getDetail1List() throws Exception;
	
	List<Detail1> getDetail1ListByGenre(String genre) throws Exception;
}

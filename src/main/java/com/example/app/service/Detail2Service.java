package com.example.app.service;

import java.util.List;

import com.example.app.domain.Detail2;

public interface Detail2Service {
	
	List<Detail2> getDetail2List() throws Exception;
	
	List<Detail2> getDetail2ListByDetail1(String detail1) throws Exception;
 	
}

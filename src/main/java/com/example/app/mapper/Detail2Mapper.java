package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Detail2;

public interface Detail2Mapper {
	
	List<Detail2> selectAll() throws Exception;
	
	List<Detail2> selectByDetail1(String detail1) throws Exception;
	
}

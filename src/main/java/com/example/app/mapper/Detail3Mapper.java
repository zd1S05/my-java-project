package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Detail3;

public interface Detail3Mapper {
	
	List<Detail3> selectAll() throws Exception;
	
	List<Detail3> selectByDetail2(String detail2) throws Exception;
	
}

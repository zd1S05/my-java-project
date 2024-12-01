package com.example.app.service;

import java.util.List;

import com.example.app.domain.Detail3;

public interface Detail3Service {
	
	List<Detail3> getDetail3List() throws Exception;
	
	List<Detail3> getDetail3ListByDetail2(String detail2) throws Exception;

}

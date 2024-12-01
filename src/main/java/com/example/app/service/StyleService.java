package com.example.app.service;

import java.util.List;

import com.example.app.domain.Style;

public interface StyleService {
	
	List<Style> getStyleList() throws Exception;
}

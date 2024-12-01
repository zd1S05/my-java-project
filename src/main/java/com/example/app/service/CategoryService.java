package com.example.app.service;

import java.util.List;

import com.example.app.domain.Category;

public interface CategoryService {
	
	List<Category> getCategoryList() throws Exception;
	
	Category getCategoryById(Integer id) throws Exception;

}

package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Category;

public interface CategoryMapper {
	
	List<Category> selectAll() throws Exception;
	
	Category selectById(Integer id) throws Exception;
	
}

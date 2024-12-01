package com.example.app.mapper;

import java.util.List;

import com.example.app.domain.Image;

public interface ImageMapper {
	
	List<Image> selectAll() throws Exception;
	
	Image selectById(Integer id) throws Exception;
	
	void insert(Image image) throws Exception;
	void update(Image image) throws Exception;
	void delete(Integer id) throws Exception;
}

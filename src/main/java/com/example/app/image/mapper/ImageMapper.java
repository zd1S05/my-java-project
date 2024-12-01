package com.example.app.image.mapper;

import java.util.List;

import com.example.app.image.domain.Image;

public interface ImageMapper {
	
	List<Image> selectAll() throws Exception;
	
	Image selectById(Integer id) throws Exception;
	
	void insert(Image image) throws Exception;
	void update(Image image) throws Exception;
	void deleteForItem(Integer id) throws Exception;
	void deleteForImage(Integer id) throws Exception;
}

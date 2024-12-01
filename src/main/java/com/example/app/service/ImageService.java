package com.example.app.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.domain.Image;

public interface ImageService {
	
	List<Image> getImageList() throws Exception;
	
	Image getImageById(Integer id) throws Exception;
	
	void addImage(Image image) throws Exception;
	
	void editImage(Image image) throws Exception;
	
	void deleteImage(Integer id) throws Exception;

	
	String getImageName(MultipartFile image) throws Exception;
	
	//String saveImage(MultipartFile image) throws Exception;
	
	//void validateImage(MultipartFile file, Errors errors, String fileldName) throws Exception;
}

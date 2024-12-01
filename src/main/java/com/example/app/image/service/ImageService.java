package com.example.app.image.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.image.domain.Image;

public interface ImageService {

	List<Image> getImageList() throws Exception;

	Image getImageById(Integer id) throws Exception;

	void addImage(Image image) throws Exception;

	void editImage(Image image) throws Exception;

	void deleteImageForItem(Integer id) throws Exception;

	void deleteImageForImage(Integer id) throws Exception;

	String getImageName(MultipartFile image) throws Exception;
}

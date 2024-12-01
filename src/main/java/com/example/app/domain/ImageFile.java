package com.example.app.domain;

import org.springframework.web.multipart.MultipartFile;

import com.example.app.validation.ValidImage;

import lombok.Data;

@Data
public class ImageFile{
	
	@ValidImage
	private MultipartFile imageFile1; 
	@ValidImage
	private MultipartFile imageFile2; 
	@ValidImage
	private MultipartFile imageFile3; 
	@ValidImage
	private MultipartFile imageFile4; 
	@ValidImage
	private MultipartFile imageFile5; 
	@ValidImage
	private MultipartFile imageFile6; 
	@ValidImage
	private MultipartFile imageFile7; 
	@ValidImage
	private MultipartFile imageFile8; 
	@ValidImage
	private MultipartFile imageFile9; 
	@ValidImage
	private MultipartFile imageFile10; 
}

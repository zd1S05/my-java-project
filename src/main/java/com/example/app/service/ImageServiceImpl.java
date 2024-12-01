package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.app.domain.Image;
import com.example.app.mapper.ImageMapper;

import lombok.RequiredArgsConstructor;


@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
	
	private final ImageMapper imagemapper;
	
	@Override
	public List<Image> getImageList() throws Exception {
		return imagemapper.selectAll();
	}
	@Override
	public Image getImageById(Integer id) throws Exception {
		return imagemapper.selectById(id);
	}

	@Override
	public void addImage(Image image) throws Exception {
		imagemapper.insert(image);		
	}

	@Override
	public void editImage(Image image) throws Exception {
		imagemapper.update(image);
	}

	@Override
	public void deleteImage(Integer id) throws Exception {
		imagemapper.delete(id);
	}

	@Override
	public String getImageName(MultipartFile image) throws Exception {
		String fileName = image.getOriginalFilename();
		return fileName;
	}
	
	/*
	@Override
	public String saveImage(MultipartFile image) throws Exception {
		String fileName = image.getOriginalFilename();
		File dest = new File("C:/Users/zd1S05/uploads/" + fileName);
		image.transferTo(dest);
		return fileName;		
	}
	
	
	@Override
	public void validateImage(MultipartFile file, Errors errors, String fileldName) throws Exception {
		if(file.isEmpty()) {
			return;
		}
		
		String contentType = file.getContentType();
		if(contentType==null || contentType.startsWith("image/")) {
			errors.rejectValue(fileldName, "invalid.file.type", "Only image files are allowed.");
		}
	}
	*/

}

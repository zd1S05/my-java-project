package com.example.app.validation;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ImageValidator implements ConstraintValidator<ValidImage	, MultipartFile> {
	
	@Override
    public void initialize(ValidImage constraintAnnotation) {
    }

    @Override
    public boolean isValid(MultipartFile file, ConstraintValidatorContext context) {
        if (file == null || file.isEmpty()) {
            return true;  
        }
        
        String contentType = file.getContentType();
        return contentType != null && contentType.startsWith("image/");  // 画像かどうかを判定
    }


}

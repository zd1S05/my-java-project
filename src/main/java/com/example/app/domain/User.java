package com.example.app.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class User {
	
	private Integer id;
	
	@NotBlank
	private String loginId;
	
	private String loginPass;
	
}

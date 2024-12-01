package com.example.app.domain;

import lombok.Data;

@Data
public class Category {
	
	private Integer id;
	private Integer categoryId;
	private Integer styleId;
	private Integer genreId;
	private Integer detail1Id;
	private Integer detail2Id;
	private Integer detail3Id;
	
	private Style style;
	private Genre genre;
	private Detail1 detail1;
	private Detail2 detail2;
	private Detail3 detail3;
}

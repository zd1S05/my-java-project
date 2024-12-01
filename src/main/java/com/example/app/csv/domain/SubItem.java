package com.example.app.csv.domain;

import lombok.Data;

@Data
public class SubItem {

	private Integer id; 
	private Integer initialPrice;
	private Integer itemCount; 
	private Integer janCode; 
	private String itemSubcondition; 
	private String returnSubpolicy; 
	private String featuredAuction;
	private String recommendedCollection;
	private String fixedShippingFee; 
}

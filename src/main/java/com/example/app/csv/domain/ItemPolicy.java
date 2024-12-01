package com.example.app.csv.domain;

import lombok.Data;

@Data
public class ItemPolicy {

	private Integer id;
	private String returnPolicy;
	private String bidderRatingLimit; 
	private String negativeFeedbackLimit; 
	private String bidderAuthenticationRequired; 
	private String autoExtend;
	private String earlyClosing; 
	private String negotiable; 
	private String autoRelist;
	private String autoDiscount; 
	private String autoDiscountRate;

}

package com.example.app.csv.domain;

import lombok.Data;

@Data
public class Payment {

	private Integer id; 
    private String shippingFeePayer;      
    private String paymentMethod;          
    private String yahooPaymentMethod;    
    private String bankId1;               
    private String codPayment;            

}

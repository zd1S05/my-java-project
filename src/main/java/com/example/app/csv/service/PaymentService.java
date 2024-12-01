package com.example.app.csv.service;

import com.example.app.csv.domain.Payment;

public interface PaymentService {
	
	Payment getPayment (Integer id) throws Exception;
	
}

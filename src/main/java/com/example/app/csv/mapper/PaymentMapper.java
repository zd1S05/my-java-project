package com.example.app.csv.mapper;

import com.example.app.csv.domain.Payment;

public interface PaymentMapper {
	
	Payment selectById(Integer id);
	
}

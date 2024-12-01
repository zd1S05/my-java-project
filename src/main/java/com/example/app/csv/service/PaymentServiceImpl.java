package com.example.app.csv.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.csv.domain.Payment;
import com.example.app.csv.mapper.PaymentMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
	
	private final PaymentMapper paymentmapper;
	
	@Override
	public Payment getPayment(Integer id) throws Exception {
		return paymentmapper.selectById(id);
	}

}

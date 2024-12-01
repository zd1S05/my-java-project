package com.example.app.csv.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.csv.domain.ShippingMethod2;
import com.example.app.csv.mapper.ShippingMethod2Mapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class ShippingMethod2ServiceImpl implements ShippingMethod2Service {
	
	private final ShippingMethod2Mapper shippingmethod2mapper;
	
	@Override
	public ShippingMethod2 getShippingMethod2(Integer id) throws Exception {
		return shippingmethod2mapper.selectById(id);
	}

}

package com.example.app.csv.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.csv.domain.ShippingMethod1;
import com.example.app.csv.mapper.ShippingMethod1Mapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class ShippingMethod1ServiceImpl implements ShippingMethod1Service {

	private final ShippingMethod1Mapper shippingmethod1mapper;

	@Override
	public ShippingMethod1 getShippingMethod1(Integer id) throws Exception {
		return shippingmethod1mapper.selectById(id);
	}

}

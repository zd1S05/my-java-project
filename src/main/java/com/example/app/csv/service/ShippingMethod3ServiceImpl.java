package com.example.app.csv.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.csv.domain.ShippingMethod3;
import com.example.app.csv.mapper.ShippingMethod3Mapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class ShippingMethod3ServiceImpl implements ShippingMethod3Service {
	
	private final ShippingMethod3Mapper shippingmethod3mapper;
	
	@Override
	public ShippingMethod3 getShippingMethod3(Integer id) throws Exception {
		return shippingmethod3mapper.selectById(id);
	}

}

package com.example.app.csv.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.csv.domain.ItemPolicy;
import com.example.app.csv.mapper.ItemPolicyMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class ItemPolicyServiceImpl implements ItemPolicyService{
	
	private final ItemPolicyMapper itempolicymapper;

	@Override
	public ItemPolicy getItemPolicy(Integer id) throws Exception {
		return itempolicymapper.selectById(id);
	}

}

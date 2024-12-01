package com.example.app.csv.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.csv.domain.SubItem;
import com.example.app.csv.mapper.SubItemMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class SubItemServiceImpl implements SubItemService {
	
	private final SubItemMapper subitemmapper;
	
	@Override
	public SubItem getSubItem(Integer id) throws Exception {
		return subitemmapper.selectById(id);
	}

}

package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Style;
import com.example.app.mapper.StyleMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class StyleServiceImpl implements StyleService {
	
	private final StyleMapper stylemapper;
	
	@Override
	public List<Style> getStyleList() throws Exception {
		return stylemapper.selectAll();
	}

}

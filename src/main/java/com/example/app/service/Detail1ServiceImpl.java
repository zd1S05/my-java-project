package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Detail1;
import com.example.app.mapper.Detail1Mapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class Detail1ServiceImpl implements Detail1Service {
	
	private final Detail1Mapper detail1mapper;

	@Override
	public List<Detail1> getDetail1List() throws Exception {
		return detail1mapper.selectAll();
	}

	@Override
	public List<Detail1> getDetail1ListByGenre(String genre) throws Exception {
		return detail1mapper.selectByGenre(genre);
	}

}

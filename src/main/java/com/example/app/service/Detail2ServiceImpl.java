package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Detail2;
import com.example.app.mapper.Detail2Mapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class Detail2ServiceImpl implements Detail2Service{
	
	private final Detail2Mapper detail2mapper;
	
	@Override
	public List<Detail2> getDetail2List() throws Exception {
		return detail2mapper.selectAll();
	}

	@Override
	public List<Detail2> getDetail2ListByDetail1(String detail1) throws Exception {
		return detail2mapper.selectByDetail1(detail1);
	}
	
}

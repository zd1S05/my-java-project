package com.example.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.domain.Detail3;
import com.example.app.mapper.Detail3Mapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class Detail3ServiceImpl implements Detail3Service {
	
	private final Detail3Mapper detail3mapper;

	@Override
	public List<Detail3> getDetail3List() throws Exception {
		return detail3mapper.selectAll();
	}

	@Override
	public List<Detail3> getDetail3ListByDetail2(String detail2) throws Exception {
		return detail3mapper.selectByDetail2(detail2);
	}

}

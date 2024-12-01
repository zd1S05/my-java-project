package com.example.app.csv.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.csv.domain.ImagesForCsv;
import com.example.app.csv.mapper.ImagesForCsvMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class ImagesForCsvServiceImpl implements ImagesForCsvService {
	
	private final ImagesForCsvMapper imagesforcsvmapper;

	@Override
	public ImagesForCsv getImages(Integer itemId) throws Exception {
		return imagesforcsvmapper.selectByItemId(itemId);
	}

}

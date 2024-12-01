package com.example.app.csv.service;

import com.example.app.csv.domain.ImagesForCsv;

public interface ImagesForCsvService {
	
	ImagesForCsv getImages(Integer itemId) throws Exception;

}

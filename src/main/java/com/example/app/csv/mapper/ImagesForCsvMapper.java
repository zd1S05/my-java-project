package com.example.app.csv.mapper;

import com.example.app.csv.domain.ImagesForCsv;

public interface ImagesForCsvMapper {
	
	ImagesForCsv selectByItemId(Integer itemId);

}

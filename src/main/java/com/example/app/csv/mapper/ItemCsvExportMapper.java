package com.example.app.csv.mapper;

import java.time.LocalDate;
import java.util.List;

import com.example.app.csv.domain.ItemForCsv;

public interface ItemCsvExportMapper {
	
	List<ItemForCsv> selectByListingDate(LocalDate listingDate) throws Exception;
	
}

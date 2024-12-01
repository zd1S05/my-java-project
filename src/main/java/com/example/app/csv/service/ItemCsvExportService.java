package com.example.app.csv.service;

import java.time.LocalDate;
import java.util.List;

import com.example.app.csv.domain.ItemForCsv;

public interface ItemCsvExportService {
	
	public void exportCsvByListingDate(LocalDate listingDate) throws Exception;
	
	List<ItemForCsv> getItemByListingDate(LocalDate listingDate) throws Exception;
	
}

package com.example.app.csv.controller;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.csv.service.ItemCsvExportService;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/csv")
@RequiredArgsConstructor
public class CsvExportController {
	
	private final ItemCsvExportService service;
	
	@GetMapping("/csvExport")
	public String getCsvExport(Model model) {
		return "csv/csvExport";
	}
	
	
	@PostMapping("/csvExport")
	public String postCsvExport(@RequestParam("listingDate") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate listingDate,
								HttpServletResponse response,
								RedirectAttributes rd
								)throws Exception {
		
		try {
			service.exportCsvByListingDate(listingDate);
			rd.addFlashAttribute("statusMessage","CSVダウンロード処理が成功しました。");
			return "redirect:/items";
		} catch (Exception e) {
			System.out.println(e);
			rd.addFlashAttribute("statusMessage","選択した出品日はありません。");
			return "redirect:/csv/csvExport";
		}
	}
	
	

}

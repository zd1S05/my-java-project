package com.example.app.csv.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.app.csv.domain.ItemForCsv;
import com.example.app.csv.mapper.ImagesForCsvMapper;
import com.example.app.csv.mapper.ItemCsvExportMapper;
import com.example.app.csv.mapper.ItemPolicyMapper;
import com.example.app.csv.mapper.PaymentMapper;
import com.example.app.csv.mapper.ShippingMethod1Mapper;
import com.example.app.csv.mapper.ShippingMethod2Mapper;
import com.example.app.csv.mapper.ShippingMethod3Mapper;
import com.example.app.csv.mapper.SubItemMapper;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(rollbackFor= Exception.class)
@RequiredArgsConstructor
public class ItemCsvExportServiceImpl implements ItemCsvExportService {

	private final ItemCsvExportMapper itemcsvexportmapper;
	
	private final ImagesForCsvMapper imagesmapper;
	
	private final ItemPolicyMapper itempolicymapper;
	
	private final PaymentMapper paymentmapper;
	
	private final ShippingMethod1Mapper shippingmethod1mapper;
	
	private final ShippingMethod2Mapper shippingmethod2mapper;
	
	private final ShippingMethod3Mapper shippingmethod3mapper;
	
	private final SubItemMapper subitemmapper;
	
	@Override
	public void exportCsvByListingDate(LocalDate listingDate) throws Exception {
			List<ItemForCsv> items = itemcsvexportmapper.selectByListingDate(listingDate);
			
			if (items == null || items.isEmpty()) {
		        throw new Exception("No items found for the specified listing date.");
		    }
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			String formattedDate = listingDate.format(formatter);
			
			Path outputPath = Paths.get("C:/Users/zd1S05/Desktop/auctown/" + formattedDate);
			
			if(!Files.exists(outputPath)) {
				Files.createDirectories(outputPath);
			}
			
			Path csvFilePath = outputPath.resolve(formattedDate + ".csv");
			
			CsvFileWriter.writerItemsToCsv(items, imagesmapper, itempolicymapper, paymentmapper, shippingmethod1mapper, shippingmethod2mapper, shippingmethod3mapper, subitemmapper, csvFilePath);
			
			
			/*
			File file = csvFilePath.toFile();
			
			if(file.exists()) {
				response.setContentType("application/csv");
				 response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
				 
				 try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(file));
					  OutputStream out = response.getOutputStream()){
					byte[] buffer = new byte[1024];
					int length;
					while((length = in.read(buffer))>0) {
						out.write(buffer,0,length);
					}
				} 
				
			}else {
				throw new FileNotFoundException("CSVファイルが見つかりませんでした");
			}
			*/
		}
		/*
		List<ItemForCsv> items = itemcsvexportmapper.selectByListingDate(listingDate);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String formattedDate = listingDate.format(formatter);
		
		Path outputPath = Paths.get("C:/Users/zd1S05/Desktop/auctown/"+formattedDate+"/"+formattedDate+".csv");
		
		System.out.println("フォルダの場所"+outputPath);
		
		CsvFileWriter.writerItemsToCsv(items, outputPath,
										 imagesmapper,
										 itempolicymapper,
										 paymentmapper,
										 shippingmethod1mapper,
										 shippingmethod2mapper,
										 shippingmethod3mapper,
										 subitemmapper);
	*/
	
	
	@Override
	public List<ItemForCsv> getItemByListingDate(LocalDate listingDate) throws Exception {
		return itemcsvexportmapper.selectByListingDate(listingDate);
	}

		

}

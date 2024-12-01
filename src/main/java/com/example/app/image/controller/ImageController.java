package com.example.app.image.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Item;
import com.example.app.image.domain.Image;
import com.example.app.image.domain.ImageFile;
import com.example.app.image.service.ImageService;
import com.example.app.service.ItemService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/images")
@RequiredArgsConstructor
public class ImageController {
	
	private final ItemService itemService;
	
	private final ImageService imageService;
	
	@GetMapping("/addImage/{id}")
	public String addImageGet(@PathVariable Integer id,
							   Model model) throws Exception {
		Item item = itemService.getItemById(id);
		Image image = imageService.getImageById(id);
		model.addAttribute("imageFile", new ImageFile());
		model.addAttribute("image", image);
		model.addAttribute("item",item);
		model.addAttribute("title", "画像を更新する");
		return "images/addImage";
	}
	
	@PostMapping("/addImage/{id}")
	public String addImagePost(@Valid ImageFile imageFile,
								Errors errors,
								RedirectAttributes rd,
								@PathVariable Integer id,
								Model model
								) throws Exception {
		
		if (errors.hasErrors()) {
			Item item = itemService.getItemById(id);
			Image image = imageService.getImageById(id);
			model.addAttribute("title", "画像を更新する");
			model.addAttribute("item",item);
			model.addAttribute("image", image);
			return "images/addImage";
		}

		Image image = imageService.getImageById(id);

		MultipartFile imageFile1  = imageFile.getImageFile1();
		if (imageFile1  != null && !imageFile1 .isEmpty()) {
			image.setImage1(imageService.getImageName(imageFile1 ));
		}

		MultipartFile imageFile2  = imageFile.getImageFile2();
		if (imageFile2  != null && !imageFile2 .isEmpty()) {
			image.setImage2(imageService.getImageName(imageFile2 ));
		}

		MultipartFile imageFile3  = imageFile.getImageFile3();
		if (imageFile3  != null && !imageFile3 .isEmpty()) {
			image.setImage3(imageService.getImageName(imageFile3 ));
		}

		MultipartFile imageFile4  = imageFile.getImageFile4();
		if (imageFile4  != null && !imageFile4 .isEmpty()) {
			image.setImage4(imageService.getImageName(imageFile4 ));
		}

		MultipartFile imageFile5  = imageFile.getImageFile5();
		if (imageFile5  != null && !imageFile5 .isEmpty()) {
			image.setImage5(imageService.getImageName(imageFile5 ));
		}

		MultipartFile imageFile6  = imageFile.getImageFile6();
		if (imageFile6  != null && !imageFile6 .isEmpty()) {
			image.setImage6(imageService.getImageName(imageFile6 ));
		}

		MultipartFile imageFile7  = imageFile.getImageFile7();
		if (imageFile7  != null && !imageFile7 .isEmpty()) {
			image.setImage7(imageService.getImageName(imageFile7 ));
		}

		MultipartFile imageFile8  = imageFile.getImageFile8();
		if (imageFile8  != null && !imageFile8 .isEmpty()) {
			image.setImage8(imageService.getImageName(imageFile8 ));
		}

		MultipartFile imageFile9  = imageFile.getImageFile9();
		if (imageFile9  != null && !imageFile9 .isEmpty()) {
			image.setImage9(imageService.getImageName(imageFile9 ));
		}

		MultipartFile imageFile10  = imageFile.getImageFile10();
		if (imageFile10  != null && !imageFile10 .isEmpty()) {
			image.setImage10(imageService.getImageName(imageFile10 ));
		}

		imageService.editImage(image);
		rd.addFlashAttribute("statusMessage", "画像を更新しました。");
		return "redirect:/items";
	}
	
	@GetMapping("/deleteImage/{id}")
	public String deleteImage(@PathVariable Integer id,
							   RedirectAttributes rd,
							   Model model
							   )throws Exception{
		Item item = itemService.getItemById(id);
		Image image = imageService.getImageById(id);
		model.addAttribute(item);
		model.addAttribute(image);
		imageService.deleteImageForImage(id);
		rd.addFlashAttribute("statusMessage", "画像を削除しました。");
		return "redirect:/images/addImage/{id}";
		
	}

}

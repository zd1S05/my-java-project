package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Item;
import com.example.app.image.domain.Image;
import com.example.app.image.service.ImageService;
import com.example.app.service.ItemService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/items")
@RequiredArgsConstructor

public class ItemController {

	private final ItemService itemService;

	private final ImageService imageService;
	
	@GetMapping
	public String list( Model model
					    ) throws Exception {		
		List<Item> items = itemService.getItemList();		
		model.addAttribute("items", items);
		return "items/list";
	}
		
	
	@GetMapping("/add")
	public String addGet(Model model,
						  HttpSession session
						  ) throws Exception {
		
		System.out.println("Login successful. Session loginId: " + session.getAttribute("loginId"));
		
	    model.addAttribute("title", "商品登録");
	    model.addAttribute("item", new Item());
	    model.addAttribute("source","new");
	    return "items/save";
	}
	
	
	@PostMapping("/add")
	public String addPost(@Valid Item item,
						   Errors errors,
						   HttpSession session,
						   RedirectAttributes rd,
						   Model model) throws Exception {
		
		System.out.println("Login successful. Session loginId: " + session.getAttribute("loginId"));
		
		if (errors.hasErrors()) {
			model.addAttribute("title", "商品登録");
			return "items/save";
		}
		
		item.setCreatedBy((String) session.getAttribute("loginId"));
		itemService.addItem(item);
		
		Image image = new Image();
		image.setItemId(item.getId());
		imageService.addImage(image);
		
		rd.addFlashAttribute("statusMessage", "商品を追加しました。");
		return "redirect:/items";
	}
	
	
	
	@GetMapping("/edit/{id}")
	public String editGet(@PathVariable Integer id,
						   Model model,
						   HttpSession session
						   ) throws Exception {
		
		System.out.println(session.getAttribute("loginId"));
		
		Item item=itemService.getItemById(id);
		model.addAttribute("title", "商品情報の更新");
		model.addAttribute("item", item);
		model.addAttribute("source","edit");
		return "items/save";
	}
	
	
	@PostMapping("/edit/{id}")
	public String editPost(@PathVariable Integer id,
							@Valid Item item,
							Errors errors,
							RedirectAttributes rd,
							HttpSession session,
							Model model) throws Exception {
		
		System.out.println(session.getAttribute("loginId"));


		if (errors.hasErrors()) {
			model.addAttribute("title", "商品登録");
			return "items/save";
		}
		
		item.setCreatedBy((String) session.getAttribute("loginId"));
		itemService.editItem(item);
		rd.addFlashAttribute("statusMessage", "商品を更新しました。");
		
		return "redirect:/items";

	}
	
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id, RedirectAttributes rd) throws Exception {
		itemService.deleteItem(id);
		imageService.deleteImageForItem(id);
		rd.addFlashAttribute("statusMessage", "商品を削除しました。");
		return "redirect:/items";

	}
	
	

}

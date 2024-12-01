package com.example.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.app.domain.Category;
import com.example.app.domain.Detail1;
import com.example.app.domain.Detail2;
import com.example.app.domain.Detail3;
import com.example.app.domain.Genre;
import com.example.app.domain.Item;
import com.example.app.domain.Style;
import com.example.app.image.domain.Image;
import com.example.app.image.service.ImageService;
import com.example.app.service.CategoryService;
import com.example.app.service.Detail1Service;
import com.example.app.service.Detail2Service;
import com.example.app.service.Detail3Service;
import com.example.app.service.GenreService;
import com.example.app.service.ItemService;
import com.example.app.service.StyleService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
	
	private final ItemService itemService;
	
	private final CategoryService categoryService;
	
	private final StyleService styleService;
	
	private final GenreService genreService;
	
	private final Detail1Service detail1Service;
	
	private final Detail2Service detail2Service;
	
	private final Detail3Service detail3Service;
	
	private final ImageService imageService;
	
	@GetMapping("/categoryForNew")
	public String categoryGetForNew(Model model
									 ) throws Exception {
		List<Category> categorys = categoryService.getCategoryList();
		List<Style> styles = styleService.getStyleList();
		
		model.addAttribute("categorys",categorys);
		model.addAttribute("styles",styles);
		model.addAttribute("source", "new");
		model.addAttribute("title",  "カテゴリ取得");
		
		return "categories/category";
	}
	
	@GetMapping("/categoryForEdit/{id}")
	public String categoryGetForEdit(Model model,
									  @PathVariable Integer id
									 ) throws Exception {
		
		List<Category> categorys = categoryService.getCategoryList();
		List<Style> styles = styleService.getStyleList();
		
		model.addAttribute("item",itemService.getItemById(id));
		model.addAttribute("categorys",categorys);
		model.addAttribute("styles",styles);		
		model.addAttribute("source", "edit");
		model.addAttribute("title",  "ID"+id+"カテゴリ更新");
		
		return "categories/categoryForEdit";
	}
	
	@GetMapping("/category/genres")
	@ResponseBody
	public List<Genre> getGenresByStyle(@RequestParam("style") String style
										 ) throws Exception {
	    List<Genre> genres = genreService.getGenreListByStyle(style);
	    System.out.println(genres);
	    return genres;
	}
	
	@GetMapping("/category/detail1s")
	@ResponseBody
	public List<Detail1> getDetail1ByGenre(@RequestParam("genre") String genre
											) throws Exception{
		List<Detail1> detail1s = detail1Service.getDetail1ListByGenre(genre);
		System.out.println(detail1s);
		return detail1s;
	}
	
	@GetMapping("/category/detail2s")
	@ResponseBody
	public List<Detail2> getDetail2ByDetail1(@RequestParam("detail1") String detail1
											  ) throws Exception{
		List<Detail2> detail2s = detail2Service.getDetail2ListByDetail1(detail1);
		System.out.println(detail2s);
		return detail2s;
	}
	
	@GetMapping("/category/detail3s")
	@ResponseBody
	public List<Detail3> getDetail3ByDetail2(@RequestParam("detail2") String detail2
											  ) throws Exception{
		List<Detail3> detail3s = detail3Service.getDetail3ListByDetail2(detail2);
		System.out.println(detail3s);
		return detail3s;
	}
	
	@GetMapping("/categoryForEdit/genres")
	@ResponseBody
	public List<Genre> getGenresByStyleForEdit(@RequestParam("style") String style
										 ) throws Exception {
	    List<Genre> genres = genreService.getGenreListByStyle(style);
	    System.out.println(genres);
	    return genres;
	}
	
	@GetMapping("/categoryForEdit/detail1s")
	@ResponseBody
	public List<Detail1> getDetail1ByGenreForEdit(@RequestParam("genre") String genre
											) throws Exception{
		List<Detail1> detail1s = detail1Service.getDetail1ListByGenre(genre);
		System.out.println(detail1s);
		return detail1s;
	}
	
	@GetMapping("/categoryForEdit/detail2s")
	@ResponseBody
	public List<Detail2> getDetail2ByDetail1ForEdit(@RequestParam("detail1") String detail1
											  ) throws Exception{
		List<Detail2> detail2s = detail2Service.getDetail2ListByDetail1(detail1);
		System.out.println(detail2s);
		return detail2s;
	}
	
	@GetMapping("/categoryForEdit/detail3s")
	@ResponseBody
	public List<Detail3> getDetail3ByDetail2ForEdit(@RequestParam("detail2") String detail2
											  ) throws Exception{
		List<Detail3> detail3s = detail3Service.getDetail3ListByDetail2(detail2);
		System.out.println(detail3s);
		return detail3s;
	}
	
	@PostMapping("/categoryForNew")
	public String categoryPost(@RequestParam("categoryId") Integer categoryId,
								@RequestParam("source") String source,
							    Model model
							    ) throws Exception {
			model.addAttribute("title", "商品登録");
			Item item = new Item();
			item.setCategory(categoryId);
		    model.addAttribute("item", item);
		    model.addAttribute("source",source);
		    return "categories/saveWithCategory";
	}
	
	@PostMapping("/saveWithCategory")
	public String saveWithCategoryPost(@Valid Item item,
									    Errors errors,
									    RedirectAttributes rd,
									    HttpSession session,
									    Model model
							    		) throws Exception {
		if (errors.hasErrors()) {
			model.addAttribute("title", "商品登録");
			model.addAttribute("source","new");
			return "categories/saveWithCategory";
		}
		
		item.setCreatedBy((String) session.getAttribute("loginId"));
		itemService.addItem(item);
		
		Image image = new Image();
		image.setItemId(item.getId());
		imageService.addImage(image);
		
		rd.addFlashAttribute("statusMessage", "商品を追加しました。");
		return "redirect:/items";
	}
	
	@GetMapping("/editWithCategory/{id}")
	public String categoryGet(@RequestParam("categoryId") Integer categoryId,
								@RequestParam("source") String source,
								@PathVariable Integer id,
							    Model model
							    ) throws Exception {
		Item item = itemService.getItemById(id);
		item.setCategory(categoryId);
		model.addAttribute("title", "商品情報の更新");
		model.addAttribute("item", item);
		model.addAttribute("source",source);
		return "categories/editWithCategory";
	}
	
	@PostMapping("/editWithCategory/{id}")
	public String editWithCategoryPost(@PathVariable Integer id,
										@RequestParam("source") String source,
										@Valid Item item,
										Errors errors,
										RedirectAttributes rd,
										HttpSession session,
										Model model) throws Exception {
		
		if (errors.hasErrors()) {
			model.addAttribute("title", "商品情報の更新");
			model.addAttribute("source",source);
			model.addAttribute("item", item);
			return "categories/editWithCategory";
		}
		
		item.setCreatedBy((String) session.getAttribute("loginId"));
		itemService.editItem(item);
		rd.addFlashAttribute("statusMessage", "商品を更新しました。");
		return "redirect:/items";
	}
	
	
	
	
	
	
	
	
}

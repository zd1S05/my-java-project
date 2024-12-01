package com.example.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.app.domain.User;
import com.example.app.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userservice;
	
	
	@GetMapping
	public String showHome(Model model) {
		model.addAttribute("user", new User());
		return "home";
	}
	
	@PostMapping
	public String login(@Valid User user,
						 Errors errors,
						 HttpSession session
						 ) throws Exception{
		if(errors.hasErrors()) {
			return "home";
		}
		
		if(!userservice.isCorrectIdAndPassword(user.getLoginId(), user.getLoginPass())) {
			errors.rejectValue("loginId", "error.incorrect_id_password");
			return "home";
		}
		
		session.setAttribute("loginId", user.getLoginId());
		
		System.out.println("Login successful. Session loginId: " + session.getAttribute("loginId"));
		
		return "redirect:/items";
		
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
}

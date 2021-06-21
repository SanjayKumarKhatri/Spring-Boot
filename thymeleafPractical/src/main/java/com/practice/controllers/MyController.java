package com.practice.controllers;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {

	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public String about(Model model) {
		model.addAttribute("name", "Manoj Kumar");
		model.addAttribute("currentDate", new Date().toLocaleString());
		System.out.println("Inside about Controller...");
		return "about";
	}
	
	//iteration handling
	
	@GetMapping("/example-loop")
	public String iterateHamndler(Model model) {	
		//Create  a list
		List<String> names = List.of("Sanjay","Manoj","Aman","Aakash","Saqib","Bilal","Uzair");
		model.addAttribute("names", names);
		return "iterate";
	}
	
	//Handler for conditional statments
	
	@GetMapping("/condition")
	public String conditionHandler(Model model) {
		System.out.println("Inside Condition handler...");	
		model.addAttribute("isActive", false);
		model.addAttribute("gender", "F");
		List<Integer> myList = List.of(12,34,98,78,98);
		model.addAttribute("list", myList);
		return "condition";
	}
	
	@GetMapping("/service")
	public String serviceHandler(Model model) {
		model.addAttribute("title", "I like to eat somosa");
		model.addAttribute("subtitle", new Date().toString());	
		return "service";
	}
	
	@GetMapping("/aboutnew")
	public String aboutNew() {
		return "aboutnew";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
}

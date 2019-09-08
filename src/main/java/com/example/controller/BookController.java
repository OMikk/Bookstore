package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import com.example.demo.BookRepository;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@ResponseBody
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping("/index")
	public String index() {
	return "This is the main page";
	}
	
	@RequestMapping(value = {"/", "/booklist"})
	public String bookList(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
}

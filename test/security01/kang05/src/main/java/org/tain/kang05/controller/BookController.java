package org.tain.kang05.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.tain.kang05.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;
	
	@GetMapping("/books")
	public String getBookList(Model model) {
		model.addAttribute("bookList", this.bookService.getBookList());
		return "book";
	}
}

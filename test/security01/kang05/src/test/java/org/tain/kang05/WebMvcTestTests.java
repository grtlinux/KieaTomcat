package org.tain.kang05;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import static org.hamcrest.Matchers.contains;

import java.time.LocalDateTime;
import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.tain.kang05.controller.BookController;
import org.tain.kang05.domain.Book;
import org.tain.kang05.service.BookService;

@RunWith(SpringRunner.class)
@WebMvcTest(BookController.class)
public class WebMvcTestTests {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private BookService bookService;
	
	@Test
	public void test01() throws Exception {
		Book book = new Book("Spring Boot Book", LocalDateTime.now());
		given(bookService.getBookList()).willReturn(Collections.singletonList(book));
		
		mvc.perform(get("/books"))
			.andExpect(status().isOk())
			.andExpect(view().name("book"))
			.andExpect(model().attributeExists("bookList"))
			.andExpect(model().attribute("bookList", contains(book)));
	}

}

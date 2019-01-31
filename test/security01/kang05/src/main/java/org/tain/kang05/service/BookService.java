package org.tain.kang05.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.tain.kang05.domain.Book;

@Service
public interface BookService {

	public List<Book> getBookList();
}

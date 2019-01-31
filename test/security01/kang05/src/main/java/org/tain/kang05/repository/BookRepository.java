package org.tain.kang05.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.tain.kang05.domain.Book;

public interface BookRepository extends JpaRepository<Book, Integer>{

}

package com.SpringBurak.spring5webapp.repositories;

import com.SpringBurak.spring5webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}

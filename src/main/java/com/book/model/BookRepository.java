package com.book.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.book.entity.Book;

@Component
public interface BookRepository extends CrudRepository<Book,Integer>
{

}

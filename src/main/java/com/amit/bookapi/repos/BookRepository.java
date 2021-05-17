package com.amit.bookapi.repos;

import org.springframework.data.repository.CrudRepository;

import com.amit.bookapi.entity.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {

}

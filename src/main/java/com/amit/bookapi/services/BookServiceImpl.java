package com.amit.bookapi.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.amit.bookapi.entity.Response;
import com.amit.bookapi.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.amit.bookapi.entity.Book;
import com.amit.bookapi.repos.BookRepository;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BookRepository bookRepository;
	
	public Response<List<Book>> getAllBooks() {
		Iterable<Book> books = bookRepository.findAll();
		List<Book> result = new ArrayList<>();
		for(Book book : books) {
			result.add(book);
		}
		if(result.isEmpty()){
			// throw the exception
			System.out.println("here");
			throw new BookNotFoundException("Currently no book is present ");
		}
      return new Response<>(result,HttpStatus.OK.value());
	}

	public Response<Book> getBook(int bookId) {

			Optional<Book> theBook = bookRepository.findById(bookId);
			 if(!theBook.isPresent()){
			 	throw new BookNotFoundException("Book id not found - " + bookId);

			 }
			 return new Response<>(theBook.get(),HttpStatus.OK.value());
	}

	public Response<Book> addBook(Book theBook) {

		bookRepository.save(theBook);
		return new Response<>(theBook,HttpStatus.CREATED.value());
	}

	public Response<Book> deleteBook(int bookId) {
		Optional<Book> theBook = bookRepository.findById(bookId);
		if(!theBook.isPresent()){
			throw new BookNotFoundException("Book with id - " + bookId + " not found");
		}
		bookRepository.delete(theBook.get());
		return new Response<>(theBook.get(), HttpStatus.OK.value());
	}

	public Response<Book> updateBook(Book theBook) {

		Optional<Book> book = bookRepository.findById(theBook.getId());
		if(!book.isPresent()){
			throw new BookNotFoundException("Book with id - " + theBook.getId() + " not found");
		}
		book.get().setAuthor(theBook.getAuthor());
		book.get().setTitle(theBook.getTitle());
		bookRepository.save(book.get());
		return new Response<>(book.get(), HttpStatus.OK.value());

	}

}

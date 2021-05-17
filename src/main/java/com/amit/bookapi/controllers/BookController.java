package com.amit.bookapi.controllers;

import java.util.List;

import javax.validation.Valid;


import com.amit.bookapi.entity.Response;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.amit.bookapi.entity.Book;
import com.amit.bookapi.services.BookServiceImpl;

@RestController
@Api(tags = "Book CRUD API")
@RequestMapping("/api/v1/book")
public class BookController {

    @Autowired
    private BookServiceImpl bookService;

    /**
     * @return List of Books
     */
    @GetMapping
    @ApiOperation(value = "Find all books", notes = "Just hit this url to get list of books in the data base")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved the list of books"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 403, message = "You are not authenticated to perform this action on the resource")})
    public Response<List<Book>> getBooks() {
        return bookService.getAllBooks();
    }

    /**
     * @param bookId is the id of book to be retrieved
     * @return a book
     */
    @GetMapping("/{bookId}")
    @ApiOperation(value = "Get a book object", produces = "application/json")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Successfully retrieved the book details"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found"),
            @ApiResponse(code = 403, message = "You are not authenticated to perform this action on the resource")})
    public Response<Book> getBook(
            @ApiParam(value = "Book Id from which user object will delete from database table", required = true)
            @PathVariable("bookId") int bookId) {
        return bookService.getBook(bookId);
    }

    /**
     * @param theBook is the details of book to insert
     * @return the inserted book
     */
    @ApiOperation(value = "Add a book ", produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 201, message = "Book created successfully"),
            @ApiResponse(code = 403, message = "You are not authenticated to perform this action on the resource") })
    @PostMapping
    public Response<Book> addBook(
            @RequestBody @Valid Book theBook) {
        return bookService.addBook(theBook);
    }

    /**
     * @param bookId is the book id to delete
     * @return a book that got deleted
     */
    @ApiOperation(value = "Delete a book by id", produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "User deleted successfully"),
            @ApiResponse(code = 403, message = "You are not authenticated to perform this action on the resource") })    @DeleteMapping("/{bookId}")
    public Response<Book> deleteBook(
            @ApiParam(value = "Book Id from which user object will delete from database table", required = true)
            @PathVariable("bookId") int bookId) {
        return bookService.deleteBook(bookId);
    }

    /**
     * @param theBook is the detail of the book that is to be updated
     * @return book after updating
     */
    @ApiOperation(value = "Update a currently present book in database", produces = "application/json")
    @ApiResponses(value = { @ApiResponse(code = 200, message = "Book deleted successfully"),
            @ApiResponse(code = 403, message = "You are not authenticated to perform this action on the resource"),
            @ApiResponse(code = 404, message = "The resource you were trying to delete is not found") })
    @PutMapping
    public Response<Book> updateBook(
            @Valid @RequestBody Book theBook) {
        return bookService.updateBook(theBook);
    }
    // separate spring boot for auth
    // Response object of generic type, some problem
    // spring cloud gateway or zuul

}
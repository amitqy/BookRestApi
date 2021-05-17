package com.amit.bookapi.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "A book object")
@Entity
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@ApiModelProperty(notes = "The unique id of the book")
	private int id;
	@ApiModelProperty(notes = "The title of the book")
	@NotNull(message = "Title is a compulsory field")
	@Size(max = 100, message = "size of author name cannot go beyond 100 characters")
	private String title;
	@ApiModelProperty(notes = "The author of the book")
	@NotNull(message = "Author is a compulsory field")
	@Size(max = 50, message = "size of author name cannot go beyond 50 characters")
	private String author;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Book() {
		super();
	}

	public Book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author = author;
	}
	public Book(String title, String author) {
		this.title = title;
		this.author = author;
	}

}

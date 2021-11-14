package com.qa.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.project.domain.Library;
import com.qa.project.service.LibraryService;

@RestController
@RequestMapping("/library")
public class LibraryController {
	
	private LibraryService service;
	
	@Autowired
	public LibraryController(LibraryService service) {
		super();
		this.service = service;
	}
	
	//Post Method - Create a book
	@PostMapping("/addbook")
	public ResponseEntity<Library> createBook(@RequestBody Library book)
	{
		Library responseBody = this.service.createBook(book);
		return new ResponseEntity<Library>(responseBody, HttpStatus.CREATED);
	}
	
	//Get Method - retrieve a book from the library
	@GetMapping("/search/{id}")
	public Library getBookById (@PathVariable(value="id") Integer id) {
		return this.service.getBook(id);
	}
	
	@GetMapping("/search/{title}")
	public Library getBookByTitle(@PathVariable(value="title")String title) {
		return this.getBookByTitle(title);
		
	}
	
	@GetMapping("/search/{author}")
	public Library getBookByAuthor(@PathVariable(value="author")String author) {
		return this.getBookByAuthor(author);
	}
	
	@GetMapping("/search/{genre}")
	public Library getBookByGenre(@PathVariable(value="genre")String genre) {
		return this.getBookByGenre(genre);
	}
	
	//Get Method - Return all books
	@GetMapping("/library")
	public ResponseEntity<List<Library>> getAllBooks(){
		return ResponseEntity.ok(this.service.getBook());
	}
	
	//Put Method - update a book
	@PutMapping("/{id}")
	public ResponseEntity<Library> updateBook(@PathVariable(value="id")Integer id, @RequestBody Library bookDetails) {
		Library existing = this.service.updateBook(id, bookDetails);
		
		return new ResponseEntity<>(existing, HttpStatus.ACCEPTED);
	}
	
	//Delete Method - method to remove a book
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable(value="id")Integer id){
		boolean removed = this.service.deleteBook(id);
		if(removed) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		else {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

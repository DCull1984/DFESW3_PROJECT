package com.qa.project.service;

import java.util.List;

import domain.Library;

public interface LibraryService {

	Library createBook(Library newBook);
	
	List<Library> getBook();
	
	Library getBook(Integer id);
	
	Library updateBook(Integer id, Library updateBook);
	
	boolean deleteBook(Integer id);
}

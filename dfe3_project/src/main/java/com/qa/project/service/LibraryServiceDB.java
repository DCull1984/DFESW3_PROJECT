package com.qa.project.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;

import com.qa.project.domain.Library;
import com.qa.project.repository.LibraryRepository;

@Service
public class LibraryServiceDB implements LibraryService {

	private LibraryRepository repo;
	
	public LibraryServiceDB(LibraryRepository repo) {
		super();
		this.repo = repo;
	}
	
	@Override
	public Library createBook(Library newBook) {
		return this.repo.save(newBook);
	}

	@Override
	public List<Library> getBook() {
		return this.repo.findAll();
	}

	@Override
	public Library getBook(Integer id) {
		 return this.repo.findById(id).orElseThrow(()-> new
		 EntityNotFoundException("No book found with id: " + id));
	}

	@Override
	public Library updateBook(Integer id, Library updateBook) {
		Library existing = this.getBook(id);
		
		existing.setTitle(updateBook.getTitle());
		existing.setAuthor(updateBook.getAuthor());
		existing.setGenre(updateBook.getGenre());
		
		return this.repo.saveAndFlush(existing);
	}

	@Override
	public boolean deleteBook(Integer id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

}

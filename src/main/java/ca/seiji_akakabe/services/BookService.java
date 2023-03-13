package ca.seiji_akakabe.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ca.seiji_akakabe.models.Book;
import ca.seiji_akakabe.repositories.BookRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class BookService {
	private final BookRepository bookRepo;
	
	public Optional<Book> getBookById(Long id) {
		return bookRepo.findById(id);
	}
	
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
	public void saveBook(Book b) {
		bookRepo.save(b);
	}
	
	public void deleteBookById(Long id) {
		bookRepo.deleteById(id);
	}
}	

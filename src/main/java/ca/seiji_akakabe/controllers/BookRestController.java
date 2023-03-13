package ca.seiji_akakabe.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ca.seiji_akakabe.models.Book;
import ca.seiji_akakabe.services.BookService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookRestController {
	private final BookService bookService;
	
	@GetMapping("") 
	public ResponseEntity<List<Book>> getBooks() {
		return ResponseEntity.of(Optional.of(bookService.getAllBooks()));
	}
	
	@PostMapping("")
	public ResponseEntity<?> saveBook(@RequestBody Book book) {
		bookService.saveBook(book);
		return ResponseEntity.ok(null);
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<?> saveBook(@PathVariable Long bookId) {
		bookService.deleteBookById(bookId);
		return ResponseEntity.ok(null);
	}
}




































package ca.seiji_akakabe.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.client.RestTemplate;

import ca.seiji_akakabe.models.Book;
import ca.seiji_akakabe.services.BookService;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class ThymeleafController {
	private final String BOOK_API_URL="http://localhost:8080/api/books";
	private final BookService bookService;

	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/books")
	public String bookList(Model model, RestTemplate restTemplate) {
		ResponseEntity<? extends ArrayList> books = restTemplate.getForEntity(BOOK_API_URL,  new ArrayList<Book>().getClass());
		model.addAttribute("bookList", books.getBody());
		injectEmptyBookForm(model);
		return "books/books";
	}
	
	@PostMapping(path="/books")
	public String createBook(Model model, RestTemplate restTemplate, @ModelAttribute Book book) {
		restTemplate.postForLocation(BOOK_API_URL, book);
		return "redirect:/books";
	}
	
	@GetMapping("/books/update/{bookId}")
	public String updateBookForm(Model model, @PathVariable(name="bookId") Long id) {
		Optional<Book> op_bookEdit = bookService.getBookById(id);
		if (op_bookEdit.isPresent()) {
			model.addAttribute("editableBook", op_bookEdit.get());
		}
		
		return "books/bookEdit";
	}
	
	@GetMapping("/books/delete/{bookId}")
	public String deleteBookById(Model model, RestTemplate restTemplate, @PathVariable Long bookId) {
		restTemplate.delete(BOOK_API_URL + "/" + bookId);
		return "redirect:/books";
	}
	
	@PutMapping("/books")
	public String updateBook(Model model, RestTemplate restTemplate, @ModelAttribute Book book) {
		restTemplate.postForLocation(BOOK_API_URL, book);
		return "redirect:/books";
	}
	
	private void injectEmptyBookForm(Model model) {
		model.addAttribute("emptyBookFormObject", new Book());
	}
	
}

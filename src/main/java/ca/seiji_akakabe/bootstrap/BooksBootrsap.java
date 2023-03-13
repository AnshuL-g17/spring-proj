package ca.seiji_akakabe.bootstrap;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import ca.seiji_akakabe.models.Book;
import ca.seiji_akakabe.services.BookService;
import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class BooksBootrsap implements CommandLineRunner {
	private final BookService bookService;
	@Override
	public void run(String... args) throws Exception {
		List<Book> books = List.of(
				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now())
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the rings", LocalDate.now()),
//				new Book("JK. Rowling", "The Lord of the ring", LocalDate.now())
				);
		
		books.forEach((b) -> bookService.saveBook(b));

				
	}

}

package ca.seiji_akakabe.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.seiji_akakabe.models.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
}	

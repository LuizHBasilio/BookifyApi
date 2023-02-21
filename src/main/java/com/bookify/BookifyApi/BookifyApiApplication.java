package main.java.com.bookify.BookifyApi;

import java.util.List;

import main.java.com.bookify.BookifyApi.model.Book;
import main.java.com.bookify.BookifyApi.service.BookService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/bookify/api/v1/books")
public class BookifyApiApplication {
	
	static BookService bookService = new BookService();

	public static void main(String[] args) {
		SpringApplication.run(BookifyApiApplication.class, args);
	}
	
	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable String bookId) {
		Book book = bookService.getBookById(bookId);		
		if (book == null) {
			return ResponseEntity.notFound().build();
		} else {
			return ResponseEntity.ok(book);
		}
	}
	
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		boolean keyExists = bookService.keyAlreadyExists(book.getId());
		if (keyExists) {
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok(bookService.addBook(book));		
	}
	
	@PutMapping("/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book book) {
	    boolean keyExists = bookService.keyAlreadyExists(bookId);
	    if (!keyExists) {
	        return ResponseEntity.notFound().build();
	    }
	    book.setId(bookId);
	    return ResponseEntity.ok(bookService.updateBook(book));
	}
	
}

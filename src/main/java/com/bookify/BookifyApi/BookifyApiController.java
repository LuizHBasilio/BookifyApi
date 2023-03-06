package main.java.com.bookify.BookifyApi;

import java.util.List;

import main.java.com.bookify.BookifyApi.model.Book;
import main.java.com.bookify.BookifyApi.service.BookService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The BookifyApiApplication class provides a RESTful API for managing a
 * collection of books. It defines endpoints for retrieving all books,
 * retrieving a specific book by ID, adding a new book, updating an existing
 * book, and deleting a book.
 */
@SpringBootApplication
@RestController
@RequestMapping("/bookify/api/v1/books")
public class BookifyApiController {

	/**
	 * The BookService instance used to perform CRUD operations on the Book objects.
	 */
	static BookService bookService = new BookService();

	public static void main(String[] args) {
		SpringApplication.run(BookifyApiController.class, args);
	}

	/**
	 * Retrieves all books.
	 * 
	 * @return A List of Book objects representing all books in the collection.
	 */
	@GetMapping
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	/**
	 * Retrieves a specific book by ID.
	 * 
	 * @param bookId The ID of the book to retrieve.
	 * @return A ResponseEntity with a Book object if the book is found, or a 404
	 *         status if it is not.
	 */
	@GetMapping("/{bookId}")
	public ResponseEntity<Book> getBook(@PathVariable Long bookId) {
		try {
			Book book = bookService.getBookById(bookId);
			return ResponseEntity.ok(book);
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * Adds a new book.
	 * 
	 * @param book The Book object representing the book to add.
	 * @return A ResponseEntity containing the added Book object if the ID is
	 *         unique, or a 400 status if it already exists.
	 */
	@PostMapping
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		try {
			Book addBook = bookService.addBook(book);
			return ResponseEntity.ok(bookService.addBook(addBook));
		} catch (RuntimeException ex) {
			return ResponseEntity.badRequest().build();
		}
	}

	/**
	 * Updates an existing book.
	 * 
	 * @param bookId The unique identifier of the book to update.
	 * @param book   The Book object representing the updated book.
	 * @return A ResponseEntity containing the updated Book object if it exists, or
	 *         a 404 status if it does not.
	 */
	@PutMapping("/{bookId}")
	public ResponseEntity<Book> updateBook(@PathVariable Long bookId, @RequestBody Book book) {
		try {
			book.setId(bookId);
			Book updateBook = bookService.addBook(book);
			return ResponseEntity.ok(bookService.updateBook(updateBook));
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}

	/**
	 * Deletes a book.
	 * 
	 * @param bookId The unique identifier of the book to delete.
	 * @return A ResponseEntity with no content if the book is deleted, or a 404
	 *         status if it does not exist.
	 */
	@DeleteMapping("/{bookId}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long bookId) {
		try {
			bookService.deleteBook(bookId);
			return ResponseEntity.noContent().build();
		} catch (RuntimeException ex) {
			return ResponseEntity.notFound().build();
		}
	}
}

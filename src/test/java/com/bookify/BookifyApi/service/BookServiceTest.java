package test.java.com.bookify.BookifyApi.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import main.java.com.bookify.BookifyApi.model.Book;
import main.java.com.bookify.BookifyApi.service.BookService;

public class BookServiceTest {

	private BookService bookService;

	@BeforeEach
	public void setUp() {
		bookService = new BookService();
	}

	@Test
	public void testGetBookByIdNotFound() {
		ResponseEntity<?> response = bookService.getBookById(4L);
		assertEquals(404, response.getStatusCodeValue());
		assertEquals("Book with id 4 was not found", response.getBody());
	}

	@Test
	public void testKeyAlreadyExists() {
		Assertions.assertTrue(bookService.keyAlreadyExists(1L), "Key should already exist");
	}

	@Test
	public void testAddBook() {
		Book newBook = new Book(0L, "New Book", "Author", "ISBN123", "Publisher", "Genre");
		ResponseEntity<?> response = bookService.addBook(newBook);
		assertEquals(200, response.getStatusCodeValue());
		Book addedBook = (Book) response.getBody();
		assertNotNull(addedBook.getId());
	}

	@Test
	public void testAddBookWithExistingId() {
		Book existingBook = new Book(1L, "New Book", "Author", "ISBN123", "Publisher", "Genre");
		ResponseEntity<?> response = bookService.addBook(existingBook);
		assertEquals(400, response.getStatusCodeValue());
		assertEquals("Book with this id already exists", response.getBody());
	}

	@Test
	public void testUpdateBook() {
		Book bookToUpdate = new Book(1L, "Updated Title", "Updated Author", "Updated ISBN", "Updated Publisher",
				"Updated Genre");
		ResponseEntity<?> response = bookService.updateBook(bookToUpdate);
		assertEquals(200, response.getStatusCodeValue());
		Book updatedBook = (Book) response.getBody();
		assertEquals("Updated Title", updatedBook.getTitle());
		assertEquals("Updated Author", updatedBook.getAuthor());
	}

	@Test
	public void testDeleteBook() {
		ResponseEntity<?> response = bookService.deleteBook(1L);
		assertEquals(200, response.getStatusCodeValue());
		assertEquals("Book deleted", response.getBody());
	}

}

package test.java.com.bookify.BookifyApi.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        Assertions.assertThrows(RuntimeException.class, () -> bookService.getBookById(4L),
                "Expected RuntimeException when book is not found");
    }

    @Test
    public void testKeyAlreadyExists() {
        Assertions.assertTrue(bookService.keyAlreadyExists(1L), "Key should already exist");
    }

    @Test
    public void testAddBook() {
        Book newBook = new Book(0, "To Kill a Mockingbird", "Harper Lee", "9780446310789", "Grand Central Publishing",
                "Fiction");
        Book addedBook = bookService.addBook(newBook);
        Assertions.assertNotNull(addedBook, "Added book should not be null");
        Assertions.assertEquals("To Kill a Mockingbird", addedBook.getTitle(), "To Kill a Mockingbird");
    }

    @Test
    public void testAddBookWithExistingId() {
        Book existingBook = bookService.getBookById(1L);
        Assertions.assertThrows(RuntimeException.class, () -> bookService.addBook(existingBook),
                "Expected RuntimeException when adding book with existing ID");
    }

    @Test
    public void testUpdateBook() {
        Book bookToUpdate = bookService.getBookById(1L);
        bookToUpdate.setTitle("New Title");
        Book updatedBook = bookService.updateBook(bookToUpdate);
        Assertions.assertNotNull(updatedBook, "Updated book should not be null");
        Assertions.assertEquals("New Title", bookService.getBookById(1L).getTitle(),
                "Book title should be 'New Title'");
    }

    @Test
    public void testUpdateBookNotFound() {
        Book nonExistingBook = new Book(122L, "The Catcher in the Rye", "J.D. Salinger", "9780316769174", "Back Bay Books",
                "Fiction");
        Assertions.assertThrows(RuntimeException.class, () -> bookService.updateBook(nonExistingBook),
                "Expected RuntimeException when updating non-existing book");
    }

}

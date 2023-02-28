package main.java.com.bookify.BookifyApi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.bookify.BookifyApi.model.Book;

/**
 * This class represents a service layer for the Bookify API application. It
 * manages the CRUD (Create, Read, Update, Delete) operations for books.
 */
public class BookService {

	private static Map<Long, Book> books = new HashMap<>();
	private static long nextId = 1;

	/**
	 * Constructs a new BookService object and generates sample data.
	 */
	public BookService() {
		generateData();
	}

	private void generateData() {
		Book book1 = new Book(getNextId(), "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Scribner",
				"Fiction");
		Book book2 = new Book(getNextId(), "1984", "George Orwell", "9780451524935", "Signet Classics",
				"Science Fiction/Dystopian");
		Book book3 = new Book(getNextId(), "The Da Vinci Code", "Dan Brown", "9780385504201", "Doubleday", "Mystery");
		books.put(Long.valueOf(book1.getId()), book1);
		books.put(Long.valueOf(book2.getId()), book2);
		books.put(Long.valueOf(book3.getId()), book3);
	}

	private static Long getNextId() {
		return nextId++;
	}

	/**
	 * Returns a list of all the books in the HashMap.
	 * 
	 * @return A List of all the books in the HashMap.
	 */
	public List<Book> getAllBooks() {
		return new ArrayList<>(books.values());
	}

	/**
	 * Returns a book with the given ID.
	 * 
	 * @param bookId The ID of the book to return.
	 * @return The Book object with the specified ID or null if it does not exist.
	 */
	public Book getBookById(Long bookId) {
		return books.get(bookId);
	}

	/**
	 * Checks if a book with the given ID already exists in the HashMap.
	 * 
	 * @param id The ID of the book to check.
	 * @return True if the book exists, false otherwise.
	 */
	public boolean keyAlreadyExists(long id) {
		return books.containsKey(id);
	}

	/**
	 * Adds a book to the HashMap.
	 * 
	 * @param book The book to add.
	 * @return The Book object that was added to the HashMap.
	 */
	public Book addBook(Book book) {
		if (book.getId() == 0) {
			book.setId(getNextId());
		}
		books.put(getNextId(), book);
		return book;
	}

	/**
	 * Updates an existing book in the HashMap.
	 * 
	 * @param book The Book object to update.
	 * @return The Book object that was updated, or null if the book does not exist.
	 */
	public Book updateBook(Book book) {
		if (book == null || !books.containsKey(book.getId())) {
			return null;
		}
		books.put(book.getId(), book);
		return book;
	}

	/**
	 * Removes a book from the HashMap.
	 * 
	 * @param bookId The ID of the book to remove.
	 */
	public void deleteBook(Long bookId) {
		books.remove(bookId);
	}
}

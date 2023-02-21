package main.java.com.bookify.BookifyApi.service;

import static org.mockito.ArgumentMatchers.notNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.bookify.BookifyApi.model.Book;

public class BookService {
	
	private static Map<Long, Book> books = new HashMap<>();
	private static long nextId = 1;
	
	public BookService() {
		generateData();
	}

	private void generateData() {
		Book book1 = new Book(getNextId(), "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Scribner", "Fiction");
		Book book2 = new Book(getNextId(), "1984", "George Orwell", "9780451524935", "Signet Classics", "Science Fiction/Dystopian");
		Book book3 = new Book(getNextId(), "The Da Vinci Code", "Dan Brown", "9780385504201", "Doubleday", "Mystery");
		books.put(Long.valueOf(book1.getId()), book1);
		books.put(Long.valueOf(book2.getId()), book2);
		books.put(Long.valueOf(book3.getId()), book3);
	}

	private static Long getNextId() {
		return nextId++;
	}

	public List<Book> getAllBooks() {
		return new ArrayList<>(books.values());
	}

	public Book getBookById(String bookId) {		
		return books.get(Long.valueOf(bookId));
	}

	public boolean keyAlreadyExists(long id) {
		return books.containsKey(id);
	}

	public Book addBook(Book book) {
		if(book.getId() == 0) {
			book.setId(getNextId());
		}
		books.put(getNextId(), book);
		return book;
	}

	public Book updateBook(Book book) {
	    if (book == null || !books.containsKey(book.getId())) {
	        return null;
	    }
	    books.put(book.getId(), book);
	    return book;
	}
}

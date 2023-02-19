package main.java.com.bookify.BookifyApi.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import main.java.com.bookify.BookifyApi.model.Book;

public class BookService {
	
	private static Map<Long, Book> books = new HashMap<>();
	private static long nextId = 0;
	
	public BookService() {
		generateData();
	}

	private void generateData() {
		Book book1 = new Book(getNextId(), "The Great Gatsby", "F. Scott Fitzgerald", "9780743273565", "Scribner", "Fiction");
		Book book2 = new Book(getNextId(), "1984", "George Orwell", "9780451524935", "Signet Classics", "Science Fiction/Dystopian");
		books.put(Long.valueOf(book1.getId()), book1);
		books.put(Long.valueOf(book2.getId()), book2);
	}

	private static Long getNextId() {
		return nextId++;
	}

	public List<Book> getAllBooks() {
		return new ArrayList<>(books.values());
	}

}

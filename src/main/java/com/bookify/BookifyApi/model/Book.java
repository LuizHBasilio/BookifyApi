package main.java.com.bookify.BookifyApi.model;

public class Book {

	private long id;
	private String title;
	private String author;
	private String ISBN;
	private String publisher;
	private String genre;

	public Book() {
	}

	public Book(long pId, String pTitle, String pAuthor, String pISBN, String pPublisher, String pGenre) {
		id = pId;
		title = pTitle;
		author = pAuthor;
		ISBN = pISBN;
		publisher = pPublisher;
		genre = pGenre;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

}

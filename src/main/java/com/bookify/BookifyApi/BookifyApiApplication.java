package main.java.com.bookify.BookifyApi;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import main.java.com.bookify.BookifyApi.model.Book;
import main.java.com.bookify.BookifyApi.service.BookService;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BookifyApiApplication {
	
	static BookService bookService = new BookService();

	public static void main(String[] args) {
		SpringApplication.run(BookifyApiApplication.class, args);
	}
	
	private static final Logger LOG = Logger.getLogger("SystemLog");
	
	@GetMapping("/bookify/api/v1/books")
    public List<Book> handleMockGetRequest(HttpServletRequest request)
    {
       return bookService.getAllBooks();
    }

}

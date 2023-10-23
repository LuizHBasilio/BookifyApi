# Bookify API

The Bookify API provides a RESTful API for managing a collection of books. It allows you to retrieve all books, retrieve a specific book by ID, add a new book, update an existing book, and delete a book.

## Prerequisites

Java 11 or higher

Maven

You can access the API at http://localhost:8080/bookify/api/v1/books

## API Endpoints
The Bookify API defines the following endpoints:

### GET /bookify/api/v1/books
Retrieves all books.

Response
Status Code: 200 OK

Content-Type: application/json

Response Body:

```json
[  

	{   "id": 1,    
	    "title": "The Great Gatsby",    
	    "author": "F. Scott Fitzgerald",    
	    "publishedDate": "1925-04-10",    
            "genre": "Novel"  
	},
	  
	{  "id": 2,    
	   "title": "To Kill a Mockingbird",    
	   "author": "Harper Lee",    
	   "publishedDate": "1960-07-11",    
	   "genre": "Novel"  
	},
	  
]
```

### GET /bookify/api/v1/books/{bookId}
Retrieves a specific book by ID.

Request Parameters
bookId - The ID of the book to retrieve.

Response
Status Code: 200 OK

Content-Type: application/json

Response Body:

```json
{
  "id": 1,
  "title": "The Great Gatsby",
  "author": "F. Scott Fitzgerald",
  "publishedDate": "1925-04-10",
  "genre": "Novel"
}
```

Status Code: 404 Not Found

Content-Type: application/json

Response Body:

```json
{
  "error": "Book not found"
}
```

### POST /bookify/api/v1/books
Adds a new book.

Request Body
Content-Type: application/json

Request Body:

```json
{
  "title": "The Catcher in the Rye",
  "author": "J. D. Salinger",
  "publishedDate": "1951-07-16",
  "genre": "Novel"
}
```

Response
Status Code: 201 Created

Content-Type: application/json

Response Body:

```json
{
  "id": 3,
  "title": "The Catcher in the Rye",
  "author": "J. D. Salinger",
  "publishedDate": "1951-07-16",
  "genre": "Novel"
}
```

Status Code: 400 Bad Request

Content-Type: application/json

Response Body:

```json
{
  "error": "Book with ID 3 already exists"
}
```

### PUT /bookify/api/v1/books/{bookId}
Updates an existing book.

Request Body
Content-Type: application/json

Request Body:

```json
{
  "title": "The Catcher in the Rye",
  "author": "J. D. Salinger",
  "publishedDate": "1951-07-16",
  "genre": "Novel"
}
```

Response
Status Code: 200 OK

Content-Type: application/json

Response Body:

```json
{
  "id": 3,
  "title": "The Catcher in the Rye",
  "author": "J. D. Salinger",
  "publishedDate": "1951-07-16",
  "genre": "Novel"
}
```

Status Code: 404 Not Found

Content-Type: application/json

Response Body:

```json
{
  "error": "Book with id 3 not exists"
}
```

### DELETE /bookify/api/v1/books/{bookId}
Deletes a book.

Request Body
Content-Type: application/json

Response
Status Code: 204 No Content

Content-Type: application/json

Status Code: 404 Not Found

Content-Type: application/json

Response Body:

```json
{
  "error": "Book with id 3 not exists"
}
```

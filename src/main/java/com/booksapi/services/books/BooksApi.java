package com.booksapi.services.books;

import com.booksapi.models.Book;
import com.booksapi.services.utils.ApiDefaultMethod;
import io.restassured.response.Response;

import java.util.List;

import static com.booksapi.services.utils.Uri.BOOKS;

public class BooksApi {

    public Response getAllBooks() {
        return ApiDefaultMethod.get(BOOKS);
    }
    public List<Book> getAllBooksAsList() {
        return ApiDefaultMethod.getAsList(BOOKS, Book.class);
    }


    public Response getBookById(int id) {
        return ApiDefaultMethod.getById(BOOKS, id);
    }

    public Response createBook(Book book) {
        return ApiDefaultMethod.post(BOOKS, book);
    }

    public Book createBookExtractClass(Book book) {
        return ApiDefaultMethod.postExtractedAsClass(BOOKS, book, Book.class);
    }

    public Response updateBook(Book book, int id) {
        return ApiDefaultMethod.put(BOOKS, book, id);
    }

    public Response deleteById(int id) {
        return ApiDefaultMethod.deleteById(BOOKS, id);
    }
}
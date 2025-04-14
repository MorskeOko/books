package com.booksapi.services.books;

import com.booksapi.models.BookDto;
import com.booksapi.services.utils.ApiDefaultMethod;
import io.restassured.response.Response;

import java.util.List;

import static com.booksapi.services.utils.Uri.BOOKS;

public class BooksApi {

    public Response getAllBooks() {
        return ApiDefaultMethod.get(BOOKS);
    }
    public List<BookDto> getAllBooksAsList() {
        return ApiDefaultMethod.getAsList(BOOKS, BookDto.class);
    }


    public Response getBookById(int id) {
        return ApiDefaultMethod.getById(BOOKS, id);
    }

    public Response createBook(BookDto book) {
        return ApiDefaultMethod.post(BOOKS, book);
    }

    public BookDto createBookExtractClass(BookDto book) {
        return ApiDefaultMethod.postExtractedAsClass(BOOKS, book, BookDto.class);
    }

    public Response updateBook(BookDto book, int id) {
        return ApiDefaultMethod.put(BOOKS, book, id);
    }

    public Response deleteById(int id) {
        return ApiDefaultMethod.deleteById(BOOKS, id);
    }
}
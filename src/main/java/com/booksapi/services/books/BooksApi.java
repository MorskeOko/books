package com.booksapi.services.books;

import com.booksapi.models.Book;
import com.booksapi.services.utils.ApiDefaultMethod;
import io.restassured.response.Response;

import static com.booksapi.services.utils.Uri.BOOKS;

public class BooksApi {

    public Response getAllBooks() {
        return ApiDefaultMethod.get(BOOKS);
    }

    public Response getBookById(int id) {
        return ApiDefaultMethod.getById(BOOKS, id);
    }

    public Response createBook(Book book) {
        return ApiDefaultMethod.post(BOOKS, book);
    }

    public Response updateBook(Book book, int id) {
        return ApiDefaultMethod.put(BOOKS, book, id);
    }

    public Response delete(int id) {
        return ApiDefaultMethod.deleteById(BOOKS, id);
    }
}
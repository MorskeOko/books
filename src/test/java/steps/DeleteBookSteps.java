package steps;

import com.booksapi.models.BookDto;
import com.booksapi.services.Api;
import com.booksapi.utils.ContextManager;
import io.cucumber.java.en.And;

import java.util.List;


public class DeleteBookSteps {

    @And("the book is deleted with name {string}")
    public void deleteBookByName(String name) {
        List<BookDto> books = Api.booksApi.getAllBooksAsList();
        books.stream()
                .filter(book -> name.equals(book.getName()))
                .findFirst()
                .ifPresent(book -> {
                    Api.booksApi.deleteById(book.getId());
                    ContextManager.getContext().set("deletedBookId", book.getId());
                });
    }
}
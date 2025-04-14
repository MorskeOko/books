package steps;

import com.booksapi.models.BookDto;
import com.booksapi.services.Api;
import com.booksapi.utils.ContextManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;


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

    @And("the book is deleted with name {string} with ID saved")
    public void deleteBookByNameAndStoreName(String name) {
        Map<String, Integer> bookIds = ContextManager.getContext().get("createdBookIds", Map.class);
        Integer id = bookIds.get(name);
        if (id != null) {
            Api.booksApi.deleteById(id);
            bookIds.remove(name);
        }
    }

    @Given("the database has no books and existing books are deleted")
    public void deleteAllBooksIfExist() {
        List<BookDto> list = Api.booksApi.getAllBooksAsList();
        if (!list.isEmpty()) {
            for (BookDto book : list) {
                Api.booksApi.deleteById(book.getId());
            }
        }
    }
}
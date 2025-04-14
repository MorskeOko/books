package steps;

import com.booksapi.models.Book;
import com.booksapi.services.Api;
import com.booksapi.utils.ContextManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;


public class DeleteBookSteps {

    @And("the book is deleted with name {string}")
    public void deleteBookByName(String name) {
        List<Book> list = Api.booksApi.getAllBooksAsList();
        list.stream()
                .filter(book -> name.equals(book.getName()))
                .findFirst()
                .ifPresent(book -> Api.booksApi.deleteById(book.getId()));
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

    @Then("I send a DELETE request for book ID {int}")
    public void deleteBookById(int id) {
        Api.booksApi.deleteById((id));
    }

    @Given("the database has no books and existing books are deleted")
    public void deleteAllBooksIfExist() {
        List<Book> list = Api.booksApi.getAllBooksAsList();
        if (!list.isEmpty()) {
            for (Book book : list) {
                Api.booksApi.deleteById(book.getId());
            }
        }
    }
}
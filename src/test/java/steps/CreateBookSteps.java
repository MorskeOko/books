package steps;

import com.booksapi.models.Book;
import com.booksapi.services.Api;
import com.booksapi.utils.ContextManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateBookSteps {

    @When("the new book is created with name {string}")
    public void createBook(String name) {
        Book book = new Book(name, "Test autor", "Test publication", "Test category", 999, 10.10);
        Api.booksApi.createBook(book);
    }

    @When("the new book is created with name {string} with ID saved")
    public void createBookWithName(String name) {
        Book book = new Book(name, "Test autor", "Test publication", "Test category", 999, 10.10);
        Book created = Api.booksApi.createBookExtractClass(book);
        Map<String, Integer> bookIds = ContextManager.getContext().getOrDefault("createdBookIds", new HashMap<>());
        bookIds.put(name, created.getId());
        ContextManager.getContext().set("createdBookIds", bookIds);
    }

    @Then("the response should contain the book with name {string}")
    public void validateBookExistsByName(String name) {
        List<Book> list = Api.booksApi.getAllBooksAsList();
        boolean found = list.stream()
                .anyMatch(book -> name.equals(book.getName()));
        Assertions.assertThat(found).isTrue();
    }
}
package steps;

import com.booksapi.models.Book;
import com.booksapi.services.Api;
import com.booksapi.utils.ContextManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;

public class GetBookSteps {

    @Given("the database contains books")
    public void createBookIfNotExist() {
        if (Api.booksApi.getAllBooksAsList().isEmpty()) {
            Book book = new Book("Refactoring", "Martin Fowler", "Addison-Wesley", "Programming", 450, 40.00);
            Api.booksApi.createBook(book);
        }
    }

    @Then("the remaining book IDs should be {string} and {string}")
    public void validateRemainingBookIds(String name1, String name2) {
        Map<String, Integer> expectedIds = ContextManager.getContext().get("createdBookIds", Map.class);
        List<Integer> remainingIds = Api.booksApi.getAllBooksAsList().stream()
                .map(Book::getId)
                .toList();
        Assertions.assertThat(remainingIds)
                .containsExactlyInAnyOrder(expectedIds.get(name1), expectedIds.get(name2));
    }

    @When("I send a GET request to fetch all books")
    public void getAllBook() {
        Api.booksApi.getAllBooks();
    }

    @Then("the response should not contain the deleted book")
    public void validateBookDeleted() {
        // validate absence of the deleted book
    }
}
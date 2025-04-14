package steps;

import com.booksapi.models.BookDto;
import com.booksapi.services.Api;
import com.booksapi.utils.ContextManager;
import com.booksapi.utils.RandomData;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CreateBookSteps {

    @When("the new book is created with name {string} and ID stored")
    public void createBookNoRandomPart(String name) {
        BookDto book = new BookDto(name, "Test autor", "Test publication", "Test category", 999, 10.10);
        BookDto created = Api.booksApi.createBookExtractClass(book);
        Map<String, Integer> bookIds = ContextManager.getContext().getOrDefault("bookIds", new HashMap<>());
        bookIds.put(name, created.getId());
        ContextManager.getContext().set("bookIds", bookIds);
    }

    @When("the new book is created with hardcoded data and ID stored")
    public void createBookWithHardcodedData() {
        BookDto book = new BookDto(
                "Refactoring: Improving the Design of Existing Code",
                "Martin Fowler",
                "Addison-Wesley Professional",
                "Programming",
                448,
                35.50
        );
        BookDto created = Api.booksApi.createBookExtractClass(book);
        ContextManager.getContext().set("expectedBook", book);
        ContextManager.getContext().set("createdBook", created);
    }

    @When("the new book is created with name {string} and ID not stored")
    public void createBookNotStore(String name) {
        BookDto book = new BookDto(name, "Test autor", "Test publication", "Test category", 999, 10.10);
        Api.booksApi.createBookExtractClass(book);
    }

    @Then("the response should contain the book with name {string}")
    public void validateBookExistsByName(String name) {
        List<BookDto> list = Api.booksApi.getAllBooksAsList();
        boolean found = list.stream()
                .anyMatch(book -> name.equals(book.getName()));
        Assertions.assertThat(found).isTrue();
    }
}
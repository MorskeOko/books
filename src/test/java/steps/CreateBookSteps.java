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
    public void createBook(String name) {
        BookDto book = new BookDto(name + RandomData.randomString(3, true, false), "Test autor", "Test publication", "Test category", 999, 10.10);
        BookDto created = Api.booksApi.createBookExtractClass(book);
        Map<String, Integer> bookIds = ContextManager.getContext().getOrDefault("bookIds", new HashMap<>());
        bookIds.put(name, created.getId());
        ContextManager.getContext().set("bookIds", bookIds);
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
package steps;

import com.booksapi.models.Book;
import com.booksapi.services.Api;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;

import java.util.List;

public class CreateBookSteps {

    @When("the new book is created with name {string}")
    public void createBook(String name) {
        Book bookDto = new Book(name, "Test autor", "Test publication", "Test category", 999, 10.10);
        Api.booksApi.createBook(bookDto);
    }

    @Then("the response should contain the book with name {string}")
    public void validateBookExistsByName(String name) {
        List<Book> list = Api.booksApi.getAllBooksAsList();
        boolean found = list.stream()
                .anyMatch(book -> name.equals(book.getName()));
        Assertions.assertThat(found).isTrue();
    }
}
package steps;

import com.booksapi.models.Book;
import com.booksapi.services.Api;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetBookSteps {

    @Given("the database contains books")
    public void createBookIfNotExist() {
        if (Api.booksApi.getAllBooksAsList().isEmpty()) {
            Book bookDto = new Book("Refactoring", "Martin Fowler", "Addison-Wesley", "Programming", 450, 40.00);
            Api.booksApi.createBook(bookDto);
        }
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
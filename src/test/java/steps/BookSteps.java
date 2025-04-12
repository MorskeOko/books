package steps;

import com.booksapi.configurations.TestConfig;
import com.booksapi.models.Book;
import com.booksapi.services.Api;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class BookSteps {
    private Response response;
    private Object extractedResponse;

    public static final TestConfig testConfig = new TestConfig();

    @When("I send a GET request to fetch all book")
    public void getAllBooks() {
        response = given().auth().preemptive().basic(testConfig.getApiUser(), testConfig.getApiPass())
                .when().get(testConfig.getBaseUrl() + "/books");
    }

    @When("I send a GET request to fetch all books")
    public void getAllBook() {
        response = Api.booksApi.getAllBooks();
    }

    @When("I send a GET request for book ID {int}")
    public void getBookById(int id) {
        response = Api.booksApi.getBookById(id);
    }

    @When("I send a POST request to create a book")
    public void createBook() {
        Book bookDto = new Book("Refactoring", "Martin Fowler", "Addison-Wesley", "Programming", 450, 40.00);
        response = Api.booksApi.createBook(bookDto);
    }

    @When("I send a PUT request to update book ID {int}")
    public void updateBook(int id) {
        Book bookDto = new Book(id, "Refactoring Updated", "Martin Fowler", "Addison-Wesley", "Programming", 448, 35.50);
        response = Api.booksApi.updateBook(bookDto, id);
    }

    @When("I send a DELETE request for book ID {int}")
    public void deleteBook(int id) {
        response = Api.booksApi.delete(id);
    }

    @Then("the response status code should be {int}")
    public void validateStatusCode(int code) {
        response.then().statusCode(code);
    }


    @Then("I extract the response as a Book")
    public void extractBook() {
        extractedResponse = response.then().extract().as(Book.class);
    }

    @Then("the extracted book name should be {string}")
    public void verifyBookName(String name) {
        Book book = (Book) extractedResponse;
        assertThat(book.getName()).isEqualTo(name);
    }
}
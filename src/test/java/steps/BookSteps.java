package steps;

import com.booksapi.services.Api;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class BookSteps {
    private Response response;


    @When("I send a GET request to fetch all books")
    public void getAllBooks() {
        response = Api.booksApi.getAllBooks();
    }

    @When("I send a GET request for book ID {int}")
    public void getBookById(int id) {
        response = Api.booksApi.getBookById(id);
    }
/*
    @When("I send a POST request to create a book")
    public void createBook() {
        Book book = new Book(null, "Refactoring", "Martin Fowler", "Addison-Wesley", "Programming", 450, 40.00);
        response = given().auth().preemptive().basic(USER, PASS)
                .header("Content-Type", "application/json")
                .body(book)
                .when().post(BASE_URL + "/books");
    }

    @When("I send a PUT request to update book ID {int}")
    public void updateBook(int id) {
        Book book = new Book(id, "Refactoring Updated", "Martin Fowler", "Addison-Wesley", "Programming", 448, 35.50);
        response = given().auth().preemptive().basic(USER, PASS)
                .header("Content-Type", "application/json")
                .body(book)
                .when().put(BASE_URL + "/books/" + id);
    }*/

    @When("I send a DELETE request for book ID {int}")
    public void deleteBook(int id) {
        response = Api.booksApi.delete(id);
    }

    @Then("the response status code should be {int}")
    public void validateStatusCode(int code) {
        response.then().statusCode(code);
    }
}
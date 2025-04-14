package steps;

import com.booksapi.services.Api;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;

import static org.assertj.core.api.Assertions.assertThat;

public class CommonSteps {

    @Then("the response status code should be {int}")
    public void validateStatusCode(int code) {
        Response response = Api.booksApi.getAllBooks();
        response.then().statusCode(code);
    }

    @Then("the response should not be null and status code should be {int}")
    public void validateResponseNotNull(int code) {
        Response response = Api.booksApi.getAllBooks();
        assertThat(response).isNotNull();
        response.then().statusCode(code);
    }

    @Then("the response time should be less than {int} milliseconds")
    public void validateResponseTime(int maxMillis) {
        Response response = Api.booksApi.getAllBooks();
        long responseTime = response.time();
        assertThat(responseTime).isLessThan(maxMillis);
    }

    @Then("the response content type should be JSON")
    public void validateContentTypeJson() {
        Response response = Api.booksApi.getAllBooks();
        response.then().contentType("application/json");
    }
}
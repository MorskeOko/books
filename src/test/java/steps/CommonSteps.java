package steps;

import com.booksapi.utils.ContextManager;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

public class CommonSteps {

    @Then("the response status code should be {int}")
    public void validateStatusCode(int code) {
        Response response = ContextManager.getContext().get("response", Response.class);
        response.then().statusCode(200);
    }

    @Then("the response time should be less than {int} milliseconds")
    public void validateResponseTime(int maxMillis) {
        Response response = ContextManager.getContext().get("response", Response.class);
        Assertions.assertThat(response.time()).isLessThan(maxMillis);
    }
}
package steps;

import com.booksapi.models.BookDto;
import com.booksapi.services.Api;
import com.booksapi.utils.ContextManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.assertj.core.api.Assertions;

import java.util.List;
import java.util.Map;

public class GetBookSteps {

    @Given("the database contains books otherwise create new with name {string}")
    public void createBookIfNotExist(String name) {
        if (Api.booksApi.getAllBooksAsList().isEmpty()) {
            BookDto book = new BookDto(name, "Martin Fowler", "Addison-Wesley", "Programming", 450, 40.00);
            Api.booksApi.createBook(book);
        }
    }

    @Then("the response should include the IDs of {string} and {string} and others if exist")
    public void verifyBookIdsIncluded(String name1, String name2) {
        Map<String, Integer> bookIds = ContextManager.getContext().get("bookIds", Map.class);
        Integer id1 = bookIds.get(name1);
        Integer id2 = bookIds.get(name2);
        List<Integer> allIds = Api.booksApi.getAllBooksAsList()
                .stream()
                .map(BookDto::getId)
                .toList();

        Assertions.assertThat(allIds).contains(id1, id2);
    }

    @Then("the response should contain the newly added book")
    public void validateNewBookInResponse() {
        BookDto expected = ContextManager.getContext().get("createdBook", BookDto.class);
        List<BookDto> actual = Api.booksApi.getAllBooksAsList();
        Assertions.assertThat(actual).anyMatch(book -> book.getName().equals(expected.getName()));
    }

    @When("I send a GET request to fetch all books")
    public void getAllBooks() {
        Response response = Api.booksApi.getAllBooks();
        ContextManager.getContext().set("response", response);
    }

    @Then("the GET response should not contain the deleted book")
    public void validateDeletedBookNotPresent() {
        Integer deletedId = ContextManager.getContext().get("deletedBookId", Integer.class);
        List<BookDto> books = Api.booksApi.getAllBooksAsList();
        Assertions.assertThat(books)
                .noneMatch(book -> book.getId() == deletedId);
    }

    @Then("the GET response has the updated book name")
    public void verifyUpdatedBookNameInGetResponse() {
        BookDto expected = ContextManager.getContext().get("updatedBook", BookDto.class);
        List<BookDto> books = Api.booksApi.getAllBooksAsList();
        boolean found = books.stream()
                .anyMatch(book -> book.getId() == expected.getId()
                        && book.getName().equals(expected.getName()));
        Assertions.assertThat(found).isTrue();
    }

    @Then("the response should contain the book with hardcoded parameters")
    public void validateBookCreatedWithExpectedData() {
        BookDto expected = ContextManager.getContext().get("expectedBook", BookDto.class);
        BookDto actual = ContextManager.getContext().get("createdBook", BookDto.class);

        Assertions.assertThat(actual.getName()).isEqualTo(expected.getName());
        Assertions.assertThat(actual.getAuthor()).isEqualTo(expected.getAuthor());
        Assertions.assertThat(actual.getPublication()).isEqualTo(expected.getPublication());
        Assertions.assertThat(actual.getCategory()).isEqualTo(expected.getCategory());
        Assertions.assertThat(actual.getPages()).isEqualTo(expected.getPages());
        Assertions.assertThat(actual.getPrice()).isEqualTo(expected.getPrice());
    }
}
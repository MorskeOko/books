package steps;

import com.booksapi.models.BookDto;
import com.booksapi.services.Api;
import com.booksapi.utils.ContextManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

import java.util.List;


public class DeleteBookSteps {

    @And("the book is deleted with name {string}")
    public void deleteBookByName(String name) {
        List<BookDto> books = Api.booksApi.getAllBooksAsList();
        books.stream()
                .filter(book -> name.equals(book.getName()))
                .findFirst()
                .ifPresent(book -> {
                    Api.booksApi.deleteById(book.getId());
                    ContextManager.getContext().set("deletedBookId", book.getId());
                });
    }

    @Then("the delete response should contain the same book or be empty")
    public void verifyDeleteResponseCorrectness() {
        BookDto expected = ContextManager.getContext().get("bookBeforeDelete", BookDto.class);
        BookDto deleted = ContextManager.getContext().get("deletedBook", BookDto.class);

        if (deleted != null) {
            Assertions.assertThat(deleted.getId()).isEqualTo(expected.getId());
            Assertions.assertThat(deleted.getName()).isEqualTo(expected.getName());
        }
    }
}
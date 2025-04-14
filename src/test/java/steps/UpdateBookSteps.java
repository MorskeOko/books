package steps;

import com.booksapi.models.BookDto;
import com.booksapi.services.Api;
import com.booksapi.utils.ContextManager;
import io.cucumber.java.en.And;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public class UpdateBookSteps {

    @And("I send a PUT request to update book with name {string}")
    public void updateBookByName(String name) {
        List<BookDto> books = Api.booksApi.getAllBooksAsList();
        Optional<BookDto> optionalBook = books.stream()
                .filter(book -> name.equals(book.getName()))
                .findFirst();
        if (optionalBook.isPresent()) {
            BookDto book = optionalBook.get();

            BookDto updated = BookDto.builder()
                    .id(book.getId())
                    .name(book.getName() + " Updated")
                    .author(book.getAuthor())
                    .build();

            Api.booksApi.updateBook(updated, updated.getId());
            ContextManager.getContext().set("updatedBook", updated);
        } else {
            throw new IllegalStateException("Book with name '" + name + "' not found for update");
        }
    }

    @And("the book is updated with name {string} with ID saved")
    public void updateBookByNameAndStoreName(String name) {
        Map<String, Integer> bookIds = ContextManager.getContext().get("updatedBookIds", Map.class);
        Integer id = bookIds.get(name);
        if (id != null) {
            Api.booksApi.deleteById(id);
            bookIds.remove(name);
        }
    }
}
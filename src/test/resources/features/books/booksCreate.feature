Feature: Books API

  Scenario: Create a new book
    When the new book is created with name "Clean Code: A Handbook of Agile Software Craftsmanship"
    Then I send a GET request to fetch all books
    Then

  Scenario: Update a book
    When I send a PUT request to update book ID 626
    Then the response status code should be 200

  Scenario: Delete a book
    When I send a DELETE request for book ID 638
    Then the response status code should be 200
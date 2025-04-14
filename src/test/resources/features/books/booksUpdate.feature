@regression
Feature: Update Books Endpoint


  Scenario: Update a book
    When the new book is created with name "Clean Code: A Handbook of Agile Software Craftsmanship" and ID stored
    When I send a PUT request to update book with name "Clean Code: A Handbook of Agile Software Craftsmanship"
    When I send a GET request to fetch all books
    Then the GET response has the updated book name
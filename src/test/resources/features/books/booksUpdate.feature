@regression
Feature: Books API


  Scenario: Update a book
    When the new book is created with name "Clean Code: A Handbook of Agile Software Craftsmanship" and ID stored
    When I send a PUT request to update book with name "Clean Code: A Handbook of Agile Software Craftsmanship"
    Then the response status code should be 200
    When I send a GET request to fetch all books
    Then the GET response has the updated book name


  Scenario: Delete a book
    When the new book is created with name "Test Driven Development: By Example" and ID stored
    Then the response status code should be 200
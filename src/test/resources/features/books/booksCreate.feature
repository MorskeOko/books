@regression
Feature: Books API

  Scenario: Create a new book
    When the new book is created with name "Clean Code: A Handbook of Agile Software Craftsmanship" and ID stored
    Then the response should contain the book with name "Clean Code: A Handbook of Agile Software Craftsmanship"
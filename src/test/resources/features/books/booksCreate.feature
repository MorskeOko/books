@regression
Feature: Create Books Endpoint

  Scenario: Create a new book
    When the new book is created with name "Clean Code: A Handbook of Agile Software Craftsmanship" and ID stored
    Then the response should contain the book with name "Clean Code: A Handbook of Agile Software Craftsmanship"

  Scenario: Create a new book with exact data and check it is returned correctly
    When the new book is created with hardcoded data and ID stored
    Then the response should contain the book with hardcoded parameters
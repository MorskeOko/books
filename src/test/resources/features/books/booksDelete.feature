@regression
Feature: Books API

  Scenario: Delete a book
    Given the new book is created with name "Magic" and ID stored
    When the book is deleted with name "Magic" with ID saved
    Then the response should not contain the deleted book
@regression
Feature: Delete Books Endpoint

  Scenario: Delete a book
    Given the new book is created with name "Magic" and ID stored
    And the book is deleted with name "Magic"
    Then the response should not contain the deleted book

  Scenario: Deleting a book should return the deleted book or no content
    Given the new book is created with name "ToDelete" and ID stored
    When the book is deleted with name "ToDelete"
    Then the delete response should contain the same book or be empty
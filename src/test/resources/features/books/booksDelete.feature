@regression
Feature: Delete Books Endpoint

  Scenario: Delete a book
    Given the new book is created with name "Magic" and ID stored
    And the book is deleted with name "Magic"
    Then the response should not contain the deleted book
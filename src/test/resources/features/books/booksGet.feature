@regression
Feature: Get Books Endpoint

  Scenario: Get all books when there are some books in DB and verify the response is valid with status code 200
    Given the database contains books otherwise create new with name "Refactoring"
    When I send a GET request to fetch all books
    Then the response should contain the book with name "Refactoring"


  Scenario: Verify book IDs are sequential
    Given the database contains books otherwise create new with name "Test Driven Development: By Example"
    When the new book is created with name "Test 1" and ID stored
    When the new book is created with name "Test 2" and ID stored
    When the new book is created with name "Test 3" and ID stored
    And the book is deleted with name "Test 2"
    When I send a GET request to fetch all books
    Then the response should include the IDs of "Test 1" and "Test 3" and others if exist
@smoke
Feature: Get Books Endpoint

  Scenario: Get all books when there are some books in DB and verify the response is valid with status code 200
    Given the database contains books
    When I send a GET request to fetch all books
    Then the response should not be null and status code should be 200
    Then the response content type should be JSON

  Scenario: Get books after adding a new book and verify the new book added successfully
    Given the database has no books and existing books are deleted
    When the new book is created with name "Abracadabra"
    And I send a GET request to fetch all books
    Then the response should contain the newly added book

  Scenario: Get books after deleting a book
    Given the new book is created with name "Magic"
    And the book is deleted with name "Magic"
    When I send a GET request to fetch all books
    Then the response should not contain the deleted book

  Scenario: Verify book IDs are sequential
    Given the database contains books
    When the new book is created with name "Test 1"
    When the new book is created with name "Test 2"
    When the new book is created with name "Test 3"
    And the book is deleted with name "Test 2"
    When I send a GET request to fetch all books
    Then the remaining book IDs should be "Test 1" and "Test 3"
Feature: Smoke suit for Books API

  @smoke
  Scenario: Get all books and check response status is 200
    When I send a GET request to fetch all books
    Then the response status code should be 200
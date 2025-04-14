Feature: Books API

  Scenario: Get all books and check response is not null with status 200
    When I send a GET request to fetch all books
    Then the response status code should be 200
    And the response content type should be JSON
    And the response should not be null
    And the response time should be less than 2000 milliseconds

  Scenario: Get all books when at least 1 book is in the DB
    When I send a POST request to create a book
    Then the response status code should be 200
    When I send a GET request to fetch all books
    Then the response status code should be 200
    And the response should not be null
    And the response should be a list of books
    And the first book should have all required fields
    And the response time should be less than 2000 milliseconds

    And the response should be a list of books
    And the first book should have all required fields


  Scenario: Get book by ID
    When I send a GET request for book ID 1
    Then the response status code should be 404

  Scenario: Get book by ID
    When I send a GET request for book ID 626
    Then the response status code should be 200

  Scenario: Create a new book
    When I send a POST request to create a book
    Then the response status code should be 200

  Scenario: Update a book
    When I send a PUT request to update book ID 626
    Then the response status code should be 200

  Scenario: Delete a book
    When I send a DELETE request for book ID 638
    Then the response status code should be 200
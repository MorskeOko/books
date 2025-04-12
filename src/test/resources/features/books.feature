Feature: Books API

  Scenario: Get all books
    When I send a GET request to fetch all books
    Then the response status code should be 200

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
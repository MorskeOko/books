Feature: Books API



  Scenario: Update a book
    When I send a PUT request to update book ID 626
    Then the response status code should be 200

  Scenario: Delete a book
    When I send a DELETE request for book ID 638
    Then the response status code should be 200
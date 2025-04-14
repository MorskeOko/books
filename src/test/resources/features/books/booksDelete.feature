Feature: Books API


  Scenario: Delete a book
    When I send a DELETE request for book ID 638
    Then the response status code should be 200
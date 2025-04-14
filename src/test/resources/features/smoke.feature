@smoke
Feature: Smoke suit for Books API


  Scenario: Get all books and check response status is 200
    When I send a GET request to fetch all books
    Then the response status code should be 200
    Then the response time should be less than 2000 milliseconds
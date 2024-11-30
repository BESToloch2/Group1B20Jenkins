Feature: APIUserCreation

  Scenario: Creating a user
    Given a request is prepared for creating the employee
    When I send a POST request with the user data
    Then the API should respond with a status code 400
    And the response should include "Message": "The email address you have entered is already registered"

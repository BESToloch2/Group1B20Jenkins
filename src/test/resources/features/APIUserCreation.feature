Feature: APIUserCreation

  @api
  Scenario: Creating a user with valid credentials
    Given a request is prepared for creating user with all correct required fields
    When I send a POST request with the user data
    Then the API should respond with a status created code 201
    And the response should include success "Message" "User Created"

  @api
  Scenario: Creating a user with an email that is already in the system
    Given a request is prepared for creating user with all correct required fields
    When I send a POST request with the user data
    Then the API should respond with a status success code 200
    And the response should include "Message" "The email address you have entered is already registered"

  @api
  Scenario: Creating a user with an empty password field
    Given a request is prepared for creating user with an empty password field
    When I send a POST request with the user data
    Then the API should respond with a status bad request code 400
    And the response should include "condition" "error" , "data" "Please fill all inputs"

  @api
  Scenario: Creating a user with an empty name field
    Given a request is prepared for creating user with an empty name field
    When I send a POST request with the user data
    Then the API should respond with a status bad request code 400
    And the response should include "condition" "error" , "data" "Please fill all inputs"

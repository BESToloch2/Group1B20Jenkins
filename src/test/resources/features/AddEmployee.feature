Feature: Add Employee

  Background:
    Given user is able to access to hrms app
    When user enter valid credentials
    And click on login button
    Then user navigate to dashboard page
    When user clicks on PIM option
    And user clicks on add employee option

  @add @gui
  Scenario: add employee by firstname and lastname
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

  @add @gui
  Scenario: add employee by id
    And user enters firstname and lastname
    And user clears id field
    And user enters id
    And user clicks on save button
    Then employee added successfully

  @add @gui
  Scenario:  add employee without lastname
    And user enters firstname
    And user clicks on save button
    Then user can see lastname error message








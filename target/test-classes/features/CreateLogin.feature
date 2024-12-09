Feature: Create Login for New Employee

  Background:
    //Given user is able to access to hrms app

  @create @gui
  Scenario: create login details
    When user enter valid credentials
    And click on login button
    Then user navigate to dashboard page
    When user clicks on PIM option
    And user clicks on add employee option
    When user enters firstname middlename lastname
    And clicks on create login details checkbox
    And user enters username
    And user enters password
    And user confirms password
    And user clicks save button
    Then employee created successfully

  @create @gui
  Scenario: login using new login details
    When user enters username and password
    And click on login button
    Then user navigate to dashboard page
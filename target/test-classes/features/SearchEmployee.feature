Feature: Search for Employee

  Background:
    Given user is able to access to hrms app
    When user enter valid credentials
    And click on login button
    Then user navigate to dashboard page
    When user clicks on PIM option

  @search @fullName @gui
  Scenario: search with full name
    When user enters full name
    And clicks search button
    Then all matching employees should be returned

  @search @partialName @gui
  Scenario: search with partial name
    When user enters partial name
    And clicks search button
    Then all matching employees should be returned partial

  @search @id @gui
  Scenario: search with id
    When user enters valid id
    And clicks search button
    Then all matching employees should be returned id

  @search @inaccurate @gui
  Scenario: search with inaccurate info
    When user enters invalid id
    And clicks search button
    Then "No Records Found" is displayed


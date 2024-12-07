
Feature: Updated Contact Details


  Background:
#Given user is able to access HRMS application
    When user enters admin username and admin password
    And user clicks on login button
    Then user is navigated to dashboard page
    When user clicks on PIM option
    And user clicks on employee list option
    And user enters employee ID
    And user clicks on search button
    Then user is able to see searched employee on screen

  @add
  Scenario Outline: Edit contact information successfully
    When user clicks on id field
    Then user clicks the Contact Details section
    And user clicks on edit button
    And user updates his common information with the following details: "<addressStreet1>" and "<addressStreet2>" and "<city>" and "<state>" and "<zipCode>" and "<country>" and "<homePhone>" and "<mobilePhone>" and "<workPhone>" and "<workEmail>" and "<otherEmail>"
    Then the contact information should be updated successfully
    Examples:
      |addressStreet1|addressStreet2|city    |state      |zipCode|country      |homePhone   |mobilePhone |workPhone   |workEmail     |otherEmail  |
      |222 Clematis|Apt 239       |Miami|Florida   |33101  |United States|123-444-3333|111-222-3333|555-5555-5555|zizi@gmail.com|zizi@1           |
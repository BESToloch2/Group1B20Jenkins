Feature: Manage Membership Details
  As an employee,
  I want to add my membership details to my HRMS profile,
  So that my profile accurately reflects my professional memberships and subscriptions.

  Scenario: Add new membership details
   // Given the user is logged into the HRMS system
    When user clicks on the membership button
    And user clicks on Add option button
    And user selects an option from the dropdown menu
    And user selects Subscription Paid By
    And user enters paid amount "100"
    And user selects Currency
    And user enters the day of Subscription and Renewal
    And user presses the save button
    Then the membership details should be saved successfully

  Scenario: Validate mandatory fields
    Given the user is logged into the HRMS system
    When user clicks on the membership button
    And user clicks on Add option button
    And user skips filling mandatory fields
    And user presses the save button
    Then an error message "Please fill in all mandatory fields" should be displayed

  Scenario: Edit existing membership details
    Given the user is logged into the HRMS system
    When user clicks on the membership button
    And user edits the membership details
    And user presses the save button
    Then the updated membership details should be saved successfully


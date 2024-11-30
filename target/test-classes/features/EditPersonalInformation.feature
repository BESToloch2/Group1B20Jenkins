Feature: Edit Personal Information in HRMS
  As an ESS user,
  I want to be able to edit my personal information within the HRMS application,
  So that I can keep my details accurate and up-to-date.

  Background:
    Given I am on the HRMS login page at "http://hrmstest.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
    And I have logged in using valid ESS credentials

  Scenario: Edit personal information successfully
    Given I am on the "Personal Information" page
    When I update the following fields:
      | Field          | Value            |
      | First Name     | John             |
      | Middle Name    | A.               |
      | Last Name      | Doe              |
      | Gender         | Male             |
      | Nationality    | American         |
      | Marital Status | Married          |
    And I click the "Save" button
    Then the system should save the changes successfully
    And I should see a confirmation message "Your details have been updated successfully"
    And the changes should be reflected on the "Personal Information" page

  Scenario: Verify changes are saved in the database
    Given I have successfully updated my personal information
    When I query the database for the employee record with ID "ESS12345" (example ID)
    Then the database should show the following updated values:
      | Field          | Value            |
      | First Name     | John             |
      | Middle Name    | A.               |
      | Last Name      | Doe              |
      | Gender         | Male             |
      | Nationality    | American         |
      | Marital Status | Married          |

  Scenario: Attempt to submit invalid or incomplete information
    Given I am on the "Personal Information" page
    When I leave the "First Name" field empty
    And I click the "Save" button
    Then the system should display an error message "First Name is required"
    And the changes should not be saved
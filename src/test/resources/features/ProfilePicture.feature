Feature: Profile Picture Upload for ESS Users
  As an ESS user,
  I want to upload a profile picture,
  So that I can personalize my HRMS profile.

  Background:
    //Given I am logged into the HRMS application as an ESS user
    And I navigate to the profile picture upload page
    And I click on the profile picture to initiate the upload process
  @gui
  Scenario Outline: Successfully uploading a profile picture
    When I select a profile picture "<Filename>" with a size of <Filesize> bytes
    And I click the "Upload" button
    Then I should see a success message "<Success Message>"
    And the uploaded profile picture should be displayed

    Examples:
      | Filename       | Filesize | Success Message              |
      | profile.jpg    | 500000   | Successfully uploaded.       |
      | profile.png    | 800000   | Successfully uploaded.       |
      | profile.gif    | 900000   | Successfully uploaded.       |
  @gui
  Scenario Outline: Handling errors during profile picture upload
    When I select a profile picture "<Filename>" with a size of <Filesize> bytes
    And I click the "Upload" button
    Then I should see an error message "<Error Message>"
    And the profile picture upload should not be saved

    Examples:
      | Filename           | Filesize  | Error Message                        |
      | large_profile.jpg  | 2000000   | File size exceeds the 1MB limit.     |
      | invalid_format.bmp | 300000    | Unsupported file format. Allowed: .jpg, .png, .gif. |

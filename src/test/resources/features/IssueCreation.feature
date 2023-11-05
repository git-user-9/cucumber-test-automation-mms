Feature: Issue Creation

  Scenario: Student creates an issue
    Given the student is logged in
    When the student goes to the issue creation page
    And the student enters an issue description
    And the student clicks the "Send" button
    Then the issue should be created successfully

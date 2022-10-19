Feature: Login

  Scenario: Login with valid credendials
    Given User on the Trendyol page
    When User navigates the login page
    And User types username and password on Login page
    Then Verify that successful login

  Scenario: Login with invalid username credendials
    Given User on the Trendyol page
    When User navigates the login page
    And User types invalid username and valid password on Login page
    Then Verify that unsuccessful login
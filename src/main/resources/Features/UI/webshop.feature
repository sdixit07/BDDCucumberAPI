Feature: Demo Web Shop Login test

  @UI
  Scenario: Login test
    Given I enter the Application url
    When I click on the Login link
    And I enter the username
    And I enter the password
    And I click on the Log in button
    Then I login to the application successfully
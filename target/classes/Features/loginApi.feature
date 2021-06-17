Feature: Login API test

  @smoke
  Scenario Outline: Login test
    Given I prepare the Endpoint
    When I set the content type as "multipart/form-data"
    And I enter the credentials as "<username>" and "<password>"
    And I hit the login API POST request
    Then I fetch the access token
    And I verify that the login is successful
    When I set the token
    And I hit the Products Page GET API request
    Then I verify that the Products are fetched successfully

    Examples:
      | username          | password    |
      | saurabh1@test.com | Saurabh@123 |
Feature: feature to test log in functionality

  Scenario Outline: Check login is successful with valid credentials
    Given user is on log in page
    When User enters <username> and <password>
    And clicks on login button
    Then user is navigated to the home page

    Examples: 
      | username | password    |
      | student  | Password123 |
      | ele      | ertf        |

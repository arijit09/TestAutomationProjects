Feature: feature to test google search functionality

  Scenario: Validate google search is working
    Given Browser is open
    And user is on google search page
    When User enters a text in the test box
    And hits enter
    Then User is navigated to search results
 
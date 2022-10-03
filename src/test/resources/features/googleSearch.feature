Feature: Google search functionality
  As a user, when im on the Google Search page
  I should be able to search whatever I want and see relevant information

  @wip
  Scenario: Search functionality result title verification
    Given user is on the google search page
    Then user clicks on accept button
    When user types apple in google search box and clicks enter
    Then user sees apple in google title


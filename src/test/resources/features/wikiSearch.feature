Feature: Wikipedia search functionality and verification


  Scenario:  Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" is in the wiki title

Scenario:  Wikipedia Search Functionality Header Verification
  Given User is on Wikipedia home page
  When User types "Steve Jobs" in the wiki search box
  And User clicks wiki search button
  Then User sees "Steve Jobs" in the main header

  Scenario: Wikipedia Search Functionality Image Header Verification
    Given User is on Wikipedia home page
    When User types "Steve Jobs" in the wiki search box
    And User clicks wiki search button
    Then User sees "Steve Jobs" in the image header

    @scenarioOutline
  Scenario Outline:  Wikipedia Search Functionality Title Verification
    Given User is on Wikipedia home page
    When User types "<searchValue>" in the wiki search box
    And User clicks wiki search button
    Then User sees "<expectedTitle>" is in the wiki title
    Then User sees "<expectedMainHeader>" in the image header

    Examples: search values we are going to be using in this scenario is as follows
      | searchValue  | expectedTitle | expectedMainHeader |
      | Steve Jobs   | Steve Jobs    | Steve Jobs         |
      | Bob Marley   | Bob Marley    | Bob Marley         |
      | Lady Gaga    | Lady Gaga     | Lady Gaga          |
      | Selim Onemli | Selim Onemli  | Selim Onemli       |


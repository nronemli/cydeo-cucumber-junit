Feature: Web table user order feature

  @wip
  Scenario: User should be able to place and order seen in the web table
    Given user is already logged in and on order page
    When user selects product type "Familybea"
    And user enters quantity 2
    And user enters costumer name "Sherlock Holmes"
    And user enters street "221B Baker Street"
    And user enters city "London"
    And user enters state "England"
    And user enters zipcode "50505"
    And user enters credit card type "MasterCard"
    And user enters credit cart number "11112222233334444"
    And user enters expiry date "12/23"
    And user enters process order button
    Then user should see "Sherlock Holmes" in the first row of the web table



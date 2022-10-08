Feature: Web table user order feature

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

  @wip
  Scenario Template: User should be able to place and order seen in the web table
    Given user is already logged in and on order page
    When user selects product type "<productType>"
    And user enters quantity <quantity>
    And user enters costumer name "<customerName>"
    And user enters street "<streetName>"
    And user enters city "<city>"
    And user enters state "<state>"
    And user enters zipcode "<zipCode>"
    And user enters credit card type "<cardType>"
    And user enters credit cart number "<cardNumber>"
    And user enters expiry date "<expDate>"
    And user enters process order button
    Then user should see "<expectedName>" in the first row of the web table

    Examples: Famous female scientists
      | productType | quantity | customerName | streetName | city      | state  | zipCode | cardType | cardNumber    | expDate | expectedName |  |
      | MoneyCog    | 2        | Necip Onemli | London st  | Middlesex | London | tw75hn  | visa     | 2323232323232 | 12/12   | Necip Onemli |  |
      | Familybea   | 3        | Nur Onemli   | London st  | Middlesex | London | tw75hn  | visa     | 2323232323232 | 12/12   | Nur Onemli   |  |
      | Screenable  | 4        | Emin Selim   | London st  | Middlesex | London | tw75hn  | visa     | 2323232323232 | 12/12   | Emin Selim   |  |


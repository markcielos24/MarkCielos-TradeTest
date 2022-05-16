@regression @UIBuyLimitMatch
Feature: Verify User will be able to complete a Buy order at Limit price

  Scenario Outline: Validate New Home Loan (ENQUIRE) is working
    Given browser is open using <browser>
    And user is on login page <environment>
    And user login using proper credentials <user>
    And user click TRADE on navigation tab found in top of the homepage 
    When user is in Enter Order user will input <instrument_market> in ticker field
    And user is in Enter Order user select Side <side>
    And user is in Enter Order user select Type <type>
    And user is in Enter Order user enter Total quantity <quantity>
    And user is in Enter Order user enter Limit Price <limit_price>
    And user is in Enter Order user click place <side> order button
    #Then Buy order will be completed when a matching price Sell order is available
    And user take screenshot and close browser

    Examples: 
      | browser | environment| user        | instrument_market | side | type  | quantity | limit_price |
      | Chrome  | SIT1       | SIT1_User01 | ETHPHP            | buy  | limit | 1        | 80600       |
      | Firefox | SIT1       | SIT1_User01 | USDTPHP           | sell | limit | 2        | 50          |
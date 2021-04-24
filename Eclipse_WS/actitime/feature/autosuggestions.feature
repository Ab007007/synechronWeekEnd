Feature: Print AutoSuggestion

  Scenario: Printing Auto suggestions for Synechron
    Given user is on google page
    When user enter synechron
    Then user is displayed with autosuggestions
    And user print the autosuggestion and close the browser

  Scenario: Printing Auto suggestions for IBM
    Given user is on google page
    When user enter IBM
    Then user is displayed with autosuggestions
    And user print the autosuggestion and close the browser

  Scenario: Printing Auto suggestions for Wipro
    Given user is on google page
    When user enter Wipro
    Then user is displayed with autosuggestions
    And user print the autosuggestion and close the browser

  Scenario: Printing Auto suggestions for Number
    Given user is on google page
    When user enter 12344
    Then user is displayed with autosuggestions
    And user print the autosuggestion and close the browser

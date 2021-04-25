Feature: Print AutoSuggestion
	@googleexample @smoke
  Scenario Outline: Printing Auto suggestions for Synechron
    Given user is on google page
    When user enter <company>
    Then user is displayed with autosuggestions
    And user print the autosuggestion and close the browser

    Examples: 
      | company   |
      | Synechron |
      | IBM       |
      | Wipro     |

@smoke
Feature: Print AutoSuggestion

	@dt @regression
  Scenario: Printing Auto suggestions as Maps
    Given user is on google page
    When user search and print autosuggestions as maps
      | company  | companydesc |
      | iGate    | dsds        |
      | infosys  | dasf        |
      | Mindtree | asfdds      |
    And close the browser

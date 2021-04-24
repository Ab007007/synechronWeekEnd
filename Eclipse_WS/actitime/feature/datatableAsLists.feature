Feature: Print AutoSuggestion

  Scenario: Printing Auto suggestions as DataTable Lists
    Given user is on google page
    When user search and print autosuggestions
      | company   | companydesc |
      | Synechron | dsds        |
      | IBM       | dasf        |
      | Wipro     | asfdds      |
    And close the browser

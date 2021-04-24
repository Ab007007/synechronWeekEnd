Feature: Google Search

  Scenario: Printing Google Search when there is a  match
    Given user is on google search page
    When user enter synechron 
    And click on search
    Then google display 10 results

  Scenario: Printing Google Search when there is no match
    Given user is on yahoo search page
    When user enter qweqwfdsdsafddf342342342342342342 
    And click on search
    Then google display 0 result
    
  
 Scenario: Printing Google Search when there is no match
    Given user is on rediff search page
    When user enter qweqwfdsdsafddf342342342342342342 
    And click on search
    Then google display 0 result
    
  
  
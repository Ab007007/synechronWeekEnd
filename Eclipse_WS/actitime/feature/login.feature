Feature: Login Feature

  Scenario: validate successfull login on valid credentials
    Given actitime user is on login page
    When actitime user enter valid username and password
    And click on login button
    Then user will be navigated to home page
    And user validate the home page and logout
    And close the browser

  Scenario: validate unsuccessfull login on invalid credentials
    Given actitime user is on login page
    When actitime user enter invalid username and password
    And click on login button
    Then user will be prompted with a error message
    And user validate the login page
    And close the browser

  Scenario: validate unsuccessfull login on invalid credentials
    Given actitime user is on login page
    When user does not  username and password
    And click on login button
    Then user will be prompted with a error message
    And user validate the login page
    And close the browser

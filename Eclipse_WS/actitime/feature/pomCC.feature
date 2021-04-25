@pom
Feature: Create Customer successfully

  Background: 
    Given pom user has all page class Objects
    And pom user is on login page
    And pom user login to the applciation
    When pom user click on tasks tab
    Then pom user is navigated to tasks page

  Scenario: Create a customer which is not exist
    When pom user click on new customer
    And pom user enter valid cucumber-Customer6 and cucumber-CustomerDesc1
    Then success message should be disaplyed
    And pom user logout after validating success message

  Scenario: Create a customer which is exist
    When pom user click on new customer
    And pom user enter existing cucumber-Customer6 and cucumber-CustomerDesc1
    Then pom user validates the error message
    And pom user logout after clicking on cancel

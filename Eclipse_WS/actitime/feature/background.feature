Feature: Create Customer successfully

  Background: 
    Given actitime user is on login page
    And actitime user login to the applciation
    When actitime user click on tasks tab
    Then actitime user is navigated to tasks page
	
	@development
  Scenario: Create a customer which is not exist
    When actitime user click on new customer
    And actitime user enter valid cucumber-Customer4 and cucumber-CustomerDesc1
    Then customer create success message should be disaplyed
    And actitime user logout after validating success message
	@development
  Scenario: Create a customer which is exist
    When actitime user click on new customer
    And actitime user enter existing cucumber-Customer4 and cucumber-CustomerDesc1
    Then actitime user validates the error message
    And actitime user logout after clicking on cancel

package stepdefinition;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MathematicalOperations {

	int num1, num2, res;

	@Given("user has 2 numbers {} and {}")
	public void user_has_numbers_and(Integer int2, Integer int3) {
		num1 = int2;
		num2 = int3;
	}

	@When("user perform {}")
	public void user_perform_addition(String str) {
		switch (str) {
		case "addition":
			res = num1 + num2 ; 
			break;

		case "substraction":
			res = num1 - num2 ; 
			
			break;

		case "multiplication":
			res = num1 * num2 ; 
			
			break;

		case "division":
			res = num1 / num2 ; 
			
			break;

		default:
			break;
		}
	}

	@Then("he get {}")
	public void he_get(String int1) {
			Assert.assertEquals(String.valueOf(int1), String.valueOf(res));
	}

}

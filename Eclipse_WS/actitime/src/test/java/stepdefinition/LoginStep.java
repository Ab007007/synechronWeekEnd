package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep {

	WebDriver driver = null;
	@Given("user is on login page")
	public void user_is_on_login_page() {
		driver = ActitimeUtils.getDriver();
		ActitimeUtils.launch();
		
	}

	@When("user enter valid username and password")
	public void user_enter_valid_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("admin");
		driver.findElement(By.name("pwd")).sendKeys("manager");
		
	}

	@When("click on login button")
	public void click_on_login_button() {
		driver.findElement(By.id("loginButton")).click();
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Then("user will be navigated to home page")
	public void user_will_be_navigated_to_home_page() {
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
	}

	@Then("user validate the home page and logout")
	public void user_validate_the_home_page() {
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
		ActitimeUtils.logout();
	}

	@When("user enter invalid username and password")
	public void user_enter_invalid_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("admin1");
		driver.findElement(By.name("pwd")).sendKeys("manager1");
	}

	@Then("user will be prompted with a error message")
	public void user_will_be_prompted_with_a_error_message() {
	    String errorMsg = driver.findElement(By.xpath("//span[@class='errormsg']")).getText();
		Assert.assertEquals(errorMsg, "Username or Password is invalid. Please try again.");
	}

	@Then("user validate the login page")
	public void user_validate_the_login_page() {
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
	}
	
	@When("user does not  username and password")
	public void user_does_not_username_and_password() {
		driver.findElement(By.id("username")).sendKeys("");
		driver.findElement(By.name("pwd")).sendKeys("");
	}
}

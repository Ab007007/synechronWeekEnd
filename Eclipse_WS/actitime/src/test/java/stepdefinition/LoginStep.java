package stepdefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.synechron.selenium.actitime.utils.ActitimeUtils;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStep extends GlobalVariables {

	@Given("actitime user is on login page")
	public void user_is_on_login_page() {
		driver = ActitimeUtils.getDriver();
		ActitimeUtils.launch();

	}

	@When("actitime user enter valid username and password")
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

	@When("actitime user enter invalid username and password")
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

	@Given("actitime user login to the applciation")
	public void actitime_user_login_to_the_applciation() {
		ActitimeUtils.login("admin", "manager");
	}

	@When("actitime user click on tasks tab")
	public void actitime_user_click_on_tasks_tab() {
		ActitimeUtils.selectModule("tasks");
	}

	@Then("actitime user is navigated to tasks page")
	public void actitime_user_is_navigated_to_tasks_page() {
		Assert.assertEquals(driver.getTitle(), "actiTIME - Task List");
	}

	@When("actitime user click on new customer")
	public void actitime_user_click_on_new_customer() {
		ActitimeUtils.clickOnNewCustomerButton();
	}

	@When("actitime user enter valid {} and {}")
	public void actitime_user_enter_valid_customer_namd_and_desc(String cn, String cd) {
		ActitimeUtils.createCustomer(cn, cd);
	}

	@Then("customer create success message should be disaplyed")
	public void customer_create_success_message_should_be_disaplyed() {

	}

	@Then("actitime user logout after validating success message")
	public void actitime_user_logout_after_validating_success_message() {
		ActitimeUtils.logout();
		driver.close();
	}

	@When("actitime user enter existing {} and {}")
	public void actitime_user_enter_existing_and(String string, String string2) {
		driver.findElement(By.id("customerLightBox_nameField")).sendKeys(string);
		driver.findElement(By.id("customerLightBox_descriptionField")).sendKeys(string2);
		driver.findElement(By.id("customerLightBox_commitBtn")).click();
	}

	@Then("actitime user validates the error message")
	public void actitime_user_validates_the_error_message() {
		if (driver.findElement(By.id("customerLightBox_nameDuplicateError")).isDisplayed()) {
			String errorMsg = driver.findElement(By.id("customerLightBox_nameDuplicateError")).getText();
			System.out.println("Error Msg:" + errorMsg);
			Assert.assertTrue(true);
		} else {
			Assert.assertFalse(true);
		}

	}

	@Then("actitime user logout after clicking on cancel")
	public void actitime_user_logout_after_clicking_on_cancel() {
		driver.findElement(By.id("customerLightBox_cancelBtn")).click();
		driver.switchTo().alert().accept();
		ActitimeUtils.logout();
		driver.close();

	}


	@Before
	public void beforeScenario() {
		System.out.println("#######################################################");
	}
	
	
	@After
	public void afterScenario(Scenario sc) {
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$" + sc.getName() + " : " + sc.getStatus());
	}
	
	
	
	@BeforeStep
	public void beforeStep() {
		System.out.println("--------------------------------------------------------------");
	}
	
	
	@AfterStep
	public void aferStep() {
		System.out.println("..................................................................");
	}
	
			
}

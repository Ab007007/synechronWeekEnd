package stepdefinition;

import org.junit.Assert;

import com.synechron.selenium.actitime.utils.ActitimeUtils;
import com.testng.page.DashboardPage;
import com.testng.page.LoginPage;
import com.testng.page.TasksPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateCustomerTest extends GlobalVariables {

	
	@Given("pom user has all page class Objects")
	public void pom_user_has_all_page_class_objects() {
		driver = ActitimeUtils.getDriver("ff");
		loginPage = new LoginPage(driver);
		dbPage = new DashboardPage(driver);
		tasksPage = new TasksPage(driver);
		
		
	}
	
	@Given("pom user is on login page")
	public void pom_user_is_on_login_page() {
		driver.get("http://localhost/login.do");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Login");
	}

	@Given("pom user login to the applciation")
	public void pom_user_login_to_the_applciation() {
		loginPage.login("admin", "manager");
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
	}

	@When("pom user click on tasks tab")
	public void pom_user_click_on_tasks_tab() {
		dbPage.clickOnTasks();
	}

	@Then("pom user is navigated to tasks page")
	public void pom_user_is_navigated_to_tasks_page() {
		// handled validation in above function
	}

	@When("pom user click on new customer")
	public void pom_user_click_on_new_customer() {
		tasksPage.clickOnNewCustomerButton();
	}

	@When("pom user enter valid {} and {}")
	public void pom_user_enter_valid_cucumber_customer2_and_cucumber_customer_desc1(String cn, String cd) {
		tasksPage.createCustomer(cn, cd);
	}

	@Then("success message should be disaplyed")
	public void success_message_should_be_disaplyed() {
		// handled in above function 
	}

	@Then("pom user logout after validating success message")
	public void pom_user_logout_after_validating_success_message() {
		dbPage.logout();
	}


	@When("pom user enter existing {} and {}")
	public void pom_user_enter_existing_cucumber_customer2_and_cucumber_customer_desc1(String cn, String cd) {
		tasksPage.createExistingCustomer(cn, cd);
	}

	@Then("pom user validates the error message")
	public void pom_user_validates_the_error_message() {
		// handled in above function 
	}

	@Then("pom user logout after clicking on cancel")
	public void pom_user_logout_after_clicking_on_cancel() {
			ActitimeUtils.logout();
	}

}

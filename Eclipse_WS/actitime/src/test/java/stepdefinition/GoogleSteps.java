package stepdefinition;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.synechron.selenium.actitime.utils.DriverUtils;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class GoogleSteps 
{
	WebDriver driver = null;
	List<WebElement> suggestions = null;
	@Given("user is on google/yahoo/rediff (search )page")
	public void user_is_on_google_page() {
		driver = DriverUtils.getDriver();
		
		driver.get("https://www.google.com/");
	}
	
	
	@When("user enter {}")
	public void user_enter(String value) {
		driver.findElement(By.name("q")).sendKeys(value);
	}
	
	
	
	@Then("user is displayed with autosuggestions")
	public void user_is_displayed_with_autosuggestions() {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[li[@role='presentation']]"))));
		
		suggestions = driver.findElements(By.xpath("//ul/li[@role='presentation']//span"));
		
		Assert.assertTrue(suggestions.size() > 1);
	}
	@Then("user print the autosuggestion and close the browser")
	public void user_print_the_autosuggestion() {
		System.out.println("Total Suggestions displayed -> " + suggestions.size());
		
		for (WebElement suggestion : suggestions) 
		{
			System.out.println(suggestion.getText());
		};
		
		driver.close();
	}
	
	@When("click on search")
	public void click_on_search() {
	    // Write code here that turns the phrase above into concrete actions
	 //   throw new io.cucumber.java.PendingException();
	}
	@Then("google display {int} result(s)")
	public void google_display_results(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new io.cucumber.java.PendingException();
	}
	

	
	@When("user search and print autosuggestions")
	public void user_search_and_print_autosuggestions(DataTable dataTable) throws InterruptedException {
			String company,compayDesc;
			List<List<String>> companies = dataTable.asLists();
			
			for (int i = 1; i < companies.size(); i++) {
					company = companies.get(i).get(0);
					compayDesc = companies.get(i).get(1);
					driver.findElement(By.name("q")).sendKeys(company);
					Thread.sleep(2000);
					WebDriverWait wait = new WebDriverWait(driver, 10);
					wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[li[@role='presentation']]"))));
					
					suggestions = driver.findElements(By.xpath("//ul/li[@role='presentation']//span"));
					
					Assert.assertTrue(suggestions.size() > 1);
					System.out.println("Total Suggestions displayed -> " + suggestions.size());
					
					for (WebElement suggestion : suggestions) 
					{
						System.out.println(suggestion.getText());
					};
					
					driver.findElement(By.name("q")).clear();
					Thread.sleep(2000);
			}
			
			
			
//			for (List<String> list : companies) {
//				company = list.get(0);
//			}
	}
	
	@When("user search and print autosuggestions as maps")
	public void user_search_and_print_autosuggestions_as_maps(DataTable dataTable) throws InterruptedException
	{
		String company;
		List<Map<String, String>> companies = dataTable.asMaps();
		
		for (int i = 0; i < companies.size(); i++) {
			company = companies.get(i).get("company");
			driver.findElement(By.name("q")).sendKeys(company);
			Thread.sleep(2000);
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//ul[li[@role='presentation']]"))));
			
			suggestions = driver.findElements(By.xpath("//ul/li[@role='presentation']//span"));
			
			Assert.assertTrue(suggestions.size() > 1);
			System.out.println("Total Suggestions displayed -> " + suggestions.size());
			
			for (WebElement suggestion : suggestions) 
			{
				System.out.println(suggestion.getText());
			};
			
			driver.findElement(By.name("q")).clear();
			Thread.sleep(2000);
		}
		
	}

	
	@When("close the browser")
	public void close_the_browser() {
		driver.close();
	}

	
	
}

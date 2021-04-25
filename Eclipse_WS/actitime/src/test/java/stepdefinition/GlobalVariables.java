package stepdefinition;

import org.openqa.selenium.WebDriver;

import com.testng.page.DashboardPage;
import com.testng.page.LoginPage;
import com.testng.page.TasksPage;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;

public class GlobalVariables {
	
	public static WebDriver driver = null;
	public LoginPage loginPage = null;
	public DashboardPage dbPage = null;
	public TasksPage tasksPage  = null;
	

	
}

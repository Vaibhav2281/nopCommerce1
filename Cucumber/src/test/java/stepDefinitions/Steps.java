package stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.Before;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddcustomerPage;
import pageObjects.LoginPage;
import pageObjects.SearchCustomerPage;

public class Steps extends BaseClass{

//	@Before
//	public void setup() throws IOException {
//		
//		logger=Logger.getLogger("Cucumber");
//		PropertyConfigurator.configure("log4j.properties");
//		
//		
//		//Reading properties
////		configProp = new Properties();
////		FileInputStream configPropFile = new FileInputStream("config.properties");
////		configProp.load(configPropFile);
////		
////		String br = configProp.getProperty("browser");
////		
////		if(br.equals("chrome")) {
////			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
////			driver = new ChromeDriver();
////		}
////		else if (br.equals("edge")) {
////			System.setProperty("webdriver.edgedriver.driver", configProp.getProperty("edgepath"));
////			driver = new EdgeDriver();
////		}
//		
//		//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
//		driver=new ChromeDriver();
//		
//		//logger.info("********** Launching browser ***********");
//	}
	
	
	@Given("User launch chrome browser")
	public void user_launch_chrome_browser() {
		logger=Logger.getLogger("Cucumber");
		PropertyConfigurator.configure("log4j.properties");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers/chromedriver.exe");
		driver=new ChromeDriver();
	    lp = new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) {
		//logger.info("********** Opening URL ***********");
	    driver.get(url);
	    driver.manage().window().maximize();
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		//logger.info("********** Providing login details ***********");
	    lp.setUsername(email);
	    lp.setPassword(password);
	}

	@When("Click on login")
	public void click_on_login() {
		logger.info("********** Started login ***********");
	    lp.clickLogin();
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) throws InterruptedException {
	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    	logger.info("********** Login passed ***********");
	    	driver.quit();
	    	Assert.assertTrue(false);
	    }else {
	    	logger.info("********** Login failed ***********");
			Assert.assertEquals(title, driver.getTitle());
		}
	    Thread.sleep(3000);
	}

	@When("user click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
		logger.info("********** Click on logout link ***********");
	    lp.clickLogout();
	    Thread.sleep(3000);
	}

	@Then("close browser")
	public void close_browser() {
		logger.info("********** Closing browser ***********");
	    driver.quit();
	}
	
	//Customers feature stepDefinitions
	
	@Then("User can view dashboad")
	public void user_can_view_dashboad() {
	    addcust = new AddcustomerPage(driver);
	    Assert.assertEquals("Dashboard / nopCommerce administration", addcust.getPageTitle());
	}

	@When("User clicks on customers menu")
	public void user_clicks_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
	   addcust.clickOnCustomersMenu();
	}

	@When("click on customers menu item")
	public void click_on_customers_menu_item() throws InterruptedException {
		addcust.clickOnCustomersMenuItem();
		Thread.sleep(3000);
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
	    addcust.clickOnAddNew();
	    Thread.sleep(3000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException {
	    Assert.assertEquals("Add a new customer / nopCommerce administration", addcust.getPageTitle());
	    Thread.sleep(3000);
	}

	@When("user enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	    String email = randomString()+"@gmail.com";
	    addcust.setEmail(email);
	    addcust.setPassword("test123");
	    
	    addcust.setCustomersRoles("Guests");
	    Thread.sleep(3000);
	    
	    addcust.setManagerOfVendor("Vendor 2");
	    addcust.setGender("Male");
	    addcust.setFirstName("Vaibhav");
	    addcust.setLastName("Badheka");
	    addcust.setDob("13/02/1992");
	    addcust.setCompanyname("busyQA");
	    addcust.setAdminContent("This is for testing....");
	    Thread.sleep(3000);
	}

	@When("click on save button")
	public void click_on_save_button() throws InterruptedException {
	    addcust.clickOnSave();
	    Thread.sleep(3000);
	}

	@Then("user van view confirmation message {string}")
	public void user_van_view_confirmation_message(String msg) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
	}

	//steps for searching a customer using email id
	
	@When("Enter customer Email")
	public void enter_customer_email() {
	    searchCust=new SearchCustomerPage(driver);
	    searchCust.setEmail("victoria_victoria@nopCommerce.com");
	}

	@When("click on search buttton")
	public void click_on_search_buttton() throws InterruptedException {
	    searchCust.clickSearch();
	    Thread.sleep(3000);
	}

	@Then("User should found Email in search table")
	public void user_should_found_email_in_search_table() {
	    boolean status = searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
	    Assert.assertEquals(true, status);
	}
	
	//steps for searching a customer using first name and last name
	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() {
	    searchCust=new SearchCustomerPage(driver);
	    searchCust.setFirstName("Victoria");
	}

	@When("Enter customer LastName")
	public void enter_customer_last_name() {
	    searchCust.setLastName("Terces");
	}


	@Then("user should found name in search table")
	public void user_should_found_name_in_search_table() {
	    boolean status=searchCust.searchCustomerByName("Victoria Terces");
	    Assert.assertEquals(true, status);
	}
}

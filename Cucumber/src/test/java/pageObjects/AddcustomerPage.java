package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {

public WebDriver lDriver;
	
	public AddcustomerPage(WebDriver rDriver) {
		lDriver = rDriver;
		PageFactory.initElements(lDriver, this);
	} 
	
	By lnkCustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkCustomers_menuitemBy = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),'Customers')]");
	
	By btnAddnewBy = By.xpath("/html/body/div[3]/div[1]/form[1]/div/div/a");
	
	By txtEmail = By.xpath("//*[@id=\"Email\"]");
	By txtPassword = By.xpath("//*[@id=\"Password\"]");
	
	By txtcustomerRoles = By.xpath("//*[@id=\"customer-info\"]/div[2]/div[10]/div[2]/div/div[1]/div/span/span[1]/span/ul");
	By txtcustomerRolesDefaultItem=By.xpath("//span[@class='select2-selection__choice__remove']");
	
	By lstitemAdministrators = By.xpath("//li[contains(text(),'Administrators')]");
	By lstitemModerators = By.xpath("//li[contains(text(),'Forum Moderators')]");
	By lstitemRegistered = By.xpath("//li[contains(text(),'Registered')]");
	By lstitemGuests = By.xpath("//li[contains(text(),'Guests')]");
	By lstitemVendors = By.xpath("//li[contains(text(),'Vendors')]");
	
	By drpmgrOfVendor = By.xpath("//*[@id='VendorId']");
	
	By rdMaleGender = By.id("Gender_Male");
	By rdFeMaleGender = By.id("Gender_Female");
	
	By txtFirstname = By.xpath("//input[@id='FirstName']");
	By txtLastname = By.xpath("//input[@id='LastName']");
	
	By txtDob = By.xpath("//input[@id='DateOfBirth']");
	
	By txtCompanyName = By.xpath("//input[@id='Company']");
	
	By txtAdminContent = By.xpath("//textarea[@id='AdminComment']");
	
	By btnSave = By.xpath("//button[@name='save']");
	
	//Action Methods
	
	public String getPageTitle() {
		return lDriver.getTitle();
	}
	
	public void clickOnCustomersMenu() {
		lDriver.findElement(lnkCustomers_menu).click();
	}
	
	public void clickOnCustomersMenuItem() {
		lDriver.findElement(lnkCustomers_menuitemBy).click();
	}
	
	public void clickOnAddNew() {
		lDriver.findElement(btnAddnewBy).click();
	}
	
	public void setEmail(String email) {
		lDriver.findElement(txtEmail).sendKeys(email);
	}
	
	public void setPassword(String password) {
		lDriver.findElement(txtPassword).sendKeys(password);
	}
	
	public void setCustomersRoles(String role) throws InterruptedException {
		
		lDriver.findElement(txtcustomerRoles).click();
		
		WebElement listitem;
		
		Thread.sleep(3000);
		
		if(role.equals("Administrators")) {
			listitem=lDriver.findElement(lstitemAdministrators);
		}
		else if (role.equals("Guests")) {
			lDriver.findElement(txtcustomerRolesDefaultItem).click();
			lDriver.findElement(txtcustomerRoles).click();
			listitem=lDriver.findElement(lstitemGuests);
		}
		else if (role.equals("Registered")) {
			listitem=lDriver.findElement(lstitemRegistered);
		}
		else if (role.equals("Vendors")) {
			listitem=lDriver.findElement(lstitemVendors);
		}
		else if (role.equals("Forum Moderators")) {
			listitem=lDriver.findElement(lstitemModerators);
		}
		else {
			listitem=lDriver.findElement(lstitemGuests);
		}
		
		listitem.click();
		//Thread.sleep(3000);
		
		//JavascriptExecutor js = (JavascriptExecutor) lDriver;
		//js.executeScript("arguments[0].click();", listitem);
	}
	
	public void setManagerOfVendor(String value) {
		
		Select drp = new Select(lDriver.findElement(drpmgrOfVendor));
		drp.selectByVisibleText(value);
		}
	
	public void setGender(String gender) {
		if(gender.equals("Male")){
			lDriver.findElement(rdMaleGender).click();
		}else if (gender.equals("Female")) {
			lDriver.findElement(rdFeMaleGender).click();
		}else {
			lDriver.findElement(rdMaleGender).click();
		}
	}
	
	public void setFirstName(String fname) {
		lDriver.findElement(txtFirstname).sendKeys(fname);
	}
	
	public void setLastName(String lname) {
		lDriver.findElement(txtLastname).sendKeys(lname);
	}
	
	public void setDob(String dob) {
		lDriver.findElement(txtDob).sendKeys(dob);
	}
	
	public void setCompanyname(String comname) {
		lDriver.findElement(txtCompanyName).sendKeys(comname);
	}
	
	public void setAdminContent(String content) {
		lDriver.findElement(txtAdminContent).sendKeys(content);
	}
	
	public void clickOnSave() {
		lDriver.findElement(btnSave).click();
	}
}

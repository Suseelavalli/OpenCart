package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
	 
	public HomePage(WebDriver driver) {
		 super(driver);
	}
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement clkAcc;
	

	@FindBy(xpath="//a[normalize-space()='Register']")
	WebElement clkRegister;
	
	@FindBy(xpath="//ul[@class='dropdown-menu dropdown-menu-right']/li[2]")
	WebElement clkLogin;
	
	public void Click_MyAccount() {
		clkAcc.click();
	}
	
	public void Click_Register() {
		clkRegister.click();
	}
	
	public void ClickLogin() {
		clkLogin.click();
	}
}

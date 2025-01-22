package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@id='input-firstname']")
	WebElement firstName;
	
	@FindBy(xpath="//input[@id='input-lastname']")
	WebElement lastName;
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement mail;
	
	@FindBy(xpath="//input[@id='input-telephone']")
	WebElement phoneNum;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath="//input[@id='input-confirm']")
	WebElement confpassword;
	
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkprivacy;
	
	@FindBy(xpath="//input[@value='Continue']")
	WebElement clkcontinue;
	
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement confmsg;
	
	public void setfirstName(String f_name) {
		firstName.sendKeys(f_name);
	}
	
	public void setlastName(String l_name) {
		lastName.sendKeys(l_name);
	}
	
	public void setEmail(String e_mail) {
		mail.sendKeys(e_mail);
	}
	
	public void setPhoneNumber(String ph_num) {
		phoneNum.sendKeys(ph_num);
	}
	
	public void setPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String confpwd) {
		confpassword.sendKeys(confpwd);
	}
	
	public void ClickChkPrivacy() {
		chkprivacy.click();
	}
	
	public void ClickContinue() {
		clkcontinue.click();
	}
	
	public String getConfirmationMsg() {
		try {
		return (confmsg.getText());
		}
		catch(Exception e) {
			return (e.getMessage());
		}
	}

	
}

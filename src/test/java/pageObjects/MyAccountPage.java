package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[normalize-space()='My Account']") // MyAccount Page heading
	WebElement MyaccHeading;

	@FindBy(xpath = "//div[@class='list-group']/a[13]")
	WebElement clklogout;

	public boolean IsMyAccountHeadingExists() {

		try {
			return (MyaccHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}

	}

	public void ClickLogout() {
		clklogout.click();
	}

}

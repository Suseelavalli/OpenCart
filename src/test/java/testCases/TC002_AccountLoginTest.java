package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_AccountLoginTest extends BaseClass {
	
	@Test(groups={"Regression","Master"})
	public void verify_Login() {
		
		logger.info("****Starting TC002_AccountLoginTest****");
		
		try {
		//HomePage
		HomePage hp=new HomePage(driver);
		hp.Click_MyAccount();
		hp.ClickLogin();
		
		//LoginPage
		LoginPage lp= new LoginPage(driver);
		lp.setEmail(p.getProperty("email")); //Getting from config.properties file
		lp.setPassword(p.getProperty("password"));           //Getting from config.properties file
		lp.ClickLogin();
		
		//MyAccountPage
		
		MyAccountPage myac= new MyAccountPage(driver);
		boolean targetPage=myac.IsMyAccountHeadingExists();
		
		Assert.assertEquals(targetPage, true,"Login fail");
		//Assert.assertTrue(targetPage);
		}
		catch(Exception e) 
		{
			Assert.fail();
		}
	
	      logger.info("*** Finished TC002_AccountLoginTest***");
	}
	
}

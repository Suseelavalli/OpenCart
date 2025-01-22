package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class, groups="DataDriven") // getting dataprovider class form different class
	public void verify_LoginDDT(String email, String pwd, String exp) {

		logger.info("*** Starting TC003_LoginDDT*** ");

		try {
			// HomePage
			HomePage hp = new HomePage(driver);
			hp.Click_MyAccount();
			hp.ClickLogin();

			// LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email); // Getting from config.properties file
			lp.setPassword(pwd); // Getting from config.properties file
			lp.ClickLogin();

			// MyAccountPage

			MyAccountPage myac = new MyAccountPage(driver);
			boolean targetPage = myac.IsMyAccountHeadingExists();

			
			/*  Data is valid - login success-test pass-logout 
			                  login failed- test fail
			  
			  Data is invalid-login success-test fail- logout 
			                  login fail-test pass
			 */
			 

			if (exp.equalsIgnoreCase("Valid"))
			{
				if (targetPage == true)
				{
					myac.ClickLogout();
					Assert.assertTrue(true);
					
				} else
				{
					Assert.assertTrue(false);
				}
				
			}else
			{
				myac.ClickLogout();
				Assert.assertTrue(false);
			}


			/*if (exp.equalsIgnoreCase("Invalid")) 
			{
				if (targetPage == true)
				{
					myac.ClickLogout();
					Assert.assertTrue(false);
				} else
				{
					Assert.assertTrue(true);
				}
			}*/
		} catch (Exception e)
		{
			Assert.fail();
		}

		logger.info("*** Finishing TC003_LoginDDT*** ");
	}

}

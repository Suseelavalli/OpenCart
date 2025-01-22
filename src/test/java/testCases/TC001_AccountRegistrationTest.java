package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.RegistrationPage;
import testBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {
	
	
	@Test(groups= {"Sanity","Master"})
	public void Verify_Account_SignIn() {
	
		logger.info("***Started TC001_AccountRegistrationTest***");
	
	try {
	
	logger.info("---Validating HomePage---");
	HomePage hp = new HomePage(driver);
	hp.Click_MyAccount();
	hp.Click_Register();
	
	logger.info("--Validating Account_Registration---");
	RegistrationPage rp = new RegistrationPage(driver);
	
	rp.setfirstName(randomAlphabet().toUpperCase());
	rp.setlastName(randomAlphabet().toUpperCase());
	rp.setEmail(randomAlphaNumeric()+"@gmail.com");
	rp.setPhoneNumber(randomNumberic());
	
	String password = randomAlphaNumeric();
	rp.setPassword(password);
	rp.setConfirmPassword(password);
	
	rp.ClickChkPrivacy();
	rp.ClickContinue();
	
	logger.info("--Validating expected message---");
	
	String confmsg= rp.getConfirmationMsg();
	if(confmsg.equals("Your Account Has Been Created!"))
	{
		Assert.assertTrue(true);
	}
	else
	{
		logger.error("Test failed...");
		logger.atDebug();
		Assert.assertTrue(false);
	}
	}
		catch(Exception e) 
		{
			
			Assert.fail();
		}
		
		logger.info("*** Finished TC001_AccountRegistrationTest *** ");
	}
}

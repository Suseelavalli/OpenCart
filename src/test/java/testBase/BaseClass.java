package testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;  //log4j
import org.apache.logging.log4j.Logger;  //log4j
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class BaseClass {

	public static WebDriver driver;
	public  Logger logger;  //log4j
    public Properties p;
    
	@BeforeClass(groups= {"Sanity","Regression","DataDriven","Master"})
	@Parameters({"os","browser"})
	public void setup(String os,String br) throws IOException {   
		
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\config.properties");
		p=new Properties();
		p.load(file);
		
		logger=LogManager.getLogger(this.getClass());  //log4j2
		
		if(p.getProperty("execution_env").equals("remote"))
		{
			DesiredCapabilities dcap= new DesiredCapabilities();
			
			//os
			if(os.equalsIgnoreCase("windows"))
			{
				dcap.setPlatform(Platform.WIN11);
				
			}else if(os.equalsIgnoreCase("mac"))
			{
				dcap.setPlatform(Platform.MAC);
			}else
			{
				System.out.println("No matching os found");
				return;
			}
			
			//browser
			switch(br.toLowerCase())
			{
			case "chrome": dcap.setBrowserName("chrome");break;
			case "edge": dcap.setBrowserName("Edge");break;
			case "firefox": dcap.setBrowserName("firefox");break;
			default :System.out.println("Browser not found..");return;
			}
			
			driver = new RemoteWebDriver(new URL("http://192.168.29.179:4444/wd/hub"),dcap);
		}
		
		if(p.getProperty("execution_env").equalsIgnoreCase("local"))
		{
			switch(br.toLowerCase())
			{
			case "chrome": driver = new ChromeDriver();break;
			case "edge": driver = new EdgeDriver();break;
			case "firefox": driver = new FirefoxDriver();break;
			default :System.out.println("Browser not found..");return;
			}
		}
		
		//driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//driver.get("https://tutorialsninja.com/demo/");
		driver.get(p.getProperty("appURL1"));
		driver.manage().window().maximize();
	}
	
	@AfterClass(groups= {"Sanity","Regression","DataDriven","Master"})
	public void tearDown() {
		if (driver != null) {
            driver.quit();
        }
		//driver.quit();
	}
	
	public String randomAlphabet() {
		String generateString=RandomStringUtils.randomAlphabetic(7);
		return generateString;
	}
	
	public String randomAlphaNumeric() {
		String generateAlpha= RandomStringUtils.randomAlphabetic(5);
		String generateNum =RandomStringUtils.randomNumeric(3);
		return (generateAlpha+generateNum);		
	}
	
	public String randomNumberic() {
		String generateNum= RandomStringUtils.randomNumeric(10);
		return generateNum;
	}
	
	public String captureScreen(String tname) {
		
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
		TakesScreenshot takesScreenshot =(TakesScreenshot) driver;
		File sourceFile= takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\"+tname+"_"+timeStamp+".png";
		File targetFile =new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
		
		return targetFilePath;
				
	}
}


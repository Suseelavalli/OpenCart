package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException{
		
		String path =".\\testData\\Opencart-Login.xlsx"; //taking xl file from testData
		
		ExcelUtility xlutil= new ExcelUtility(path);  //creating an object for xlutility
		
		int totalrows = xlutil.getRowCount("login");
		int totalcols = xlutil.getCellCount("login", 1);
		
		String logindata[][]= new String[totalrows][totalcols];  //created for 2 dimension array which can store
		
		for(int r=1;r<=totalrows;r++)
		{
			for(int c=0;c<totalcols;c++)
			{
				logindata[r-1][c]=xlutil.getCellData("login", r, c);
			}
		}
		return logindata;
	}
	
	
	//DataProvider 2
	//DataProvider 3
	//DataProvider 4

}

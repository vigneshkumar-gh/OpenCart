package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException{
		String path = ".\\testData\\data.xlsx";
		ExcelUtility xlFile = new ExcelUtility(path);
		
		int rows = xlFile.noOfRows("Sheet1");
		int cells = xlFile.noOfCells("Sheet1", 1);
		
		
		String loginData[][] = new String[rows][cells];
		
		for(int i = 1; i <= rows; i++) 
		{
			for(int j = 0; j < cells;j++) 
			{
				loginData[i-1][j] = xlFile.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}
}

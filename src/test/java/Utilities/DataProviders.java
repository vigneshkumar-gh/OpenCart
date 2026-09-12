package Utilities;

import java.io.IOException;


import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "LoginData")
	public String[][] getLoginData() throws IOException{
		String path = ".\\testData\\LoginData.xlsx";
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
	
	@DataProvider(name = "ProductData")
	public String[][] getProductData() throws IOException{
		String path = ".\\testData\\DataOfProduct.xlsx";
		ExcelUtility xlFile = new ExcelUtility(path);
		
		int rows = xlFile.noOfRows("Sheet2");
		int cells = xlFile.noOfCells("Sheet2", 1);
		
		System.out.println("Row number: " + rows);

		String loginData[][] = new String[rows][cells];
		
		for(int i = 1; i <= rows; i++) 
		{
			for(int j = 0; j < cells;j++) 
			{
				loginData[i-1][j] = xlFile.getCellData("Sheet2", i, j);
			}
		}
		return loginData;
	}
	
	
	
	
	
	
	
	
}

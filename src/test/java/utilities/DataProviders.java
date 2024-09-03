package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

	
	@DataProvider(name="LoginData")
	public String [][]getData() throws IOException{
		
		String path =".\\testData\\Opencart_LoginData.xlsx";//taking xl file from testData
		 ExcelUtility xlutil= new ExcelUtility(path);//create an object of excelutility class
		 int totalrows = xlutil.getRowCount("Sheet1");
		 int totalcols = xlutil.getCellCount("Sheet1", 1);
		 
		 String [][]loginData = new String [totalrows][totalcols];//created a two dimensional array which can store the values from xl
		 
		   for(int i=1;i<=totalrows;i++) {//1 //read the data from xl storing in two dimensional array
			   
			   for(int j=0;j<totalcols;j++) {//0 //i is row j is col
				   
				   loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);//1,0
			   }
		   }
		
		
		
		
		return loginData;//returning two dimensional array
		
	}
	

}

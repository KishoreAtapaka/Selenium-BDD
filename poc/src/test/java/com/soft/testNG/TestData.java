package com.soft.testNG;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class TestData {
	@DataProvider(name="LoginData")	
	public static Object[][] testData() throws IOException {		
		FileInputStream fis=new FileInputStream(new File("./data/Sample.xlsx"));
		XSSFWorkbook wb=new XSSFWorkbook(fis);		
		XSSFSheet sh=wb.getSheetAt(0);		
		XSSFRow r=sh.getRow(0);
		Object[][] data=new Object[sh.getLastRowNum()][r.getLastCellNum()];
		for(int i=1;i<=sh.getLastRowNum();i++){
			XSSFRow rw=sh.getRow(i);
			for(int j=0;j<rw.getLastCellNum();j++){
				XSSFCell cl=rw.getCell(j);
				data[i-1][j]=cl.getStringCellValue();
			}
		}
		fis.close();

		return data;

	}  


}
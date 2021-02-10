package testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Dataone {

static String datas[][];	
public static Object[][] getas(String sheetname,String Keyword) throws IOException,NullPointerException {
		
		FileInputStream fis = new FileInputStream(new File(sheetname));
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		try{
	XSSFSheet sheet = workbook.getSheetAt(0);	
	int rowCount = sheet.getLastRowNum();
	int colom ;
	for(int i=1; i <rowCount; i++){
			XSSFRow row = sheet.getRow(i);
			String a=row.getCell(0).getStringCellValue();
			if(a.equalsIgnoreCase(Keyword)) {
colom =row.getLastCellNum(); 
 datas = new String[rowCount][colom];

for (int j = 0; j <colom; j++) {
	String cellval=row.getCell(j).getStringCellValue();

	System.out.println(cellval);
	datas[0][j]  = cellval;


}
		 

			}
			
		}


	}

		catch (Exception e) {
		// TODO: handle exception
	}
		workbook.close();	
			
	
	
	


//	System.out.println(data.length);





	return datas;				
}


}
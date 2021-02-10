package utils;


import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Datats{
	static String[][] data = null;
		public static String[][] getAllSheetData(String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(new File(sheetName));
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
	XSSFSheet sheet = workbook.getSheetAt(0);	
			int rowCount = sheet.getLastRowNum();
			for(int i=1; i <rowCount+1; i++){
					XSSFRow row = sheet.getRow(i);
					if(row.getCell(0).getStringCellValue().equalsIgnoreCase("c")){
System.out.println(row.getCell(0).getStringCellValue());
int b=row.getLastCellNum();
data = new String[rowCount][b];
					for(int j=0; j <row.getLastCellNum(); j++){ // loop through the columns
							String cellValue = "";
									cellValue = row.getCell(j).getStringCellValue();
								System.out.println(cellValue);
							data[0][j]  = cellValue; 
							System.out.println("!!!!!!!!111");
							System.out.println(data[0][j]);
							System.out.println("!!!!!!!!111");
						} 
				break;
					}
			}
			workbook.close();
		} catch (Exception e) {
 			e.printStackTrace();
		}

		return data;

		
		
	}


}





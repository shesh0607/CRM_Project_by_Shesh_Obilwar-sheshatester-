package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	public String getExcelData(String sheet,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream fs=new FileInputStream("./src/test/resources/VTExcel.xlsx");
		Workbook book=WorkbookFactory.create(fs);
		Sheet sh=book.getSheet(sheet) ;
		Row row=sh.getRow(rowNum);
		Cell cel=row.getCell(cellNum);
		
		String Data=cel.getStringCellValue();
		return Data;
	}
	
	public String getExcelUsingDataFormatter(String sheet,int rowNum, int cellNum) throws EncryptedDocumentException, IOException
	{
		FileInputStream fs=new FileInputStream("./src/test/resources/VTExcel.xlsx");
		Workbook book=WorkbookFactory.create(fs);
		DataFormatter format=new DataFormatter();
		String ExcelData=format.formatCellValue(book.getSheet(sheet).getRow(rowNum).getCell(cellNum));
		return ExcelData;
	}
}

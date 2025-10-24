package no.nocrm.crm.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * @author Manikandan
 * this class contains excel file utility
 */
public class ExcelFileUtility {

	
	/**
	 * this method is used to fetch data from excel
	 * @param sheetname
	 * @param rownum
	 * @param columnnum
	 * @return
	 * @throws Throwable
	 * @throws Throwable
	 */
	public String getDataFromExcelFile(String sheetname,int rownum,int columnnum) throws Throwable, Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/test_data/TestScriptData.xlsx");
	    Workbook wb = WorkbookFactory.create(fis);
		String data = wb.getSheet(sheetname).getRow(rownum).getCell(columnnum).toString();
		wb.close();
		return data;
	}

	/**
	 * this method is used to get the row count
	 * @param sheetname
	 * @return
	 * @throws Throwable
	 */
	public int getRowCount(String sheetname) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/test_data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rownum = wb.getSheet(sheetname).getLastRowNum();
		fis.close();
		wb.close();
		return rownum;

	}

	/**
	 * this method is used to write data back to excel
	 * @param sheetname
	 * @param rownum
	 * @param value
	 * @param cellnum
	 * @throws Throwable
	 */
	public void getWriteDataToExcel(String sheetname,int rownum,String value,int cellnum) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/test_data/TestScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Cell cl = wb.getSheet(sheetname).getRow(rownum).createCell(cellnum, CellType.STRING);
		cl.setCellValue(value);
		FileOutputStream fos = new FileOutputStream("./test_data/TestScriptData.xlsx");
		wb.write(fos);
		fos.close();
		fis.close();
		wb.close();

	}
}

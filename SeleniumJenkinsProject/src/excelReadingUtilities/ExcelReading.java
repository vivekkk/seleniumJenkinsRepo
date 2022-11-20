package excelReadingUtilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	public XSSFWorkbook getWorkbook() {
		return workbook;
	}

	public void setWorkbook(XSSFWorkbook workbook) {
		this.workbook = workbook;
	}

	public static FileInputStream getFis() {
		return fis;
	}

	public static void setFis(FileInputStream fis) {
		ExcelReading.fis = fis;
	}

	public XSSFSheet getSheet() {
		return sheet;
	}

	public void setSheet(XSSFSheet sheet) {
		this.sheet = sheet;
	}

	public XSSFRow getRow() {
		return row;
	}

	public void setRow(XSSFRow row) {
		this.row = row;
	}

	public XSSFCell getCell() {
		return cell;
	}

	public void setCell(XSSFCell cell) {
		this.cell = cell;
	}

	private XSSFWorkbook workbook;
	private static FileInputStream fis;
	private XSSFSheet sheet;
	private XSSFRow row;
	private XSSFCell cell;

	public ExcelReading(String fileString) throws Throwable {
		File file = new File(fileString);
		fis = new FileInputStream(file);
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheetAt(0);
		row = sheet.getRow(0);
		cell = row.getCell(0);

	}

	public String getData(String sheetName, int rowCount, int columnCount) throws IOException {
		String data;
		if (sheetName != null) {
			sheet = workbook.getSheet(sheetName);
		} else {
			sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());
		}

		if (rowCount > getTotalrowNumb() - 1 || columnCount > getTotalcolNum() - 1) {
			data = "";
		} else {
			XSSFRow row = sheet.getRow(rowCount);
			XSSFCell cell = row.getCell(columnCount);
			data = cell.getStringCellValue();

		}

		return data;

	}

	public String getData(int sheetNum, int rowCount, int columnCount) throws IOException {
		String data;
		if (sheetNum >= 0) {
			sheet = workbook.getSheetAt(sheetNum);
		} else {
			sheet = workbook.getSheetAt(workbook.getActiveSheetIndex());
		}

		if (rowCount > getTotalrowNumb() - 1 || columnCount > getTotalcolNum() - 1) {
			data = "";
		} else {
			XSSFRow row = sheet.getRow(rowCount);
			XSSFCell cell = row.getCell(columnCount);
			data = cell.getStringCellValue();

		}

		return data;

	}

	public int getTotalrowNumb() {

		return sheet.getLastRowNum() + 1;

	}

	public int getTotalcolNum() {
		return sheet.getRow(0).getLastCellNum();
	}

	public static void fisclose() {
		try {
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import excelReadingUtilities.ExcelReading;

public class TestCases {

	@Test(dataProvider = "getDataForExec")
	public void testcse01(String name, String place, String thing, String data) throws Throwable {
		System.out.print("This is before suite test");
		// PagesMasterClass p = new PagesMasterClass();
		System.out.println(name + "--" + place + "--" + thing + "--" + data);

	}

	@Test
	public void testcase02() {
		// new HomePage().logininApp();
		System.out.println("In test case02");

	}

	@Test
	public void testcase03() {

	}

	@DataProvider
	public Object[][] getDataForExec() throws Throwable {
		ExcelReading er = new ExcelReading("D:\\TestExcelForProgram.xlsx");
		System.out.println("In data provider");
		Object[][] obj = new Object[er.getTotalrowNumb()][er.getTotalcolNum()];
		System.out.println("row count" + er.getTotalrowNumb());
		System.out.println("column count" + er.getTotalcolNum());
		try {
			for (int i = 0; i <= er.getTotalrowNumb() - 1; i++) {

				for (int j = 0; j <= er.getTotalcolNum() - 1; j++) {
					obj[i][j] = er.getData(null, i, j);
					// System.out.println(obj[i][j]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}

	// @AfterSuite
	public void closingAct() {
		ExcelReading.fisclose();
	}

}

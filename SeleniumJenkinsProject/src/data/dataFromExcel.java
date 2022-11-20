package data;

import org.testng.annotations.DataProvider;

import excelReadingUtilities.ExcelReading;

public class dataFromExcel {
	@DataProvider(name = "dp1", parallel = true)

	public Object[][] dataProviderForBroser() throws Throwable {
		/*
		 * Object[][] objarr = new Object[2][2]; objarr[0][0] = "firefox"; objarr[0][1]
		 * = "vivek"; objarr[1][0] = "chrome"; objarr[1][1] = "Neha";
		 */

		System.out.println("in the dataproviderforbrowser");
		String path = "D:\\TestExcelForProgram.xlsx";
		ExcelReading er = new ExcelReading(path);
		int rowcount = er.getTotalrowNumb();
		int colcount = er.getTotalcolNum();
		System.out.println("rowcount" + rowcount + " column count" + colcount);
		Object[][] objarr = new Object[rowcount - 1][colcount];
		for (int i = 1; i <= rowcount - 1; i++) {
			for (int j = 0; j < colcount; j++) {
				objarr[i - 1][j] = er.getData(0, i, j);
				System.out.println(objarr[i - 1][j]);

			}
		}
		return objarr;
	}

}

package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import data.dataFromExcel;
import selTestCases.PagesMasterClass;

public class TestCases2 {

	@Test(dataProviderClass = dataFromExcel.class, dataProvider = "dp1")
	void testCase02(String browser, String email) {
		System.out.println(browser);
		PagesMasterClass pg = new PagesMasterClass(browser);
		RemoteWebDriver remoteDriver = pg.getRemoteDriver();
		System.out.println(browser);
		remoteDriver.get("https://www.gmail.com");
		remoteDriver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys(email);

	}

	@Test
	public void simpletest() {
		System.out.println("simple test");
	}
}

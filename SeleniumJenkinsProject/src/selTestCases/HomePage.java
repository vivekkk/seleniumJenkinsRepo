package selTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

	public void logininApp() {
		WebDriver driver = PagesMasterClass.getDriver();
		System.out.println("Inside LoginApp function");
		driver.get("https://www.gmail.com");
		driver.findElement(By.xpath("//input[@id='identifierId']")).sendKeys("vivekkaushik82@gmail.com");

	}

}

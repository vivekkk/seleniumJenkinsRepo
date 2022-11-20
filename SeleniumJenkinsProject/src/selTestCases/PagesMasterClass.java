package selTestCases;

import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PagesMasterClass {

	private static WebDriver driver;
	private RemoteWebDriver remoteDriver;

	public static WebDriver getDriver() {
		return driver;
	}

	public WebDriver setWebdriver(String browser)

	{
		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			// WebDriver driver = new ChromeDriver();
			return driver;

		} else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			WebDriver driver = new FirefoxDriver();
			return driver;
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			WebDriver driver = new EdgeDriver();
			return driver;
		} else
			return null;

	}

	public RemoteWebDriver setRemoteDriver(String browser) {
		try {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setBrowserName(browser);
			cap.setPlatform(Platform.ANY);
			if (browser.equalsIgnoreCase("chrome")) {
				ChromeOptions options = new ChromeOptions();
				options.merge(cap);
			} else if (browser.equalsIgnoreCase("Firefox")) {
				FirefoxOptions options = new FirefoxOptions();
				options.merge(cap);
			}
			RemoteWebDriver remoteDriver = new RemoteWebDriver(new URL("http://localhost:4444/"), cap, false);
			return remoteDriver;
		} catch (Throwable e) {

			e.printStackTrace();
			return null;
		}
	}

	public PagesMasterClass(String browser) {
		System.out.println("inside constructor PageMasterClass");

		this.remoteDriver = setRemoteDriver(browser);

	}

	public RemoteWebDriver getRemoteDriver() {
		System.out.println("Inside get remote driver method");
		return remoteDriver;
	}

}

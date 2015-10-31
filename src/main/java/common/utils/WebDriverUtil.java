package common.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by Lu on 2015/10/31.
 */
public class WebDriverUtil {
	static {
		System.setProperty("webdriver.chrome.driver", "F:\\DevEnvironment\\chromedriver.exe");
	}

	public static WebDriver createChromeDriver() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		return driver;
	}
}

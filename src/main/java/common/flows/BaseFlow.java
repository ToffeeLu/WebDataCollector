package common.flows;

import common.utils.WebDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lu on 2015/10/31.
 */
public abstract class BaseFlow {
	protected WebDriver driver;

	protected void beforeWork() {
		driver = WebDriverUtil.createChromeDriver();
	}

	protected abstract void doWork() throws Exception;

	protected void afterWork() {
		driver.quit();
	}

	public void execute() throws Exception {
		beforeWork();
		doWork();
		afterWork();
	}
}

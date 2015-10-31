package common.flows;

import common.utils.WebDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lu on 2015/10/31.
 */
public class BaseFlow {
	protected WebDriver driver;

	protected void ready() {
		driver = WebDriverUtil.createChromeDriver();
	}

	protected void work() throws Exception {

	}

	protected void end() {
		driver.quit();
	}

	public void execute() throws Exception {
		ready();
		work();
		end();
	}
}

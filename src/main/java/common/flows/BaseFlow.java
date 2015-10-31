package common.flows;

import common.utils.WebDriverUtil;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lu on 2015/10/31.
 */
public abstract class BaseFlow {
	private static Logger logger = Logger.getLogger(BaseFlow.class);

	protected WebDriver driver;

	protected abstract String getDescription();

	protected void beforeWork() {
		driver = WebDriverUtil.createChromeDriver();
	}

	protected abstract void doWork() throws Exception;

	protected void afterWork() {
		driver.quit();
	}

	public void execute() throws Exception {
		logger.info("Work Start: " + getDescription());
		beforeWork();
		doWork();
		afterWork();
		logger.info("Work End: " + getDescription());
	}
}

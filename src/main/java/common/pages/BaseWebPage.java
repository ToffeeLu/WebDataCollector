package common.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

/**
 * Created by Lu on 2015/10/31.
 */
public abstract class BaseWebPage {
	private static Logger logger = Logger.getLogger(BaseWebPage.class);

	protected WebDriver driver;

	public BaseWebPage(WebDriver driver) {
		this.driver = driver;
	}

	protected abstract void initControls();

	public void initPage() {
		initControls();
	}
}

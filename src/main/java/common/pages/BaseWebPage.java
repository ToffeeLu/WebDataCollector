package common.pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by Lu on 2015/10/31.
 */
public abstract class BaseWebPage {
	protected WebDriver driver;

	public BaseWebPage(WebDriver driver) {
		this.driver = driver;
	}

	protected abstract void initControls();

	public void initPage() {
		initControls();
	}
}

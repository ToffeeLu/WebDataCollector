package dzdp.pages;

import common.pages.BaseWebPage;
import dzdp.entities.ShopComponent;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * dzdp keyword search result page with specified city
 *
 * @author ToffeeLu on 2015/10/31.
 */
public class SearchResultPage extends BaseWebPage {
	private static Logger logger = Logger.getLogger(SearchResultPage.class);

	private List<ShopComponent> shops;
	private String cityName;
	private Integer pageCount;

	public SearchResultPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		shops = new ArrayList<ShopComponent>();
	}

	public void initControls() {
		cityName = driver.findElement(ControlDefinition.city).getText();
		logger.debug("get city name: " + cityName);

		try {
			pageCount = Integer.valueOf(driver.findElement(ControlDefinition.lastPage).getText());
		} catch (Exception e) {
			pageCount = 1;
		}
		logger.debug("get page count: " + pageCount);

		List<WebElement> shopComponents = driver.findElements(ControlDefinition.components);
		for (WebElement shopComponent : shopComponents) {
			ShopComponent shop = new ShopComponent(shopComponent);
			shops.add(shop);
			logger.debug("get shop:\n" + shop.toString());
		}
	}

	private static class ControlDefinition {
		public static By city = By.xpath("//a[@class='city J-city']");
		public static By lastPage = By.xpath("//div[@class='page']/a[last()-1]");
		public static By components = By.xpath("//div[@id='shop-all-list']//div[@class='txt']");
	}

	public boolean isEmpty() {
		return shops.isEmpty();
	}

	public int getPageCount() {
		return pageCount;
	}

	public String getCityName() {
		return cityName;
	}

	public List<ShopComponent> getShops() {
		return shops;
	}
}

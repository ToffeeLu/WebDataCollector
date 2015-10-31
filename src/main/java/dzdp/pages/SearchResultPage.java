package dzdp.pages;

import dzdp.entities.ShopComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * dzdp keyword search result page with specified city
 * @author ToffeeLu on 2015/10/31.
 */
public class SearchResultPage {
	private WebDriver driver;

	private List<ShopComponent> shops;
	private String cityName;
	private Integer pageCount;

	public SearchResultPage(WebDriver driver) {
		this.driver = driver;
		shops = new ArrayList<ShopComponent>();
	}

	public void initPage() {
		cityName = driver.findElement(ControlDefinition.city).getText();

		try {
			pageCount = Integer.valueOf(driver.findElement(ControlDefinition.lastPage).getText());
		} catch (Exception e) {
			pageCount = 1;
		}

		List<WebElement> shopComponents = driver.findElements(ControlDefinition.components);
		for (WebElement shopComponent : shopComponents) {
			ShopComponent shop = new ShopComponent(shopComponent);
			System.out.println(shop.toString());
			shops.add(shop);
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

package dzdp.entities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Lu on 2015/10/31.
 */
public class ShopComponent {
	public String title = "N/A";
	public String starCount = "N/A";
	public String commentCount = "N/A";
	public String averageCost = "N/A";
	public String addressTag = "N/A";
	public String address = "N/A";

	/**
	 * init shop component
	 *
	 * @param element should be "//div[@id='shop-all-list']//div[@class='txt']"
	 */
	public ShopComponent(WebElement element) {
		try {
			title = element.findElement(ControlDefinition.title).getText();
		} catch (Exception e) {
		}
		try {
			starCount = element.findElement(ControlDefinition.starCount).getAttribute("title");
		} catch (Exception e) {
		}
		try {
			commentCount = element.findElement(ControlDefinition.commentCount).getText();
		} catch (Exception e) {
		}
		try {
			averageCost = element.findElement(ControlDefinition.averageCost).getText();
		} catch (Exception e) {
		}
		try {
			addressTag = element.findElement(ControlDefinition.addressTag).getText();
		} catch (Exception e) {
		}
		try {
			address = element.findElement(ControlDefinition.address).getText();
		} catch (Exception e) {
		}
	}

	private static class ControlDefinition {
		public static By title = By.xpath(".//div[@class='tit']//h4");
		public static By starCount = By.xpath(".//div[@class='comment']/span");
		public static By commentCount = By.xpath(".//div[@class='comment']/a[@class='review-num']/b");
		public static By averageCost = By.xpath(".//div[@class='comment']/a[@class='mean-price']/b");
		public static By addressTag = By.xpath(".//div[@class='tag-addr']/a[2]//span[@class='tag']");
		public static By address = By.xpath(".//div[@class='tag-addr']//span[@class='addr']");
	}


	private static final String toFormat = "title: %s;\nstarCount: %s;\ncommentCount: %s;\naverageCost: %s;\naddressTag: %s;\naddress: %s;\n";

	@Override
	public String toString() {
		return String.format(toFormat, title, starCount, commentCount, averageCost, addressTag, address);
	}

}

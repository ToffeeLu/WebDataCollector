package dzdp.flows;

import common.flows.BaseFlow;
import dzdp.entities.ShopComponent;
import dzdp.pages.SearchResultPage;
import dzdp.utils.ExcelReportUtil;
import dzdp.utils.UrlUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * get all shops' info from dzdp keyword search result in specified cities
 * @author ToffeeLu on 2015/10/31.
 */
public class KeyWordSearchFlow extends BaseFlow {
	private String keyword;
	private int startCityIndex;
	private int endCityIndex;

	public KeyWordSearchFlow(String keyword, int startCityIndex, int endCityIndex) {
		this.keyword = keyword;
		this.startCityIndex = startCityIndex;
		this.endCityIndex = endCityIndex;
	}

	@Override
	public void work() throws Exception {
		for (int j = startCityIndex; j <= endCityIndex; j++) {
			driver.navigate().to(UrlUtil.generateSearchResultUrl(j, keyword, 1));

			SearchResultPage page = new SearchResultPage(driver);
			page.initPage();

			if (page.isEmpty()) {
				continue;
			}
			int pageCount = page.getPageCount();
			String cityName = page.getCityName();

			List<ShopComponent> shops = new ArrayList<ShopComponent>();
			for (int currentPage = 1; currentPage <= pageCount; currentPage++) {
				driver.navigate().to(UrlUtil.generateSearchResultUrl(j, keyword, currentPage));
				page = new SearchResultPage(driver);
				page.initPage();

				shops.addAll(page.getShops());
			}

			ExcelReportUtil.generateSearchResultExcel(keyword, cityName, shops);
		}
	}
}

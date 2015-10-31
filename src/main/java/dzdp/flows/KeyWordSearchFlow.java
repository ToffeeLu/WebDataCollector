package dzdp.flows;

import common.flows.BaseFlow;
import dzdp.entities.ShopComponent;
import dzdp.pages.SearchResultPage;
import dzdp.utils.ExcelReportUtil;
import dzdp.utils.UrlUtil;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * get all shops' info from dzdp keyword search result in specified cities
 *
 * @author ToffeeLu on 2015/10/31.
 */
public class KeyWordSearchFlow extends BaseFlow {
	private static Logger logger = Logger.getLogger(KeyWordSearchFlow.class);

	private String keyword;
	private int startCityIndex;
	private int endCityIndex;

	public KeyWordSearchFlow(String keyword, int startCityIndex, int endCityIndex) {
		this.keyword = keyword;
		this.startCityIndex = startCityIndex;
		this.endCityIndex = endCityIndex;
	}

	@Override
	protected String getDescription() {
		return "get all shops' info from page to page, city to city";
	}

	@Override
	public void doWork() throws Exception {
		for (int j = startCityIndex; j <= endCityIndex; j++) {
			logger.info("start city index:" + j);
			driver.navigate().to(UrlUtil.generateSearchResultUrl(j, keyword, 1));

			SearchResultPage page = new SearchResultPage(driver);
			page.initPage();
			int pageCount = page.getPageCount();
			String cityName = page.getCityName();

			if (page.isEmpty()) {
				logger.info("no shop found in " + cityName);
				continue;
			}

			List<ShopComponent> shops = new ArrayList<ShopComponent>();
			for (int currentPage = 1; currentPage <= pageCount; currentPage++) {
				logger.info("start page index: " + currentPage);
				driver.navigate().to(UrlUtil.generateSearchResultUrl(j, keyword, currentPage));
				page = new SearchResultPage(driver);
				page.initPage();

				shops.addAll(page.getShops());
			}

			ExcelReportUtil.generateSearchResultExcel(keyword, cityName, shops);
		}
	}
}

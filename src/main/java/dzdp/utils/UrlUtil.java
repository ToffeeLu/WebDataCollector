package dzdp.utils;

import org.apache.log4j.Logger;

/**
 * Created by Lu on 2015/10/31.
 */
public class UrlUtil {
	private static Logger logger = Logger.getLogger(UrlUtil.class);

	private static final String urlToFormat = "http://www.dianping.com/search/keyword/%s/0_%s/p%s";

	public static String generateSearchResultUrl(int cityIndex, String keyword, int pageIndex) {
		String url = String.format(urlToFormat, cityIndex, keyword, pageIndex);
		logger.info("url generated: " + url);
		return url;
	}
}

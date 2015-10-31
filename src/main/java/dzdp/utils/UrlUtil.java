package dzdp.utils;

/**
 * Created by Lu on 2015/10/31.
 */
public class UrlUtil {
	private static final String url = "http://www.dianping.com/search/keyword/%s/0_%s/p%s";

	public static String generateSearchResultUrl(int cityIndex, String keyword, int pageIndex) {
		return String.format(url, cityIndex, keyword, pageIndex);
	}
}

import dzdp.utils.UrlUtil;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Lu on 2015/10/31.
 */
public class UtilTest {
	@Test
	public void StringFormatTest() {
		String url = UrlUtil.generateSearchResultUrl(1, "中文", 2);
		Assert.assertEquals(url, "http://www.dianping.com/search/keyword/1/0_中文/p2");
	}

	private static Logger logger = Logger.getLogger(UrlUtil.class);

	@Test
	public void Log4JTest() {
		BasicConfigurator.configure();
		logger.info("123");
	}
}

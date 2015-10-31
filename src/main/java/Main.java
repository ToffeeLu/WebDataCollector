import dzdp.flows.KeyWordSearchFlow;
import org.apache.log4j.Logger;

/**
 * Created by zhlu on 10/27/2015.
 */
public class Main {

	private static Logger logger = Logger.getLogger(Main.class);

	public static void main(String args[]) throws Exception {
		logger.info("start dzdp");
		KeyWordSearchFlow dzdpSearch = new KeyWordSearchFlow("眼镜店", 2311, 2311);
		dzdpSearch.execute();
		logger.info("end dzdp");
		//TODO: add multi thread
	}
}

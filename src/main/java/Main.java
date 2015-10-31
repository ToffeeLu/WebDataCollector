import dzdp.flows.KeyWordSearchFlow;

/**
 * Created by zhlu on 10/27/2015.
 */
public class Main {

	public static void main(String args[]) throws Exception {
		KeyWordSearchFlow dzdpSearch = new KeyWordSearchFlow("眼镜店", 2311, 2311);
		dzdpSearch.execute();
	}
}

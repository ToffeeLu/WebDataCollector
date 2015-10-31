package dzdp.utils;

import common.utils.BaseExcelReportUtil;
import dzdp.entities.ShopComponent;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author ToffeeLu on 2015/10/31.
 */
public class ExcelReportUtil extends BaseExcelReportUtil {
	private static final String pathToFormat = basePath + "/dzdp/keyword-%s/%s.xls";

	public static WritableWorkbook generateSearchReportExcel(String keyword, String fileName) throws Exception {
		String path = String.format(pathToFormat, keyword, fileName);
		return createExcel(path);
	}

	public static void generateSearchResultExcel(String keyword, String fileName, List<ShopComponent> shops) throws Exception {
		WritableWorkbook excel = ExcelReportUtil.generateSearchReportExcel(keyword, fileName);
		WritableSheet sheet = excel.createSheet(keyword, 0);

		sheet.addCell(new Label(0, 0, "店名"));
		sheet.addCell(new Label(1, 0, "星级"));
		sheet.addCell(new Label(2, 0, "评论数"));
		sheet.addCell(new Label(3, 0, "人均消费"));
		sheet.addCell(new Label(4, 0, "区域标签"));
		sheet.addCell(new Label(5, 0, "地址"));

		int row = 1;
		for (int i = 0; i < shops.size(); i++) {
			ShopComponent shop = shops.get(i);
			sheet.addCell(new Label(0, row, shop.title));
			sheet.addCell(new Label(1, row, shop.starCount));
			sheet.addCell(new Label(2, row, shop.commentCount));
			sheet.addCell(new Label(3, row, shop.averageCost));
			sheet.addCell(new Label(4, row, shop.addressTag));
			sheet.addCell(new Label(5, row, shop.address));
			row++;
		}
		excel.write();
		excel.close();
	}
}

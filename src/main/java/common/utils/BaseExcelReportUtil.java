package common.utils;

import jxl.Workbook;
import jxl.write.WritableWorkbook;

import java.io.File;
import java.io.IOException;

/**
 * Created by Lu on 2015/10/31.
 */
public class BaseExcelReportUtil {
	protected static final String basePath = "./reports/excels/";

	/**
	 * create a file even dictionaries is not exists
	 */
	public static WritableWorkbook createExcel(String filePath) throws Exception {
		File file = new File(filePath);
		File dictionary = file.getParentFile();
		if (!dictionary.exists()) {
			dictionary.mkdirs();
		}
		return Workbook.createWorkbook(file);
	}
}

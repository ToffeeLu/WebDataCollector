package common.utils;

import jxl.Workbook;
import jxl.write.WritableWorkbook;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * Created by Lu on 2015/10/31.
 */
public class BaseExcelReportUtil {
	private static Logger logger = Logger.getLogger(BaseExcelReportUtil.class);

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
		logger.info("create file " + filePath);
		return Workbook.createWorkbook(file);
	}
}

package no.nocrm.crm.fileUtility;

import java.io.FileInputStream;
import java.util.Properties;

/**
 * @author Arun Kumar M
 * this class contains file utility
 */
public class File_Utility {

	/**
	 * this method is used to fetch data from property file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromPropertyFile(String key) throws Throwable {

		FileInputStream fis = new FileInputStream("./src/test/resources/configue_appdata/CommonData.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String data = prop.getProperty(key);
		return data;

	}
}

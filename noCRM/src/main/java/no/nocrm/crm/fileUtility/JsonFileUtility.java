package no.nocrm.crm.fileUtility;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * @author Manikandan 
 * this class contains json file utility
 */
public class JsonFileUtility {

	/**
	 * this method is used to get data from get data from json file utility
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getDataFromJsonFileUtility(String key) throws Throwable {
		FileReader freader = new FileReader("./Configue_appdata/CommonData.json");
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(freader);
		JSONObject jobj = (JSONObject)obj;
		String data = jobj.get(key).toString();
		return data;
	}

}

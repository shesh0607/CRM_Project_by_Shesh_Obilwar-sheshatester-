package Generic_Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Property_Utility {
	
	/**
	 * this method is used for launching the application.
	 * @author Shesh
	 * @param key
	 * @return
	 * @throws IOException
	 */

	public String getStringkeyAndValue(String key) throws IOException {

		FileInputStream fis=new FileInputStream("./src/test/resources/PropertyFile.properties");
		Properties pro=new Properties();
		pro.load(fis);
		
		String value=pro.getProperty(key);
		return value;
		
		
		

	}

}

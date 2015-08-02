package WebdriverPro.web.framework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.testng.annotations.Test;

public class PropertyManager {
	static Logger logger = Logger.getLogger(PropertyManager.class);
	
	private static Properties props;

	public static String getProperty(String key){
		props = new Properties();
		InputStream is = ClassLoader.getSystemClassLoader().getResourceAsStream("config.properties");
		
		try {
			props.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		logger.info("Key: "+key+"Value: "+props.getProperty(key));
		return props.getProperty(key);
	}
	

}

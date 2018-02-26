package utility;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {
	
	private static Properties properties;
	//private final String propertyFilePath= "config//Configuration.properties";

	
	private static void fileReader(String propertyFilePath){
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}		
	}
	
	public static String getPropertyValue(String propertyFilePath, String property){
		fileReader(propertyFilePath);
		String driverPath = properties.getProperty(property);
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException("'" + property + "' not specified in the '"+ propertyFilePath +"' file.");		
	}
}
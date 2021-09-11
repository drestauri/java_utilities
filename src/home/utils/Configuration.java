package home.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

//import home.App;

/********** NOTES ***********
 * This is a TEMPLATE configuration loader class.
 * It is to be used to load a .properties file and make a set of 
 * setters and getters available to the main application.
 * The sample properties file "config.properties" used with
 * this template is in the resources directory.
 *  
 ***************************/

/********** TODO ************
 * > Trim this file down to the minimum template (currently reflects an actual implementation)
 ***************************/

public class Configuration {
	private String fileName;
	private Properties config;
	
	public Configuration(String file_name)
	{

		config = new Properties();
		fileName = file_name;
		
		File configFile;
		configFile = new File(fileName);
		
		// Perform some quick checks on the file
		if(!configFile.exists())
		{
			// If the file doesn't exist, generate a new file
			//App.log.LogMessage_High("Configuration file not found");
		}else if(configFile.length() < 100)
		{
			// Or if the file appears to be invalid, generate the default file
			//App.log.LogMessage_High("Configuration file empty or invalid");
		}
		
		InputStream is;
		try {
			is = new FileInputStream(configFile);
			if (is!=null)
				config.loadFromXML(is);
		} catch (FileNotFoundException e) {
			System.out.println("Config file not found");
			//App.log.LogMessage_High("Error: Config file not found after checking and generating new file");
			e.printStackTrace();
		} catch (InvalidPropertiesFormatException e) {
			System.out.println("Config file invalid");
			//App.log.LogMessage_High("Error: Config file invalid after checking and generating new file");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Config file IO error");
			//App.log.LogMessage_High("Error: Config file IO error after checking and generating new file");
			e.printStackTrace();
		}
	}
	
	// TODO: Create all set and get methods for the config that make sense for your application. Some examples are below:

	public String getDevice()
	{
		return config.getProperty("DEVICE","DEV");
	}
	
	public String getLocation()
	{
		return config.getProperty("LOCATION","LOC");
	}
	
	public String getRole()
	{
		return config.getProperty("ROLE","ROLE");
	}
	
	public String getDefaultCommPort()
	{
		return config.getProperty("DEFAULT_COMM_PORT","COM3");
	}
	
	public String getGmsecMode()
	{
		return config.getProperty("GMSEC_MODE","");
	}
	
	public String getGmsecMw()
	{
		return config.getProperty("GMSEC_MW","");
	}
	
	public String getGmsecServer()
	{
		return config.getProperty("GMSEC_SERVER","");
	}
	
	public String getDataRequestTopic()
	{
		return config.getProperty("TOPIC_DATA_REQ","");
	}
	
}

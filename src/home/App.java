package home;

import java.util.Calendar;
import java.util.logging.LogManager;

import home.utils.AppConfiguration;
import home.utils.EventLogger;


/********** NOTES ***********
 * This class is used to test and demonstrate the usage of utility classes.
 * The intent is for this project to be used as the master location to develop
 * and update the utility classes so that all projects can benefit from the updates
 ***************************/

/********* TODO **********
 * > Create section to demonstrate Configuration class
 * > Consider any other useful classes to develop and add to this project
 * 
 * Later:
 * > Add minimal DataLogger/DataHistory template (see EBM project)
 *   > Alternatively, setup another solution such as using a DB or consider setting up the DataLogger to be more DB like
 ************************/
public class App {
	
	// Making the logger static here 
	static EventLogger log;
	
	static boolean testLogger = true;
	static boolean testConfig = false;
	
	
	public static void main(String[] args)
	{

		//============ TEST LOGGING ======================
		if(testLogger)
		{
			log = new EventLogger();
			log.SetAppName("App");
			log.SetHostName("MyDevice");
			
			// Rotating logs is true by default, but you can test turning it off as well:
			//log.SetRotateLogs(false);
			
			// To make this work in a reasonable period of time for testing/demonstration, the following line in the EventLogger:
			//		int tmp_day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
			// must be changed to the following:
			// 		int tmp_day = Calendar.getInstance().get(Calendar.SECOND)/10; // rotates logs every 10 seconds
			int count = 100;
			while (count>0)
			{
				System.out.println("Loops left: " + Integer.toString(count));
				
				log.LogMessageWithTag("Test string", "my_tag");
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count--;
			}
		}
			//============ END TEST LOGGING ======================
		
		
		//============ TEST CONFIGURATION ======================
		if(testConfig)
		{
			// Generates a default config file if file not found
			AppConfiguration config = new AppConfiguration();
			
			// Set the comment for the properties file
			config.setComment("My custom comment");
			
			// Get a property (success)
			String s = config.getPropertyAsString("HOSTNAME");
			System.out.println("Hostname: " + s);
			
			// Get a property (fail)
			int k = config.getPropertyAsInt("HOSTNAME");
			System.out.println("Hostname: " + Integer.toString(k));
			
			// Set a property
			config.setProperty("HOSTNAME", "MyHostname");
			s = config.getPropertyAsString("HOSTNAME");
			System.out.println("New Hostname: " + s);
			
			// Save to a new file
			config.saveAs("newfile.properties");
		}
		
		//============ END TEST CONFIGURATION ======================
	}

}

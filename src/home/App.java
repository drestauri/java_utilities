package home;

import java.util.Calendar;

import home.utils.EventLogger;

/********** NOTES ***********
 * This class is used to test and demonstrate the usage of utility classes.
 * The intent is for this project to be used to develop and update the utility classes, and then the
 * home.utils package is exported as a JAR so it can be included in other projects. 
 ***************************/

/********* TODO **********
 * > Create section to demonstrate EventLogger class
 * > Create section to demonstrate Configuration class
 * > Consider any other useful classes to develop and add to this project
 * 
 * Later:
 * > Add minimal DataLogger/DataHistory template (see EBM project)
 *   > Alternatively, setup another solution such as using a DB or consider setting up the DataLogger to be more DB like
 ************************/
public class App {
	
	static EventLogger log;
	
	public static void main(String[] args)
	{
		log = new EventLogger();
		
		//============ TEST LOG ROTATION ======================
		// Rotating logs is true by default, but you can test turning it off as well:
		log.SetRotateLogs(false);
		
		// To make this work in a reasonable period of time for testing/demonstration, the following line in the EventLogger:
		//		int tmp_day = Calendar.getInstance().get(Calendar.DAY_OF_WEEK);
		// must be changed to the following:
		// 		int tmp_day = Calendar.getInstance().get(Calendar.SECOND)/10; // rotates logs every 10 seconds
		int count = 120;
		while (count>0)
		{
			System.out.println("Loops left: " + Integer.toString(count));
			log.LogMessage_Low("Test string");
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			count--;
		}
	}

}

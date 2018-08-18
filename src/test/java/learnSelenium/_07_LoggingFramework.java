package learnSelenium;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class _07_LoggingFramework
{
	public static Logger logger = Logger.getLogger(_07_LoggingFramework.class);
	
	public static void main(String args[])
	{
		PropertyConfigurator.configure("log4j.properties");
		
		//There are SIX logging levels with increasing importance hierarchy:
		//TRACE
		//DEBUG
		//INFO
		//WARN
		//ERROR
		//FATAL
		
		//Set the Trace level in log4j.properties
		logger.trace("This is Trace");
		logger.info("This is Info");
		logger.debug("This is Debug");
		logger.warn("This is Warn");
		logger.error("This is Error");
		logger.fatal("This is Fatal");
	}
}

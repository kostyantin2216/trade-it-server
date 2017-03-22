package com.charlieaffs.ifs.logging;

import java.util.Date;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.jboss.logging.Logger;

import com.charlieaffs.data.tradeit.model.Log;
import com.charlieaffs.ifs.utils.Formatter;

public class TILogger {
	
	private final static TILogger instance = new TILogger();
	
	public static TILogger getLog() {
		return instance;
	}
	
	public enum Level {
		ERROR,
		INFO,
		DEBUG,
		WARN
	}
	
	private final Logger logger = Logger.getLogger("TILogger");
	
	// ERROR
	// -----------------------
	
	public void error(String message) {
		log(Level.ERROR, message, null, false);
	}
	
	public void error(String message, boolean saveLog) {
		log(Level.ERROR, message, null, saveLog);
	}
	
	public void error(String message, Throwable throwable) {
		log(Level.ERROR, message, throwable, false);
	}
	
	public void error(String message, Throwable throwable, boolean saveLog) {
		log(Level.ERROR, message, throwable, saveLog);
	}
	
	public void error(String tag, String message, boolean saveLog) {
		log(Level.ERROR, message, null, saveLog, tag);
	}
	
	public void error(String tag, String message, Throwable throwable, boolean saveLog) {
		log(Level.ERROR, message, throwable, saveLog, tag);
	}
	
	// INFO
	// -----------------------
	
	public void info(String message) {
		log(Level.INFO, message, null, false);
	}
	
	public void info(String message, boolean saveLog) {
		log(Level.INFO, message, null, saveLog);
	}
	
	public void info(String tag, String message, boolean saveLog) {
		log(Level.INFO, message, null, saveLog, tag);
	}
	
	// DEBUG
	// -----------------------
	
	public void debug(String message) {
		log(Level.DEBUG, message, null, false);
	}
	
	// WARN
	// -----------------------
	
	public void warn(String message) {
		log(Level.WARN, message, null, false);
	}
	
	public void warn(String message, boolean saveLog) {
		log(Level.WARN, message, null, saveLog);
	}
	
	public void warn(String message, Throwable throwable) {
		log(Level.WARN, message, throwable, false);
	}
	
	
	private void log(Level level, String message, Throwable throwable, boolean saveLog) {
		log(level, message, throwable, saveLog, null);
	}
	
	private void log(Level level, String message, Throwable throwable, boolean saveLog, String tag) {		
		switch (level) {
			case ERROR:
				logger.error(message, throwable);
				break;
			case INFO:
				logger.info(message, throwable);
				break;
			case DEBUG:
				logger.debug(message, throwable);
				break;
			case WARN:
				logger.warn(message, throwable);
				break;
		}
		
		if(saveLog) {			
			Formatter.saveLog(new Log(
					-1, 
					Formatter.notEmpty(tag) ? tag : "Server", 
					message, 
					throwable != null ? ExceptionUtils.getStackTrace(throwable) : null, 
					"wildfly", 
					"1.0", 
					new Date()
			));
		}
	}
	
}

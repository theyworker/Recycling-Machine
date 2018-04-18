package com.perisic.beds;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class ConsoleLog {
	
/**
 * This class prints logs on the console with a time stamp and is called everywhere there is a event.
 * @param logmsg
 */
	public static void printlog(String logmsg) 
	{
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());// time stamp object creation; used for console log
		final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		
		String finalLog = sdf.format(timestamp)+" "+logmsg;
			System.out.println(finalLog);
			
	}
	
	
}

package com.perisic.beds;
import java.util.Calendar;

public class WelcomeMessage {
/**
 * This generates a simple welcome message based on the time of the day
 * @return
 */
	public static String getGreeting() {
	  Calendar cal = Calendar.getInstance();
      int hour = cal.get( Calendar.HOUR_OF_DAY );

      if( hour >= 0 && hour < 12 ) {
    	  return( "Good morning!" );
      }
      else if( hour >= 12 && hour <= 17 ) {
          return( "Good afternoon!" );
      }
      else if( hour > 17 ) {
    	  return( "Good evening!" );
      }

      return "Greetings from the Recycling Machine!";
	}
	
}

package com.perisic.beds;

import java.net.*;
import java.io.*;

public class ItemReader {
	/**
	 * Used to get the value of a items through the server.
	 * @param what
	 * @return
	 * @throws Exception
	 */
    public static int getValueOf(String what) throws Exception {

        URL prices = new URL("http://192.168.1.9/?item="+what);
        
        BufferedReader in = new BufferedReader( new InputStreamReader(prices.openStream()));

        String inputLine;
        int result = -2; 
        
        while ((inputLine = in.readLine()) != null) {
        	result = Integer.parseInt(inputLine); 
        	}
        in.close(); 
        return result; 
    }
    
}
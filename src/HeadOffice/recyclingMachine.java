package HeadOffice;

import java.util.Random;


/**
 * An object of this clas is created for every Recycling machine that is connected into the Head Office.
 * @author devaka
 *
 */
public class recyclingMachine {
	String location;
	String ip;
	String cookie;
	
	public recyclingMachine(String loc,String IP) {
		super();
		location = loc;
		ip = IP;
		
	}
	
	/*
	 * Returns the IP address of the Recycling Machine
	 *
	 */
	public String getIp() {
		return ip;
	}
	
	/**
	 * Returns the name of the location of the Recycling Machine
	 * @return
	 */
	public String getLocation() {
		return location;
	}
	
	/**
	 * Sets a cookie for the Recycling Machine upon the connection 
	 * @return cookie
	 */
	public String setCookie() 
	{
		Random randomNum = new Random();
		cookie = "ri"+randomNum.nextInt(100000000);
		return cookie;
	}

	/**
	 * Returns the cookie that was assigned at the connection
	 * @return
	 */
	public String getCookie()
	{
		return cookie;
	}
	
}

package HeadOffice;

import java.util.Random;

public class recyclingMachine {
	String location;
	String ip;
	String cookie;
	
	public recyclingMachine(String loc,String IP) {
		super();
		location = loc;
		ip = IP;
		
	}
	
	public String getIp() {
		return ip;
	}
	
	public String getLocation() {
		return location;
	}
	
	public String setCookie() 
	{
		Random randomNum = new Random();
		cookie = "ri"+randomNum.nextInt(100000000);
		return cookie;
	}

	public String getCookie()
	{
		return cookie;
	}
	
}

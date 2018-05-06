package HeadOffice;

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
		cookie = "ri"+Math.random();
		return cookie;
	}

	public String getCookie()
	{
		return cookie;
	}
	
}

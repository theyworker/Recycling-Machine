package HeadOffice;

public class recyclingMachine {
	String location;
	String ip;
	
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

	
}

package HeadOffice;

import org.apache.xmlrpc.WebServer;


public class ServerManager {


	static int psswrdsvr = 1600;

	public void runServer() {
		//current this server is not being used 
		WebServer server = new WebServer(1200);
	  	 server.addHandler("hello", new HeadOffice());
	   	 server.start();
	}
	
	public void psswrdServer() 
	{
		WebServer server = new WebServer(psswrdsvr);
	  	 server.addHandler("passwordmanager", new PasswordManager());
	   	 server.start();
	}
}

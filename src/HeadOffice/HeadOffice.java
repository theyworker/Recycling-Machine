package HeadOffice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;


import org.apache.xmlrpc.*;

public class HeadOffice implements ActionListener {
	int countcan, countcrate, countglassbottle, countplasticbottle, countpaperbag;
	HeadOfficeGUI HOGUI;
	String  url = "http://localHost:1300/RPC2";
	String sessioncookie="not set";
	static int psswrdsvr = 1600;
	static int Lgsvr = 1610;
	public void runServer() {
		WebServer server = new WebServer(1200);
	  	 server.addHandler("hello", new HeadOffice());
	   	 server.start();
	}
	
	public String newConnection(String place) {
		//HOGUI.JTA.setText("Recycling Machine Connected from "+place);
//		HeadOfficeGUI.JTA.setText(place+"is here!");
		return "Connected.";
	}
	
	public static void psswrdServer() 
	{
		WebServer server = new WebServer(psswrdsvr);
	  	 server.addHandler("passwordmanager", new PasswordManager());
	   	 server.start();
	}
	
	
	public static void startServers()
	{
		psswrdServer();
	}
	
	public void terminateClient() {
		try {
			   XmlRpcClient server = new XmlRpcClient(url); 
			   Vector<String> params = new Vector<String>();
			   server.execute("machine.restartMachine", params);
			   
			   }
			   
		catch (IOException e)
			{
			System.out.println("Recycling Machine may not be turned on");
			}
		catch (Exception ex) {
			   System.err.println("HelloClient: " + ex);
			   }
	}
	
	public void clearReceiptClient() {
		try {
			   XmlRpcClient server = new XmlRpcClient(url); 
			   Vector<String> params = new Vector<String>();
			   Object result = server.execute("machine.clearScreenRemotely", params);
			   System.out.println("Result from Server: "+result.toString());
			   }
			   
		catch (Exception ex) {
			   System.err.println("HelloClient: " + ex);
			   }
	}
	
	public void getNumofItemsClient() {
		try {
			   XmlRpcClient server = new XmlRpcClient(url); 
			   Vector<String> params = new Vector<String>();
			   Object result = server.execute("machine.getNumofItems", params);
			   System.out.println("The number of items in the machine:  "+result.toString());
			   }
			   
		catch (Exception ex) {
			   System.err.println("HelloClient: " + ex);
			   }
	}
	
	
	
	public static void main(String[] args) {
		HeadOfficeGUI HOGUI = new HeadOfficeGUI();
		HOLoginGUI HOLogin = new HOLoginGUI(HOGUI);
		HOLogin.setVisible(true);
		startServers();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(HeadOfficeGUI.turnoff))
		{
			terminateClient();
		}
		
		else if(e.getSource().equals(HeadOfficeGUI.ClearReceipt))
		{
			clearReceiptClient();
		}
		else if(e.getSource().equals(HeadOfficeGUI.GetnoofItems))
		{
			getNumofItemsClient();
		}
		
		else if(e.getSource().equals(HeadOfficeGUI.CreateUser))
		{
			CreateNewUserGUI cnu = new CreateNewUserGUI();
			cnu.setVisible(true);
		}
		
		
	}

}

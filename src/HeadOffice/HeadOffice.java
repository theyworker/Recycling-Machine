package HeadOffice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;
import org.apache.xmlrpc.*;

import HeadOffice.HOTesting.*;

public class HeadOffice implements ActionListener {
	
	int countcan, countcrate, countglassbottle, countplasticbottle, countpaperbag, countPolythenebag;
	HeadOfficeGUITesting Ho;
	String  RMurl = "http://localHost:1300/RPC2";
	//String sessioncookie="not set";
	rmConnection rmCon = new rmConnection();
	
 


	
	
	public String newConnection(String place,String ip) {
		//HOGUI.JTA.setText("Recycling Machine Connected from "+place);
//		HeadOfficeGUI.JTA.setText(place+"is here!");
		rmCon.addConnection(new recyclingMachine(place, ip));
		
		return "connected";
	}
	
	public void priceUpdation()
	{
		PricingManager PriceMng = new PricingManager();
		PriceMng.getPrices();
		PriceMng.sendPrices();
		System.out.println("HO function");
	}
	
	public static void startServers()
	{
		ServerManager SvrMng = new ServerManager();
		SvrMng.psswrdServer();
		SvrMng.runServer();
	}
	
	public void terminateClient() {
		try {
			   XmlRpcClient server = new XmlRpcClient(RMurl); 
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
			   XmlRpcClient server = new XmlRpcClient(RMurl); 
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
			   XmlRpcClient server = new XmlRpcClient(RMurl); 
			   Vector<String> params = new Vector<String>();
			   Object result = server.execute("machine.getNumofItems", params);
			   System.out.println("The number of items in the machine:  "+result.toString());
			   }
			   
		catch (Exception ex) {
			   System.err.println("HelloClient: " + ex);
			   }
	}
	
	
	
	public static void main(String[] args) {
		HeadOfficeGUITesting Ho = new HeadOfficeGUITesting();
		Ho.setVisb();
	//~~~~~~~~~~~~~~~~~~~~~~~~~ Logins Disabled for testing
	//	HOLoginGUI HOLogin = new HOLoginGUI(HOGUI);
	//HOLogin.setVisible(true);
		
		startServers();
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource().equals(controlPnlWDW.turnoff))
		{
			terminateClient();
		}
		
		else if(e.getSource().equals(controlPnlWDW.ClearReceipt))
		{
			clearReceiptClient();
		}
		else if(e.getSource().equals(controlPnlWDW.GetnoofItems))
		{
			getNumofItemsClient();
		}
		
		else if(e.getSource().equals(HeadOfficeGUITesting.CreateUser))
		{
			CreateNewUserGUI cnu = new CreateNewUserGUI();
			cnu.setVisible(true);
		}
		
		else if(e.getSource().equals(HeadOfficeGUITesting.UpdatePriceBtn))
		{
			priceUpdation();
			System.out.println("So the button was pressed");
		}
		
		
		else if (e.getSource().equals(HeadOfficeGUITesting.control))
		{
			controlPnlWDW cplWDW = new controlPnlWDW();
			cplWDW.setVisible(true);
		}
		
	}

}

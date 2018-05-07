package HeadOffice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.apache.xmlrpc.*;

import HeadOffice.HOTesting.*;

public class HeadOffice implements ActionListener {
	
	//int countcan, countcrate, countglassbottle, countplasticbottle, countpaperbag, countPolythenebag;
	//HeadOfficeGUITesting Ho;
	static HeadOfficeGUITesting Ho = new HeadOfficeGUITesting();
	String  RMurl = "http://localHost:1300/RPC2";
	


	public String newConnection(String loc,String ip) {
		recyclingMachine newRM = new recyclingMachine(loc,ip);
		HeadOfficeGUITesting.addConnection(newRM);
		String sessionCookie =  newRM.setCookie();
		return sessionCookie;
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
	
//	public void terminateClient() {
//		try {
//			   XmlRpcClient server = new XmlRpcClient(RMurl); 
//			   Vector<String> params = new Vector<String>();
//			   server.execute("machine.restartMachine", params);
//			   
//			   }
//			   
//		catch (IOException e)
//			{
//			System.out.println("Recycling Machine may not be turned on");
//			}
//		catch (Exception ex) {
//			   System.err.println("HelloClient: " + ex);
//			   }
//	}
	
	
	
	public static void main(String[] args) {
		
		Ho.setVisb();
	//~~~~~~~~~~~~~~~~~~~~~~~~~ Logins Disabled for testing
	//	HOLoginGUI HOLogin = new HOLoginGUI(HOGUI);
	//HOLogin.setVisible(true);
		
		startServers();
		
		

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(HeadOfficeGUITesting.CreateUser))
		{
			CreateNewUserGUI cnu = new CreateNewUserGUI();
			cnu.setVisible(true);
		}
		
		else if(e.getSource().equals(HeadOfficeGUITesting.UpdatePriceBtn))
		{
			priceUpdation();
			//remove this~~~~~~~~~~~~~~~~~
			System.out.println("So the button was pressed");
		}
		
		
		else if (e.getSource().equals(HeadOfficeGUITesting.control))
		{
			String userIP = Ho.usrIP.getText();
			if(userIP.isEmpty()) {
				JOptionPane.showMessageDialog(new JFrame(), "Please enter the IP of the Recycling Machine you want to access");
			}
			else 
			{
				if(Ho.ipLookup(userIP))
				{
					controlPnlWDW cplWDW = new controlPnlWDW(userIP);
					cplWDW.setVisible(true);

				}
			}
			
		}
		
	}

}

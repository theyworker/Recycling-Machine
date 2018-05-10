package HeadOffice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import HeadOffice.HOTesting.*;
import HeadOffice.Stats.StatsHO;

public class HeadOffice implements ActionListener {
	
	//int countcan, countcrate, countglassbottle, countplasticbottle, countpaperbag, countPolythenebag;
	//HeadOfficeGUITesting Ho;
	static HeadOfficeGUI Ho = new HeadOfficeGUI();
	String  RMurl = "http://localHost:1300/RPC2";
	
public StatsHO statistics = new StatsHO();

	public String newConnection(String loc,String ip) {
		recyclingMachine newRM = new recyclingMachine(loc,ip);
		HeadOfficeGUI.addConnection(newRM);
		String sessionCookie =  newRM.setCookie();
		return sessionCookie;
	}
	
//	public void priceUpdation()
//	{
//		PricingManager PriceMng = new PricingManager();
//		PriceMng.getPrices();
//		PriceMng.sendPrices();
//		System.out.println("HO function");
//	}
	
	public static void startServers()
	{
		ServerManager SvrMng = new ServerManager();
		SvrMng.psswrdServer();
		SvrMng.runServer();
	}
	

	
	
	
	public static void main(String[] args) {
		
		Ho.setVisb();
	//~~~~~~~~~~~~~~~~~~~~~~~~~ Logins Disabled for testing
	//	HOLoginGUI HOLogin = new HOLoginGUI(HOGUI);
	//HOLogin.setVisible(true);
		
		startServers();
		
		

		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(HeadOfficeGUI.CreateUser))
		{
			CreateNewUserGUI cnu = new CreateNewUserGUI();
			cnu.setVisible(true);
		}
		
		else if(e.getSource().equals(HeadOfficeGUI.UpdatePriceBtn))
		{
			//priceUpdation();
			priceChanger pC = new priceChanger(Ho);
			pC.setVisible(true);
			}
		
		
		else if (e.getSource().equals(HeadOfficeGUI.control))
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

package HeadOffice;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Vector;

import javax.swing.*;

import org.apache.xmlrpc.XmlRpcClient;


import HeadOffice.Stats.StatsHO;
/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * @author devaka
 * 
 *
 */
public class HeadOfficeGUI extends JFrame  {
	/**
	 * 
	 */
	HeadOffice HO = new HeadOffice();
	private static final long serialVersionUID = 546723911453041610L;//unique code for each object
	
	// Connected Devices 
	private JTextArea JTA = new JTextArea(10,15);	
	JScrollPane JTAScrll = new JScrollPane(JTA);
	public static JButton control = new JButton("Options");
	public JTextField usrIP = new JTextField();
	JLabel usrIPlbl = new JLabel("<html>Enter the IP of the <br/> Recycling machine</html>");
	
	
	JFrame HeadQuarterFrame;

	static JTextArea txtMachine = new JTextArea();
	static JTextArea txtitem = new JTextArea();
	static JTextArea usageTXT = new JTextArea();
	
	JLabel LocLBL = new JLabel("Location");
	JLabel IpLbl = new JLabel("IP");
	
	public static JButton refreshCons = new JButton("Refresh");
	
	//Usage Stats
	JLabel LocationLbl = new JLabel("Location");
	JLabel canLbl = new JLabel("Cans");
	JLabel crateLbl = new JLabel("Crates");
	JLabel glassbttlLbl = new JLabel("<html>Glass<br/>Bottles</html>");
	JLabel PlasticbttleLbl = new JLabel("<html>Plastic<br/>Bottles</html>");
	JLabel PolyBagLbl = new JLabel("<html>Polythene<br/>Bags</html>");
	JLabel PapperbapLbl = new JLabel("<html>Paper<br/>Bags</html>");
	JLabel TotItemsLbl = new JLabel("Total");
	
	
	
	//Administration 
	public static JButton CreateUser = new JButton("Create a new user");
	
	static JButton exit = new JButton("System Shutdown");
	
	public static JButton UpdatePriceBtn = new JButton("Update Prices");
	
	

	static Vector<recyclingMachine> connection = new Vector<recyclingMachine>();
	
	
	public static void addConnection(recyclingMachine rm) 
	{
		connection.add(rm);
	}
	
	public static String tallyCookie(String sessionCookie)
	{
		for(int h=0; h<numofConnections();h++) 
		{
			if(connection.get(h).getCookie().equals(sessionCookie))
			{
				return connection.get(h).getLocation();
			}
			
		}
		return null;
	}
	
	public static String newCnnct(String loc, String ip)
	{
		recyclingMachine newRM = new recyclingMachine(loc,ip);
		addConnection(newRM);
		return newRM.setCookie();
		
	}
	
	public static int numofConnections()
	{
		return connection.size();
	}
	
	public void pushPricestoALL(PricingManager pm)
	{
		for(int h=0; h<numofConnections();h++) 
		{
			String tempIP = connection.get(h).getIp();
			pm.sendPrices(tempIP);
		}
	}
	public void shutDownALL()
	{
		String url1 = "http://";
		String url2 = ":1300/RPC2";
		
		for(int h=0; h<numofConnections();h++) 
		{
			String tempIP = connection.get(h).getIp();
				try {
						String target = url1+tempIP+url2;
					   XmlRpcClient server = new XmlRpcClient(target); 
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
	}
	
	public boolean ipLookup(String userIp)
	{
		for(int j=0; j<(connection.size());j++)
		{
			if (connection.get(j).getIp().equals(userIp))
				return true;
		}
		return false;
	}
	
	public String showConnections()
	{
		String currCons = null;
		for (int f= 0; f<connection.size();f++)
		{
			if(currCons!=null)
			{
				currCons = currCons+connection.get(f).getLocation()+"		"+connection.get(f).getIp()+"\n";
			}
			else 
			{
				currCons = connection.get(f).getLocation()+"		"+connection.get(f).getIp()+"\n";
			}
		}
		return currCons;
	}
	
	
	public HeadOfficeGUI()  {
		super();
		try {
			initialize();
			
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
	
	}

	private void initialize() throws FileNotFoundException {
		HeadQuarterFrame = new JFrame();
		HeadQuarterFrame.setTitle("Recycling Inc. Head Office");
		HeadQuarterFrame.setResizable(false);
		HeadQuarterFrame.setBounds(200, 100, 800, 650);
		HeadQuarterFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		HeadQuarterFrame.getContentPane().setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(10, 100, 774, 450);
		tabbedPane.setFont(new Font("Tahoma", Font.PLAIN, 13));
		tabbedPane.setBackground(Color.WHITE);
		HeadQuarterFrame.getContentPane().add(tabbedPane);
		
		JPanel conDevs = new JPanel();
		conDevs.setBackground(Color.gray);
	
		
		tabbedPane.addTab("Connected Machines", null, conDevs, null);
		conDevs.setBackground(Color.GRAY);
		conDevs.setLayout(null);
		conDevs.add(JTAScrll);
		conDevs.add(LocLBL);
		conDevs.add(IpLbl);
		conDevs.add(refreshCons);
		conDevs.add(usrIP);
		conDevs.add(control);
		conDevs.add(usrIPlbl);
		
		usrIPlbl.setBounds(485, 50, 200, 30);
		usrIP.setBounds(450, 90, 200, 20);
		control.setBounds(450, 120, 200, 30);
		control.addActionListener(HO);
	
		LocLBL.setBounds(20, 13, 70, 10);
		IpLbl.setBounds(200,13,70,10);
		JTAScrll.setBounds(20,25, 275, 330);
		JTA.setText(showConnections());
		JTA.setEditable(false);
		refreshCons.setBounds(20, 360, 275, 30);
		refreshCons.setBackground(Color.BLUE);
		refreshCons.setForeground(Color.white);
		refreshCons.addActionListener(new ActionListener() {
			/**
			 * Refreshing Current Connenctions
			 */
			@Override
			public void actionPerformed(ActionEvent e) {
				if(e.getSource().equals(refreshCons))
				{
					JTA.setText(showConnections());
				}
			}
		});
		
		


		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Usage Summary", null, panel_1, null);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.gray);
		usageTXT.setEditable(false);
		usageTXT.setText(new StatsHO().getUsage());
		
//		JLabel LocationLbl = new JLabel("Location");
//		JLabel canLbl = new JLabel("Cans");
//		JLabel crateLbl = new JLabel("Crates");
//		JLabel glassbttlLbl = new JLabel("Glass Bottles");
//		JLabel PlasticbttleLbl = new JLabel("Plastic Bottles");
//		JLabel PolyBagLbl = new JLabel("Polythene Bags");
//		JLabel PapperbapLbl = new JLabel("Paper Bags");
//		JLabel TotItemsLbl = new JLabel("Total");
//		
		
		panel_1.add(LocationLbl);
		panel_1.add(canLbl);
		panel_1.add(crateLbl);
		panel_1.add(glassbttlLbl);
		panel_1.add(PlasticbttleLbl);
		panel_1.add(PolyBagLbl);
		panel_1.add(PapperbapLbl);
		panel_1.add(TotItemsLbl);
		
		LocationLbl.setBounds(10, 20, 70, 30);
		canLbl.setBounds(80, 20, 80, 30);
		crateLbl.setBounds(160, 20, 80, 30);
		glassbttlLbl.setBounds(260, 20, 80, 30);
		PlasticbttleLbl.setBounds(345, 20, 80, 30);
		PolyBagLbl.setBounds(425, 20, 80, 30);
		PapperbapLbl.setBounds(520, 20, 80, 30);
		TotItemsLbl.setBounds(600, 20, 80, 30);
		
		usageTXT.setForeground(Color.black);
		usageTXT.setBackground(Color.white);
		usageTXT.setBounds(10, 50, 774, 450);
		panel_1.add(usageTXT);
		
		
		//Administration Tab
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Administration", null, panel_2, null);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.gray);
		panel_2.add(CreateUser);
		panel_2.add(exit);
		panel_2.add(UpdatePriceBtn);
		UpdatePriceBtn.addActionListener(HO);
		CreateUser.addActionListener(HO);
		CreateUser.setBounds(200, 30, 200, 30);
		exit.setBounds(200, 150, 200, 30);
		exit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				shutDownALL();
				System.exit(0);
			}
		});
		UpdatePriceBtn.setBounds(200, 100, 200, 30);
		
		
		HeadQuarterFrame.setBackground(Color.gray);
		HeadQuarterFrame.getContentPane().setBackground(Color.gray);
		JLabel title = new JLabel("Recycling Inc.");
		title.setFont(new Font("Arial", Font.BOLD, 23));
		title.setForeground(Color.white);
		title.setBounds(300, 50, 200, 25);
		HeadQuarterFrame.getContentPane().add(title);
		

		
	}
	
	public void setVisb() 
	{
	
		this.HeadQuarterFrame.setVisible(true);
	}




}

package com.perisic.beds;
import java.awt.Color;
import java.awt.Font;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.xmlrpc.WebServer;
import org.apache.xmlrpc.XmlRpcClient;

import com.perisic.beds.Pricing.CurrentPrices;
import com.perisic.beds.Stats.StatsHub;

/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * @author Marc Conrad
 *
 */
public class RecyclingGUI extends JFrame implements PrinterInterface  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 546723911453041610L;//unique code for each object
	CustomerPanel thepanel = new CustomerPanel(this);
	int webserver = 1300;
	RecyclingGUIActions RGUIA = new RecyclingGUIActions(thepanel,this);
	static JTextArea JT =new JTextArea(2,2); //text area object embedded in the GUI with 15 rows and 30 columnsNot
	JScrollPane scrll = new JScrollPane(JT);
	
	static JProgressBar pbw;
	static JProgressBar pbsz;
	
	static JLabel currentvaltxt = new JLabel("£ 0.0");
	static int currentVal = 0;
	
	String location = "Colombo";
	
	
	CurrentPrices Cp;
	 //timer
	
	static int secs = 0; //seconds passed
	Timer timer1 = new Timer();
	TimerTask task1 = new TimerTask() {
		
		@Override
		public void run() {
			if(secs != 30)
				{
				secs++;
				
				}
			else 
				{
				ConsoleLog.printlog("System reseted on time out.");
				secs = 0;
				thepanel.receiver.clearReceipt();
				StatsHub.AddautoResetsStats();
				JT.setText(WelcomeMessage.getGreeting());
				resetFunctions();
				}
			
		}
	};
	
	
	public void resetFunctions() 
	{
		pbw.setValue((int) thepanel.getTW());
		pbsz.setValue((int) thepanel.getTS());
		
		currentVal = 0;
		currentvaltxt.setText("£ "+currentVal);
	}
	
	public static void resetTimer() {
		secs = 0;
	}

	public void start() {
		//timer
		
		timer1.scheduleAtFixedRate(task1, 1000,1000);
		
	}
	
	public void print(String str)
	{
		JT.setText(str);
	}
	
	static void updateCurrentVal(int change) 
	{
		currentVal += change;
		currentvaltxt.setText("£ "+currentVal);
	}
	/**
	 * This function will perform actions on the customer panel object depending on the button.
	 * The console acts as a log with timestamps
	 */
	

	static JButton slot1 = new JButton("Can"); 
	static JButton slot2 = new JButton("Crate"); 
	static JButton slot3 = new JButton("Glass Bottle"); 
	static JButton slot4 = new JButton("Paper Bag");
	static JButton slot5 = new JButton("Plastic Bottle");
	static JButton slot6 = new JButton("Polythene Bag");
	static JButton clr = new JButton("Clear");
	static JButton rmvlast = new JButton("Undo");
	
	
	static JButton receipt = new JButton("Receipt"); 
	
	static ImageIcon imgIcon = new ImageIcon("img/settings1.png");
	static JButton settings = new JButton("", imgIcon);
	
	static ImageIcon connectedIcon = new ImageIcon("img/cloud-computing.png");
	static JLabel connectLbl = new JLabel(connectedIcon);
	
	
	public RecyclingGUI(CurrentPrices CurrPrices) {
		
		super("Recycling Machine");
		
		Cp = CurrPrices;
		setSize(800, 430);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.setLayout(null);
		
		panel.add(slot1); 
		panel.add(slot2);
		panel.add(slot3); 
		panel.add(slot4);
		panel.add(slot5);
		panel.add(slot6);
		panel.add(clr);
		panel.add(rmvlast);
		panel.add(settings);
		panel.add(connectLbl);
		panel.add(currentvaltxt);
		
		Font fnt = new Font("Arial", Font.PLAIN, 20);
		
		settings.setBackground(Color.WHITE);
		settings.setToolTipText("Settings Menu");
		settings.setForeground(Color.WHITE);
		settings.setFont(fnt);
		settings.setBounds(720, 10, 30, 30);
		settings.setFocusable(false);
		settings.setBorderPainted(false);
		
		
		connectLbl.setBackground(Color.WHITE);
		connectLbl.setToolTipText("Connected with Recycling Inc. Servers");
		connectLbl.setForeground(Color.WHITE);
		connectLbl.setFont(fnt);
		connectLbl.setFocusable(false);
		
		
		slot1.setBackground(new Color(102,153,204));
		slot1.setToolTipText("Add a can into the Recylcing Machine");
		slot1.setForeground(Color.WHITE);
		slot1.setFont(fnt);
		slot1.setBounds(65, 65, 180, 60);
		slot1.setFocusable(false);
		
		slot2.setBackground(new Color(102,153,204));
		slot2.setToolTipText("Add a crate into the Recylcing Machine");
		slot2.setForeground(Color.WHITE);
		slot2.setFont(fnt);
		slot2.setBounds(250, 65, 180, 60);
		slot2.setFocusable(false);
		
		slot3.setBackground(new Color(102,153,204));
		slot3.setToolTipText("Add a Glass Bottle into the Recylcing Machine");
		slot3.setForeground(Color.WHITE);
		slot3.setFont(fnt);
		slot3.setBounds(65, 130, 180, 60);
		slot3.setFocusable(false);
		
		slot4.setBackground(new Color(102,153,204));
		slot4.setToolTipText("Add a paper bag into the Recylcing Machine");
		slot4.setForeground(Color.WHITE);
		slot4.setFont(fnt);
		slot4.setBounds(65, 195, 180, 60);
		slot4.setFocusable(false);
		
		slot5.setBackground(new Color(102,153,204));
		slot5.setToolTipText("Add a plastic bottle into the Recylcing Machine");
		slot5.setForeground(Color.WHITE);
		slot5.setFont(fnt);
		slot5.setBounds(250, 130, 180, 60);
		slot5.setFocusable(false);
		
		slot6.setBackground(new Color(102,153,204));
		slot6.setToolTipText("Add a polythene Bag into the Recylcing Machine");
		slot6.setForeground(Color.WHITE);
		slot6.setFont(fnt);
		slot6.setBounds(250, 195, 180, 60);
		slot6.setFocusable(false);
		
		clr.setBackground(new Color(102,153,130));
		clr.setToolTipText("Clear the screen");
		clr.setForeground(Color.WHITE);
		clr.setFont(fnt);
		clr.setBounds(450, 335, 147, 50);
		clr.setFocusable(false);
		
		rmvlast.setBackground(new Color(102,153,130));
		rmvlast.setToolTipText("Remove the last item that was added");
		rmvlast.setForeground(Color.WHITE);
		rmvlast.setFont(fnt);
		rmvlast.setBounds(603, 335, 147, 50);
		rmvlast.setFocusable(false);
		rmvlast.setVisible(false);
		
		receipt.setBackground(new Color(102,153,160));
		receipt.setToolTipText("Print a Receipt");
		receipt.setForeground(Color.WHITE);
		receipt.setFont(fnt);
		receipt.setBounds(450, 270, 300, 60);
		receipt.setFocusable(false);
		panel.setBackground(Color.WHITE);
		
		scrll.setBounds(450, 65, 300, 190);
		JT.setFont(new Font("Arial", Font.PLAIN, 15));
		JT.setEditable(false);
		JT.setFocusable(false);
		
		currentvaltxt.setFont(new Font("Arial", Font.BOLD, 22));
		currentvaltxt.setBounds(205, 270, 200, 60);
		
		JLabel pbwlbl = new JLabel("Weight");//Labels for the progress bars
		pbwlbl.setFont(new Font("Arial", Font.PLAIN, 20));
		pbwlbl.setBounds(117, 290, 100, 100);
		
		JLabel pbslbl = new JLabel("Size");
		pbslbl.setFont(new Font("Arial", Font.PLAIN, 20));
		pbslbl.setBounds(320, 290, 100, 100);
		
		
		pbw = new JProgressBar(0,1520); //progress bar for weight against total capasity
		pbw.setValue(0);
		pbw.setStringPainted(true);
		pbw.setBounds(65, 360, 180, 20);
		
		pbsz = new JProgressBar(0,1000);
		pbsz.setValue(0);
		pbsz.setStringPainted(true);
		pbsz.setBounds(250,360, 180, 20);
		
		
		slot1.addActionListener(RGUIA); 
		slot2.addActionListener(RGUIA); 
		slot3.addActionListener(RGUIA); 
		slot4.addActionListener(RGUIA);
		slot5.addActionListener(RGUIA);
		slot6.addActionListener(RGUIA);
		clr.addActionListener(RGUIA);
		rmvlast.addActionListener(RGUIA);
		settings.addActionListener(RGUIA);
		
		receipt.addActionListener(RGUIA); 
		
		panel.add(receipt); 
		//panel.add(JT);
		
		
		panel.add(scrll);
		
		
		
		panel.add(pbwlbl);
		panel.add(pbw);
		
		
		panel.add(pbslbl);
		panel.add(pbsz);


		getContentPane().add(panel);
		panel.repaint();
	
	}
	/**
	 * This is the main  method with GUI object
	 * @param args
	 */
	public void runClient() {
		try {
			   XmlRpcClient server = new XmlRpcClient("http://localHost:1200/RPC2"); 
			   Vector<String> params = new Vector<String>();
			   params.add(location);
			   Object result = server.execute("hello.newConnection", params);
			   
			   if(result.toString().equals("connected")) 
			   {
				   ConsoleLog.printlog("Connected with Recycling Inc. Server");
				   connectLbl.setBounds(726, 400, 24, 24);
				   
			   }
			   
			  } catch (Exception ex) {
			   }
	}
	
	public void runServer(Object gui) {
		WebServer server = new WebServer(webserver);
	  	 server.addHandler("machine", gui);
	  	 server.addHandler("pricing", Cp);
	   	 server.start();
	}
	
	public String restartMachine() {
		
			System.out.println("System is shutting down");
			System.exit(0);
			return "System restarted!";
		
	}
	public String clearScreenRemotely()
	{
		
			JT.setText("");
			ConsoleLog.printlog("Screen was cleared");
			thepanel.receiver.clearReceipt();
			return "Screen was cleared!";

	}
	
	public String getNumofItems()
	{
			return Integer.toString(thepanel.getNumofItems());
		
	}
	

	
	
	
	
	public static void main(String [] args ) { 
		final CurrentPrices Cp = new CurrentPrices();
		RecyclingGUI myGUI = new RecyclingGUI(Cp);
		Cp.loadPrices(); // load the last saved prices on the machine
		
		ConsoleLog.printlog("Recycling machine was turned on");
		RecyclingGUI.JT.setText(WelcomeMessage.getGreeting());
		myGUI.start();
		myGUI.setVisible(true);
		StatsHub.getStats();
		myGUI.runClient();
		
		myGUI.runServer(myGUI);
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() { 
			 public void run() {
				 StatsHub.SaveStats();
				 Cp.SavePrices();
			 }
		 }));
	}
	

}

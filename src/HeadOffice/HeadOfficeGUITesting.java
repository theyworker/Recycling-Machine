package HeadOffice;

import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.*;
/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * @author devaka
 * 
 *
 */
public class HeadOfficeGUITesting extends JFrame  {
	/**
	 * 
	 */
	HeadOffice HO = new HeadOffice();
	private static final long serialVersionUID = 546723911453041610L;//unique code for each object
	static JButton turnoff = new JButton("Turn off the machine");
	static JButton ClearReceipt = new JButton("Clear Current Receipt");
	static JButton GetnoofItems = new JButton("Get Number of Items");
	static JButton CreateUser = new JButton("Create a new user");
	static JButton UpdatePriceBtn = new JButton("Update Prices");
	static JTextArea JTA = new JTextArea(10,15);		
	
	
	JFrame HeadQuarterFrame;

	static JTextArea txtMachine = new JTextArea();
	static JTextArea txtitem = new JTextArea();
	static JTextArea txtengineer = new JTextArea();
	static JTextArea txttransaction = new JTextArea();
	

	static Vector<recyclingMachine> connection = new Vector<recyclingMachine>();
	
	public void addConnection(recyclingMachine rm) 
	{
		connection.add(rm);
		
	}
	
	public String showConnections()
	{
		String currCons = null;
		for (int f= 0; f<connection.size();f++)
		{
			currCons = currCons+connection.get(f).location;
		}
		
		return currCons;
	}
	
	public HeadOfficeGUITesting() {
		super();
		initialize();
		//HO.runServer();
//		setSize(800, 300);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
//		JPanel panel = new JPanel(); 
//		panel.add(turnoff); 
//		panel.add(ClearReceipt);
//		panel.add(GetnoofItems);
//		panel.add(CreateUser);
//		panel.add(UpdatePriceBtn);
//	
////		panel.add(JTA);
//		turnoff.addActionListener(HO);
//		ClearReceipt.addActionListener(HO);
//		GetnoofItems.addActionListener(HO);
//		CreateUser.addActionListener(HO);
//		UpdatePriceBtn.addActionListener(HO);
//		getContentPane().add(panel);
//		panel.repaint();
	
	}
	private void initialize() {
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
		conDevs.add(JTA);
		JTA.setBounds(20,15, 725, 330);
		JTA.setText(showConnections());

		JPanel conPanel = new JPanel();
		tabbedPane.addTab("Control Panel", null, conPanel, null);
		conPanel.setLayout(null);
		conPanel.setBackground(Color.gray);
		
	
		txtitem.setForeground(Color.black);
		txtitem.setBackground(Color.white);
		txtitem.setBounds(10, 11, 774, 450);
		conPanel.add(txtitem);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Usage Summary", null, panel_1, null);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.gray);
		txttransaction.setEditable(false);
		
		txttransaction.setForeground(Color.black);
		txttransaction.setBackground(Color.white);
		txttransaction.setBounds(10, 11, 774, 450);
		panel_1.add(txttransaction);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Administration", null, panel_2, null);
		panel_2.setLayout(null);
		panel_2.setBackground(Color.gray);
		
		txtengineer.setBackground(Color.white);
		txtengineer.setForeground(Color.black);
		txtengineer.setBounds(10, 11, 774, 450);
		panel_2.add(txtengineer);
		
	
		HeadQuarterFrame.setBackground(Color.gray);
		HeadQuarterFrame.getContentPane().setBackground(Color.gray);
		JLabel title = new JLabel("Head Office Login");
		title.setFont(new Font("Arial", Font.BOLD, 23));
		title.setForeground(Color.white);
		title.setBounds(300, 50, 200, 25);
		HeadQuarterFrame.getContentPane().add(title);
		

		
	}
	public static void main(String[] args) {
		HeadOfficeGUITesting HOGUI = new HeadOfficeGUITesting();
		
		HOGUI.HeadQuarterFrame.setVisible(true);
	
		
	}

}

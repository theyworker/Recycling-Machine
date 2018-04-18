package HeadOffice;

import javax.swing.*;
/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * @author Marc Conrad
 *
 */
public class HeadOfficeGUI extends JFrame  {
	/**
	 * 
	 */
	HeadOffice HO = new HeadOffice();
	private static final long serialVersionUID = 546723911453041610L;//unique code for each object
	static JButton turnoff = new JButton("Turn off the machine");
	static JButton ClearReceipt = new JButton("Clear Current Receipt");
	static JButton GetnoofItems = new JButton("Get Number of Items");
	static JButton CreateUser = new JButton("Create a new user");
//	public static JTextArea JTA = new JTextArea(10,15);		

	public HeadOfficeGUI() {
		super("Head Office");
		//HO.runServer();
		setSize(800, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.add(turnoff); 
		panel.add(ClearReceipt);
		panel.add(GetnoofItems);
		panel.add(CreateUser);
	
//		panel.add(JTA);
		turnoff.addActionListener(HO);
		ClearReceipt.addActionListener(HO);
		GetnoofItems.addActionListener(HO);
		CreateUser.addActionListener(HO);
		getContentPane().add(panel);
		panel.repaint();
	
	}


}

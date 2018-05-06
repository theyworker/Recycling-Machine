package HeadOffice.HOTesting;


import javax.swing.*;

import HeadOffice.HeadOffice;

/**
 * 
 * @author devaka
 * 
 *
 */
public class controlPnlWDW extends JFrame  {
	/**
	 * 
	 */

	private static final long serialVersionUID = 546723911453041610L;//unique code for each object

	String IP;
	public static JButton turnoff = new JButton("Turn off the machine");
	public static JButton ClearReceipt = new JButton("Clear Current Receipt");
	public static JButton GetnoofItems = new JButton("Get Number of Items");
	public static JButton UpdatePriceBtn = new JButton("Update Prices");
	HeadOffice HO = new HeadOffice();

	
	
	public controlPnlWDW() {
		super();

		//HO.runServer();
		setSize(800, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.add(turnoff); 
		panel.add(ClearReceipt);
		panel.add(GetnoofItems);
		
		panel.add(UpdatePriceBtn);
	
//		panel.add(JTA);
		turnoff.addActionListener(HO);
		ClearReceipt.addActionListener(HO);
		GetnoofItems.addActionListener(HO);
		;
		UpdatePriceBtn.addActionListener(HO);
		getContentPane().add(panel);
		panel.repaint();
	
	}
	
	

}

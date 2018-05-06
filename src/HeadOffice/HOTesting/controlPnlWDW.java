package HeadOffice.HOTesting;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Vector;

import javax.swing.*;

import org.apache.xmlrpc.XmlRpcClient;

import HeadOffice.HeadOffice;

/**
 * 
 * @author devaka
 * 
 *
 */
public class controlPnlWDW extends JFrame implements ActionListener  {
	/**
	 * 
	 */

	private static final long serialVersionUID = 546723911453041610L;//unique code for each object

	String targetURL;
	public static JButton turnoff = new JButton("Turn off the machine");
	public static JButton ClearReceipt = new JButton("Clear Current Receipt");
	public static JButton GetnoofItems = new JButton("Get Number of Items");
	public static JButton UpdatePriceBtn = new JButton("Update Prices");
	HeadOffice HO = new HeadOffice();
	String  RMurl = "http://localHost:1300/RPC2";
	String  RMurl11 = "http://127.0.1.1:1300/RPC2";
	String url1 = "http://";
	String url2 = ":1300/RPC2";
	
	
	public controlPnlWDW(String ip) {
		super();
		targetURL = url1+ip+url2;

		//HO.runServer();
		setSize(800, 300);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.add(turnoff); 
		panel.add(ClearReceipt);
		panel.add(GetnoofItems);
		
		panel.add(UpdatePriceBtn);
	
//		panel.add(JTA);
		turnoff.addActionListener(this);
		ClearReceipt.addActionListener(this);
		GetnoofItems.addActionListener(this);
		UpdatePriceBtn.addActionListener(this);
		getContentPane().add(panel);
		panel.repaint();
	
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(turnoff)) 
		{
			System.out.println(targetURL);
			terminateClient();
			
		}
		
	}
	public void terminateClient() {
		try {
			   XmlRpcClient server = new XmlRpcClient(targetURL); 
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

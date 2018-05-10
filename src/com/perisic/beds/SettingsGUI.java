package com.perisic.beds;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import org.apache.xmlrpc.XmlRpcClient;

/**
 * This is the Settings GUI of the Recycling Machine, only accessible by Engineers. Login details entered on to the GUI will be sent
 * to the Head Office via XMLRPC and verified.
 * @author devaka
 *
 */
public class SettingsGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea usrta = new JTextArea();
	JTextArea passta = new JTextArea();
	RecyclingGUI RG;
	
	JButton lgin = new JButton("Login");
	
	public SettingsGUI(RecyclingGUI rcg) {
		
		super();
		RG = rcg;
		setSize(400, 250);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.setLayout(null);
		
		JLabel usrname = new JLabel("Username:");
		panel.add(usrname);
		usrname.setBounds(60,60,100,30);
		
		JLabel psswrd = new JLabel("Password:");
		panel.add(psswrd);
		psswrd.setBounds(60,120,100,30);
		
		panel.add(usrta);
		usrta.setBounds(160, 67, 150, 16);
		
		panel.add(passta);
		passta.setBounds(160,127,150,16);
		
		panel.add(lgin);
		lgin.setBounds(140,180, 100,20 );
		lgin.addActionListener(this);


		getContentPane().add(panel);
		panel.repaint();
	
	}
	
	/**
	 * Validates the login details entered into the settings login.
	 * @param us
	 * @param psw
	 */
	public void Loginatmpt(String us, String psw)
	{
	
		try {
			   XmlRpcClient server = new XmlRpcClient("http://localHost:1600/RPC2"); 
			   Vector<String> params = new Vector<String>();
			   params.add(us);
			   params.add(psw);
			   Object result = server.execute("passwordmanager.checkEngCredentials", params);
			   if(result.equals("Auth")) 
			   {
				   params.clear();
				   String usercode = JOptionPane.showInputDialog("Please enter the 2FA Code");
				   params.add(us);
				   params.add(usercode);
				   String curCode = server.execute("passwordmanager.checkRemoteTwoFA", params).toString();
				   if(curCode.equals("Auth"))
				   {
					   this.setVisible(false);
					   EngineerGUI EngGUI = new EngineerGUI(RG,us);
					   EngGUI.setVisible(true);
				   }
				   }
			   else 
			   {
				   System.out.println("The Two Factor Code is wrong");
			   }
			}
			   
		catch (Exception ex) {
			   System.err.println("HelloClient: " + ex);
			   }
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(lgin)) {
			Loginatmpt(usrta.getText().trim(), passta.getText().trim());
			//fortesting(usrta.getText().trim(), passta.getText().trim());
		}
	}
}

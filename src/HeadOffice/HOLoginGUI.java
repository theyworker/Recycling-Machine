package HeadOffice;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 * A Simple Graphical User Interface for the Recycling Machine.
 * @author Marc Conrad
 *
 */
public class HOLoginGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTextArea usrta = new JTextArea();
	JTextArea passta = new JTextArea();
	HeadOfficeGUI HO;
	JButton lgin = new JButton("Login");
	
	public HOLoginGUI(HeadOfficeGUI HOGUI) {
		
		super("Recycling Inc. Head Office");
		this.HO = HOGUI;
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
	
	public void Loginatmpt(String us, String psw) throws FileNotFoundException, UnsupportedEncodingException, GeneralSecurityException
	{
	PasswordManager PswMngr = new PasswordManager();
	
	if(PswMngr.checkHOCredentials(us, psw).equals("Auth"))
		{
		String usercode = JOptionPane.showInputDialog("Please enter the 2FA Code");
		String currentCode= PswMngr.getCurrentCode(PswMngr.readTwoFAHODB(us));
		
			if(usercode.equals(currentCode)) 
			{
				this.setVisible(false);	
				HO.setVisible(true);
			}
			else 
			{
				System.out.println("Wrong 2FA code");
			}
		
		
		}	
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(lgin)) {
		
				try {
					Loginatmpt(usrta.getText().trim(), passta.getText().trim());
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (GeneralSecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
}

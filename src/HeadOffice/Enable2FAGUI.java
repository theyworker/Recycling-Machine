package HeadOffice;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.security.GeneralSecurityException;
import javax.imageio.ImageIO;
import javax.swing.*;

import com.j256.twofactorauth.TimeBasedOneTimePasswordUtil;

public class Enable2FAGUI extends JFrame implements ActionListener  {

	/**
	 * @author devaka
	 * 
	 * This window will display a QR code and will prompt the user for the current 2 Factor code that shown on the 3rd party app
	 * to proceed with the creation of a new user account
	 */
	String path;
	String base32Secret;
	JTextField usercode;
	JButton submit;
	String TypeofUser, username1, password1;
	private static final long serialVersionUID = 1L;

	public Enable2FAGUI(String username, String password, String type) throws IOException, GeneralSecurityException {
		super("Enable two factor Authentication");
		
		setSize(400, 390);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.setLayout(null);
		twofactorGenerate(username);
		this.TypeofUser = type;
		this.username1 = username;
		this.password1 = password;
		
		

		URL url = new URL(path);
		BufferedImage image = ImageIO.read(url.openStream());
		JLabel qrcode = new JLabel(new ImageIcon(image));
		panel.add(qrcode);
		qrcode.setBounds(50, 10, 250, 250);
		
		JLabel pls = new JLabel("<html>Please enter the code shown in the <br>Authenticator App:</html>");
		panel.add(pls);
		pls.setBounds(50, 250, 450, 40);
		
		usercode = new JTextField();
		panel.add(usercode);
		usercode.setBounds(50, 287, 250, 18);
		
		submit = new JButton("Finish");
		panel.add(submit);
		submit.setBounds(220, 320, 80, 20);
		submit.addActionListener(this);

		panel.setBackground(Color.white);
		getContentPane().add(panel);
		panel.repaint();
	
	}

	public void actionPerformed(ActionEvent e) 
	{

		if(e.getSource().equals(submit))
		{
			
				try {
					if(chkCurrent()) 
					{
						PasswordManager PM = new PasswordManager();
							if(TypeofUser.equals("HOadmin")) 
							{
		
								
								PM.addNewHO(username1, password1,base32Secret);
								this.setVisible(false);
							}
							else if(TypeofUser.equals("Engineer")) 
							{
								PM.addNewEng(username1, password1,base32Secret);
								this.setVisible(false);
							}
						
					}
					else
					{
					System.out.println("Code is wrong");
					}
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
	
	
	
	public void twofactorGenerate(String username) throws GeneralSecurityException 
	{
				base32Secret = TimeBasedOneTimePasswordUtil.generateBase32Secret();

				System.out.println("secret = " + base32Secret);

				// this is the name of the key which can be displayed by the authenticator program
				String keyId = "Recycling_Inc."+username;
				// generate the QR code
				path = TimeBasedOneTimePasswordUtil.qrImageUrl(keyId, base32Secret);
				// we can display this image to the user to let them load it into their auth program

				
	}
	
	public boolean chkCurrent() throws GeneralSecurityException 
	{
		String code = TimeBasedOneTimePasswordUtil.generateCurrentNumberString(base32Secret);
				
		if(usercode.getText().trim().equals(code))
		{
			return true;
		}
		else 
		{
			return false;
		}
	}


}

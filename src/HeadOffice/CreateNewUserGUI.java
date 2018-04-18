package HeadOffice;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.GeneralSecurityException;

import javax.swing.*;
/**
 * 
 * @author Marc Conrad
 *
 */
public class CreateNewUserGUI extends JFrame implements ActionListener  {

	/**
	 * 
	 */
	String TypeofUser = "";
	JButton submit = new JButton("Create New User");
	JTextField usernameField;
	JTextField passwordField;
	JTextField repasswordField;
	JTextArea ErrorDisp;
	private static final long serialVersionUID = 1L;

	public CreateNewUserGUI() {
		super("Create a new user");
		
		setSize(400, 320);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.setLayout(null);
		
		JLabel usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(65, 50, 100, 20);
		panel.add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(200, 50, 130, 20);
		panel.add(usernameField);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setBounds(65, 85, 100, 20);		
		panel.add(passwordLabel);
		
		passwordField = new JTextField();
		passwordField.setBounds(200, 85, 130, 20);		
		panel.add(passwordField);
		

		JLabel repasswordLabel = new JLabel("Re-type Password:");
		repasswordLabel.setBounds(65, 120, 150, 20);		
		panel.add(repasswordLabel);
		
		repasswordField = new JTextField();
		repasswordField.setBounds(200,120, 130, 20);		
		panel.add(repasswordField);
		
		JLabel userType = new JLabel("User Type:");
		userType.setBounds(65,155 ,150, 20);
		panel.add(userType);
		
		ButtonGroup bG = new ButtonGroup();
		
		JRadioButton HO = new JRadioButton("Head Office Admin");
		HO.setBackground(Color.WHITE);
		bG.add(HO);
		panel.add(HO);
		HO.setBounds(200, 155, 200, 20);
		HO.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TypeofUser = "HOadmin";				
			}
		});
		
		JRadioButton Eng = new JRadioButton("Engineer");
		Eng.setBackground(Color.WHITE);
		bG.add(Eng);
		panel.add(Eng);
		Eng.setBounds(200, 180, 200, 20);
		Eng.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TypeofUser = "Engineer";				
			}
		});
		
		
		submit.setBounds(100, 220, 180, 20);
		panel.add(submit);
		submit.addActionListener(this);
		
		JTextArea ErrorDisp = new JTextArea();
		ErrorDisp.setBounds(65, 255, 260, 30);
		ErrorDisp.setBackground(Color.white);
		panel.add(ErrorDisp);
		
		panel.setBackground(Color.white);
		getContentPane().add(panel);
		panel.repaint();
	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource().equals(submit) ) 
		{
			int errors = 0;
			String usrname = usernameField.getText().trim();
			if(usrname==null) {ErrorDisp.setText("Please enter a username");errors++;}
			String pss1 = passwordField.getText().trim();
			String pss2 = repasswordField.getText().trim();
			if(!pss1.equals(pss2)) {ErrorDisp.setText("The passwords don't match");errors++;}
			if(TypeofUser.equals("")) {errors++;}
			
			for(int i=0; i<usrname.length();i++) 
			{
				if(Character.isWhitespace(usrname.charAt(i))) 
				{
					errors++;
				}
			}
			
			if(errors==0) {
				Enable2FAGUI ENBfa;
				try {
					ENBfa = new Enable2FAGUI(usrname,pss1,TypeofUser);
					ENBfa.setVisible(true);
					this.setVisible(false);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (GeneralSecurityException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		
		}
		
	}



}

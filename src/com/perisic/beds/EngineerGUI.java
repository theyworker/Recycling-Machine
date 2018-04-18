package com.perisic.beds;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;


/**
 * A Simple Graphical User Interface for the Engineer to clear the Recycling Machine.
 * @author devaka
 *
 */
public class EngineerGUI extends JFrame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RecyclingGUI RGG;
	String currentUser;
	JButton Rst = new JButton("Empty Recycling Machine");
	JButton Stats = new JButton("Statistics");
	JTextArea EngTA = new JTextArea();
	
	
	
	public EngineerGUI(RecyclingGUI rg,String user) {
		
		super();
		RGG = rg;
		currentUser = user;
		setSize(320, 380);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
		JPanel panel = new JPanel(); 
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		
		
		panel.add(Rst);
		Rst.setBounds(10,250, 300,30 );
		Rst.addActionListener(this);
		
		panel.add(Stats);
		Stats.setBounds(10,300, 300, 30);
		Stats.addActionListener(this);
		
		JLabel Welcomemsg = new JLabel("Hello "+currentUser+"!");
		panel.add(Welcomemsg);
		Welcomemsg.setBounds(10, 10, 200, 20);
		
		panel.add(EngTA);
		EngTA.setBounds(10, 40, 300, 190);
		EngTA.setBackground(Color.WHITE);
		EngTA.setEditable(false);
		


		getContentPane().add(panel);
		panel.repaint();
	
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource().equals(Rst))
		{
			RGG.thepanel.numOfItems = 0;
			RGG.thepanel.receiver.clearReceipt();
			StatsHub.AddEngResetsStat();
			ConsoleLog.printlog("Recycling Machine was Emptied by Engineer-"+currentUser);
			EngTA.setText("The Recycling Machine was emptied sucessfully");
		}
		else if(e.getSource().equals(Stats))
		{
			EngTA.setText(StatsHub.printStat());
		}
	}
}

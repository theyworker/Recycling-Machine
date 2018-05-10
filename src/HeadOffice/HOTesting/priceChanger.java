package HeadOffice.HOTesting;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import HeadOffice.PricingManager;


/**
 * 
 * @author devaka
 * 
 *
 */
public class priceChanger extends JFrame implements ActionListener  {

	JTextArea dispCurrPrices = new JTextArea();
	private static final long serialVersionUID = 1L;
	
	static PricingManager pm = new PricingManager();
	
	JLabel enterPrices = new JLabel("<html>Enter the new values <br/>(Leave blank to keep the existing price)</html>");

	//Can
	JLabel canLBL = new JLabel("Can :");
	JTextField canUsrTxt = new JTextField();
	//Crate
	JLabel crateLBL = new JLabel("Crate :");
	JTextField crateUsrTxt = new JTextField();
	//Poly
	JLabel polyLBL = new JLabel("Polythene Bag :");
	JTextField polyUsrTxt = new JTextField();
	//Paper
	JLabel paperLBL = new JLabel("Paper Bag :");
	JTextField paperUsrTxt = new JTextField();
	//Plastic Bottle
	JLabel plasticLBL = new JLabel("Plastic Bottle :");
	JTextField plasticUsrTxt = new JTextField();
	//Glass Bottle
	JLabel glassLBL = new JLabel("Glass Bottle :");
	JTextField glassUsrTxt = new JTextField();
	
	
	JButton updtPrices = new JButton("Update Prices");
	

	public priceChanger(final HeadOfficeGUI Ho) {
		super("Update Prices");

		setSize(300, 440);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);	
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.add(dispCurrPrices);
		panel.add(enterPrices);
		panel.add(canLBL);
		panel.add(canUsrTxt);
		
		dispCurrPrices.setEditable(false);
		dispCurrPrices.setText(pm.printCurrPrices());;
		dispCurrPrices.setBounds(10, 10, 380, 90);
		enterPrices.setBounds(10, 120, 300,60);
		
		panel.add(canLBL);
		panel.add(canUsrTxt);
		
		panel.add(crateLBL);
		panel.add(crateUsrTxt);
		
		panel.add(polyLBL);
		panel.add(polyUsrTxt);
		
		panel.add(paperLBL);
		panel.add(paperUsrTxt);
		
		panel.add(plasticLBL);
		panel.add(plasticUsrTxt);
		
		panel.add(glassLBL);
		panel.add(glassUsrTxt);
		
		panel.add(updtPrices);
		
		canLBL.setBounds(10, 200, 70, 20);
		canUsrTxt.setBounds(130, 200, 150, 20);
		
		crateLBL.setBounds(10, 230, 70, 20);
		crateUsrTxt.setBounds(130, 230, 150, 20);
		
		polyLBL.setBounds(10, 260, 120, 20);
		polyUsrTxt.setBounds(130, 260, 150, 20);
		
		paperLBL.setBounds(10, 290, 120, 20);
		paperUsrTxt.setBounds(130, 290, 150, 20);
		
		plasticLBL.setBounds(10, 320, 120, 20);
		plasticUsrTxt.setBounds(130, 320, 150, 20);
		
		glassLBL.setBounds(10, 350, 120, 20);
		glassUsrTxt.setBounds(130, 350, 150, 20);
		
		updtPrices.setBounds(75, 390, 150, 30);
		updtPrices.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				JOptionPane.showConfirmDialog(null, "Are you Sure you want to update prices?");
				
				if(dialogButton == JOptionPane.YES_OPTION)
				{
					if(!canUsrTxt.getText().isEmpty())
					{
						int can = Integer.valueOf(canUsrTxt.getText().trim());
						pm.changeValue("Can", can);
					}
					
					if(!crateUsrTxt.getText().isEmpty())
					{
						int crate = Integer.valueOf(crateUsrTxt.getText().trim());
						pm.changeValue("Crate", crate);
					}
					
					if(!polyUsrTxt.getText().isEmpty()) 
					{
						int poly = Integer.valueOf(polyUsrTxt.getText().trim());
						pm.changeValue("PolytheneBag", poly);
					}
	
					if(!paperUsrTxt.getText().isEmpty())
					{
						int paper = Integer.valueOf(paperUsrTxt.getText().trim());
						pm.changeValue("PaperBag", paper);
					}
	
					if(!plasticUsrTxt.getText().isEmpty())
					{
						int plastic = Integer.valueOf(plasticUsrTxt.getText().trim());
						pm.changeValue("PlasticBottle", plastic);
					}
					if(!glassUsrTxt.getText().isEmpty())
					{
						int glass = Integer.valueOf(glassUsrTxt.getText().trim());
						pm.changeValue("GlassBottle", glass);
					}
					pm.SaveStats();
					Ho.pushPricestoALL(pm);
					
					
				}
				
			}
		});
		
		getContentPane().add(panel);
		panel.repaint();
	
	}



	@Override
	public void actionPerformed(ActionEvent e) {
//		if(e.getSource().equal)) 
//		{
//			terminateClient();
//			
//		}
//		else if(e.getSource().equals(priceChanger.ClearReceipt))
//		{
//			clearReceiptClient();
//		}
//		else if(e.getSource().equals(priceChanger.GetnoofItems))
//		{
//			getNumofItemsClient();
//		}
		
		
	}
	
	

}

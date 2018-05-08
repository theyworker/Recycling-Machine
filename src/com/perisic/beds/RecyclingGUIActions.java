package com.perisic.beds;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.perisic.beds.Stats.StatsHub;

/**
 * Functions as the Action Listener for the buttons in the Recycling GUI.
 * @author devaka
 *
 */
public class RecyclingGUIActions implements ActionListener {
	CustomerPanel thepanel;
	RecyclingGUI RGUI;
	public RecyclingGUIActions(CustomerPanel cst, RecyclingGUI rg) {
		super();
		thepanel = cst;
		RGUI = rg;
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		RecyclingGUI.resetTimer();
		StatsHub.sendStats(RGUI.sessionCookie);
		
		/*
		*For testing purposes:
			 *1 for Can
			 *2 for Glass Bottle
			 *3 for Crate
			 *4 for Paper Bag
			 *5 forPlastic Bottle
			 */

		if(e.getSource().equals(RecyclingGUI.slot1))
		{
			
			ConsoleLog.printlog("Can was inserted into the Recycling Machine");
			thepanel.itemReceived(1);
			
		}
		else if(e.getSource().equals(RecyclingGUI.slot2))
		{
			ConsoleLog.printlog("Crate was inserted into the Recycling Machine");
			thepanel.itemReceived(3);
		}
		
		else if(e.getSource().equals(RecyclingGUI.slot3))
		{
			
			ConsoleLog.printlog("Glass Bottle was inserted into the Recycling Machine");
			thepanel.itemReceived(2);
		}
		else if(e.getSource().equals(RecyclingGUI.slot4)) 
		{
			
			ConsoleLog.printlog("Paper Bag was inserted into the Recycling Machine");
			thepanel.itemReceived(4);
		
		}
		else if(e.getSource().equals(RecyclingGUI.slot5)) 
		{
			
			ConsoleLog.printlog("Plastic Bottle was inserted into the Recycling Machine");
			thepanel.itemReceived(5);
			
		}
		
		else if(e.getSource().equals(RecyclingGUI.slot6))
		{
			ConsoleLog.printlog("Polythene Bag was inserted into the Recycling Machine");
			thepanel.itemReceived(6);
		}
		else if(e.getSource().equals(RecyclingGUI.receipt))
		{
			StatsHub.AddtotalWeightDepositedStat(thepanel.getTW());
			StatsHub.AddtotalSizeDepositeddStat(thepanel.getTS());
			thepanel.printReceipt();
			ConsoleLog.printlog("Receipt printed");
			RecyclingGUI.rmvlast.setVisible(false);	
			StatsHub.AddReceiptStat();
			
			
			
			RGUI.resetFunctions();
		}
		else if(e.getSource().equals(RecyclingGUI.clr))
		{
			RecyclingGUI.JT.setText("");
			ConsoleLog.printlog("Screen was cleared");
			thepanel.correctionofNumItem(thepanel.getNumofItems());
			thepanel.receiver.clearReceipt();
			StatsHub.AddNumClrStats();
			
			RGUI.resetFunctions();
			
		}
		
		else if(e.getSource().equals(RecyclingGUI.rmvlast))
		{
			thepanel.removeLastItem();
			StatsHub.AddnumofundoStat();
		}
		else if(e.getSource().equals(RecyclingGUI.settings))
		{
			SettingsGUI SGUI = new SettingsGUI(RGUI);
			SGUI.setVisible(true);
		}
		
//		int w = (int) thepanel.getTW();
//		int sz =(int) thepanel.getTS();
		
		RecyclingGUI.pbw.setValue((int) thepanel.getTW());
		RecyclingGUI.pbsz.setValue((int) thepanel.getTS());
		
		if(thepanel.numOfItems>0) 
		{
		RecyclingGUI.rmvlast.setVisible(true);	
		}
		else
		{
		RecyclingGUI.rmvlast.setVisible(false);
		}
		
	}

}

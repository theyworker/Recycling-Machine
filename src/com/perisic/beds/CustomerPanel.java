package com.perisic.beds;


/**
 * @author Marc Conrad
 *
 */

/**
 * This is the class that enables end-user to interact with the system.
 */
public class CustomerPanel {
	DepositItemReceiver receiver = null; 
	int numOfItems = 0;
	
	public CustomerPanel(PrinterInterface prnt) {
		super();
		this.receiver = new DepositItemReceiver(prnt);
		
	}
	/**
	 * @param slot 
	 */
	public void itemReceived(int slot) { 
		/**
		 * When an item is received slot number needs to be passed as a parameter. 
		 * Then this method checks whether the machine is already full.
		 * Max capacity of machine:
		 * 	Total Size - 1000(±5)
		 * 	Total Weight - 1520(±5)
		 */
		double TS = receiver.getTotalS();
		double TW = receiver.getTotalW();
		if(TW<1516) 
		{ 
			if(TS<1000)
			{
				receiver.classifyItem(slot,TW,TS);
				numOfItems++;
				
			}
			else 
			{
				ConsoleLog.printlog("The Recycling Machine has reached the maximum size.");
				receiver.printError("The Recycling Machine has reached the maximum size.  \n Please enter your item in the next session!");
			}
		}
		else {
			ConsoleLog.printlog("The Recycling Machine has reached the maximum weight!");
			receiver.printError("The Recycling Machine has reached the maximum weight! \n Please try again in the next sessions.");
		}
	}

	public void printReceipt() { 
		receiver.printReceipt();
	}
	public double getTW()
	{
		return receiver.getTotalW();
	}
	public double getTS()
	{
		return receiver.getTotalS();
	}
	
	public int getNumofItems()
	{
		return numOfItems;
	}
	
	public void correctionofNumItem(int amountclred)
	{
		numOfItems -= amountclred;
	}
	
	public void removeLastItem()
	{
		numOfItems--;
		receiver.removeLastItem();
	}
}


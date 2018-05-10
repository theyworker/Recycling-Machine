package com.perisic.beds;


/**
 * @author Marc Conrad
 *
 */

/**
 * This is the class that enables end-user to interact with the system.
 * 
 */
public class CustomerPanel {
	DepositItemReceiver receiver = null; 
	int numOfItems = 0;
	
	public CustomerPanel(PrinterInterface prnt) {
		super();
		this.receiver = new DepositItemReceiver(prnt);
		
	}
	/**This method should be called from any interface that the user is able to deposit items.
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
/**
 * This method is called to print a receipt on to the user interface.
 */
	public void printReceipt() { 
		receiver.printReceipt();
	}
	
	/**
	 * Returns the current weight of the items that have already been deposited into the machine.
	 * @return getTotalW()
	 */
	public double getTW()
	{
		return receiver.getTotalW();
	}
	
	/**
	 * Returns the current size of the items that have already been deposited into the machine.
	 * @return getTotalS()
	 */
	public double getTS()
	{
		return receiver.getTotalS();
	}
	
	/**
	 * Returns the number of items inside the machine at that moment
	 * @return numOfItems
	 */
	public int getNumofItems()
	{
		return numOfItems;
	}
	
	/**
	 * If the user clears after depositing some items, they will be deducted from the total number of items.
	 * @param amountclred
	 */
	public void correctionofNumItem(int amountclred)
	{
		numOfItems -= amountclred;
	}
	
	/**
	 * Removes the last added item by the user.
	 */
	public void removeLastItem()
	{
		numOfItems--; //deducts the numofItems by 1
		receiver.removeLastItem();
	}
}


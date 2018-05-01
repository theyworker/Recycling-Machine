package com.perisic.beds.DepositItems;

import com.perisic.beds.Pricing.CurrentPrices;

/**
 * @author Marc Conrad
 *
 */
public class Can extends DepositItem {
	public static int weight = 4; 
	public static int size = 5;
	
	/**
	 * @author devaka
	 * This is Can class, a sub-class of Deposit Item
	 */
	public Can() { 
//		try {
//			value = ItemReader.getValueOf("can");
//		} catch (Exception e) {
//			ConsoleLog.printlog("Unable to get values from the server");
//			e.printStackTrace();
		
		value = CurrentPrices.getCanPrice();
		name = "Can";
	
		// }
		
		
	}
	
	public void changeVal(int newVal)
	{
		value = newVal;
	}
	

}

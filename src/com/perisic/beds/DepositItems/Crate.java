package com.perisic.beds.DepositItems;

import com.perisic.beds.Pricing.CurrentPrices;

/**
 * @author Marc Conrad
 *
 */
public class Crate extends DepositItem {
	public static int weight = 1516; 
	public static int size = 90; 
	/**
	 * 
	 */
	public Crate() { 
//		try {
//			value = ItemReader.getValueOf("crate");
//		} catch (Exception e) {
//			ConsoleLog.printlog("Unable to get values from the server");
//			e.printStackTrace();
			value = CurrentPrices.getCratePrice();
		// }
		name = "Crate";
	}
}

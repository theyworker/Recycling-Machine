package com.perisic.beds;

import com.perisic.beds.Pricing.CurrentPrices;

/**
 * @author Marc Conrad
 *
 */
public class PaperBag extends Bag {
	static int weight = 1; 
	static int size = 4; 
	/**
	 * @author devaka
	 * This is Bag class, a sub-class of Deposit Item
	 */
	public PaperBag() { 
//		try {
//			value = ItemReader.getValueOf("paperbag");
//		} catch (Exception e) {
//			ConsoleLog.printlog("Unable to get values from the server");
//			e.printStackTrace();
			value = CurrentPrices.getPaperbagPrice();
	//	} 
		name = "Paper Bag";
	}
}

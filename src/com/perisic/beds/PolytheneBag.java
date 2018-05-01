package com.perisic.beds;

import com.perisic.beds.Pricing.CurrentPrices;

public class PolytheneBag extends Bag {
	static int weight = 1; 
	static int size = 2; 
	/**
	 * @author devaka
	 * This is Polythene Bag class, a sub-class of Bag
	 */
	public PolytheneBag() { 
//		try {
//			value = ItemReader.getValueOf("polythenebag");
//		} catch (Exception e) {
//			ConsoleLog.printlog("Unable to get values from the server");
//			e.printStackTrace();
			value = CurrentPrices.getPolythenebagPrice();
	//	} 
		name = "Polythene Bag";
	}
}

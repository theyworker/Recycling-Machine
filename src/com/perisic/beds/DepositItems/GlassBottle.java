package com.perisic.beds.DepositItems;

import com.perisic.beds.Pricing.CurrentPrices;

public class GlassBottle extends Bottle {

	public static int weight = 10; 
	public static int size = 8; 
	/**
	 * @author devaka
	 * This is Bottle class, a sub-class of Deposit Item
	 */
	public GlassBottle() { 
//		try {
//			value = ItemReader.getValueOf("glassbottle");
//		} catch (Exception e) {
//			ConsoleLog.printlog("Unable to get values from the server");
//			e.printStackTrace();
			value = CurrentPrices.getGlassbottlePrice();
		// }
		name = "Glass Bottle";
	}
}

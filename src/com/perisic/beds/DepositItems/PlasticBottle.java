package com.perisic.beds.DepositItems;

import com.perisic.beds.Pricing.CurrentPrices;

public class PlasticBottle extends Bottle {
	public static int weight = 10; 
	public static int size = 8; 
	/**
	 * @author devaka
	 * This is Bottle class, a sub-class of Deposit Item
	 */
	public PlasticBottle() { 
		
//			try {
//				value = ItemReader.getValueOf("plasticbottle");
//			} catch (Exception e) {
//				ConsoleLog.printlog("Unable to get values from the server");
//				e.printStackTrace();
				value = CurrentPrices.getPlasticBagPrice();
		//	}
		name = "Plastic Bottle";
	}
}

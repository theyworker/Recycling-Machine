package com.perisic.beds;

public class PlasticBottle extends Bottle {
	static int weight = 10; 
	static int size = 8; 
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
				value = 14;
		//	}
		name = "Plastic Bottle";
	}
}

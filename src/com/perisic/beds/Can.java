package com.perisic.beds;

/**
 * @author Marc Conrad
 *
 */
public class Can extends DepositItem {
	static int weight = 4; 
	static int size = 5;
	
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
			value = 12;
		name = "Can";
	
		// }
		
	}
}

package com.perisic.beds;

/**
 * @author Marc Conrad
 *
 */
public class Crate extends DepositItem {
	static int weight = 1516; 
	static int size = 90; 
	/**
	 * 
	 */
	public Crate() { 
//		try {
//			value = ItemReader.getValueOf("crate");
//		} catch (Exception e) {
//			ConsoleLog.printlog("Unable to get values from the server");
//			e.printStackTrace();
			value = 25;
		// }
		name = "Crate";
	}
}

package com.perisic.beds.DepositItems;

/**
 * @author Marc Conrad
 *
 */
public class Bottle extends DepositItem {
	static int weight = 10; 
	static int size = 8; 
	/**
	 * @author devaka
	 * This is Bottle class, a sub-class of Deposit Item
	 * This class further extends into Glass Bottles and Plastic Bottles
	 */
	public Bottle() { 
		value = 0; 
		name = null;
	}
}
package com.perisic.beds.DepositItems;

import com.perisic.beds.Pricing.CurrentPrices;

/**
 * @author Marc Conrad
 *
 */
public class PaperBag extends Bag {
	public static int weight = 1; 
	public static int size = 4; 
	/**
	 * @author devaka
	 * This is Bag class, a sub-class of Deposit Item
	 */
	public PaperBag() { 

			value = CurrentPrices.getPaperbagPrice();

		name = "Paper Bag";
	}
}

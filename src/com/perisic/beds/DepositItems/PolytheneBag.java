package com.perisic.beds.DepositItems;

import com.perisic.beds.Pricing.CurrentPrices;

public class PolytheneBag extends Bag {
	public static int weight = 1; 
	public static int size = 2; 
	/**
	 * @author devaka
	 * This is Polythene Bag class, a sub-class of Bag
	 */
	public PolytheneBag() { 

			value = CurrentPrices.getPolythenebagPrice();

		name = "Polythene Bag";
	}
}

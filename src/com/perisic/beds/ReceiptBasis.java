package com.perisic.beds;
import java.util.Vector;

import com.perisic.beds.DepositItems.DepositItem;
import com.perisic.beds.Stats.StatsHub; 

/**
 * @author Marc Conrad
 *
 */
public class ReceiptBasis {
	int sum = 0; 
	int total = 0;
	int countCan = 0;int countCrate = 0; int countPaperBag = 0; int countGlassBottle = 0;int countPlasticBottle =0; int countPolythenBag = 0;
	private Vector<DepositItem> myItems = new Vector<DepositItem>();
	int vecIndx=-1;
	/**
	 * @param item
	 */
	public void addItem(DepositItem item) { 
		myItems.add(item); 
		item.number = myItems.indexOf(item); 
		vecIndx = item.number;
	}
	
	public DepositItem removeLastItem()
	{
		if(vecIndx!=-1)
		{
		DepositItem temp = myItems.remove(vecIndx--);
		total--;
		return temp;
		}
		else
		{
			RecyclingGUI.JT.setText("No items left");
			return null;
		}
	}
	
	/**
	 * @return
	 */
	public String computeSum() { 
		String receipt = ""; 
		
		for(int i=0; i < myItems.size(); i++ ) {
			DepositItem item = myItems.get(i); 
			receipt = receipt + (item.number+1) +": "+item.value+" "+item.name; 
			receipt = receipt + System.getProperty("line.separator");
			sum = sum + item.value; 
			
			if(item.name=="Plastic Bottle")
			{
				countPlasticBottle++;
				StatsHub.AddtotalPlasticBagsStats();
			}
			
			else if(item.name=="Glass Bottle")
			{
				countGlassBottle++;
				StatsHub.AddtotalGlassBottlesStats();
			}
			else if (item.name=="Paper Bag")
			{
				countPaperBag++;
				StatsHub.AddtotalPaperBagsStats();
			}
			else if (item.name=="Crate")
			{
				countCrate++;
				StatsHub.AddtotalCratesStats();
			}
			
			else if(item.name=="Can")
			{
				countCan++;
				StatsHub.AddtotalCansStats();
			}
			
			else if(item.name=="Polythene Bag")
			{
				countPolythenBag++;
				StatsHub.AddtotalPolythenebagsStats();
			}
			total++;
		}
		receipt = receipt + "\n======== \n Total: "+sum+"\n========\n \n Total number of Cans: "+countCan+ "\n Total number of Crates: "+countCrate+"\n Total number of Paper Bags: "+countPaperBag+"\n Total number of Glass Bottles: "+countGlassBottle+"\n Total number of Plastic Bottles: "+countPlasticBottle+"\n Total number of Polythene Bags: "+countPolythenBag; 
		
		return receipt; 
	}
	
	public int getTotalinRcpt()
	{
		return total;
	}
}

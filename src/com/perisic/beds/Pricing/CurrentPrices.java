package com.perisic.beds.Pricing;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
/**
 * This class manages the current values of all the types of Deposit items. 
 * @author devaka
 *
 */
public class CurrentPrices {
	static int pricecan, pricecrate, priceglassbottle, priceplasticbottle, pricepaperbag, pricePolythenebag;

	static File priceFile = new File("/home/devaka/workspace/Recycling Machine/src/com/perisic/beds/Pricing/currPrices.txt"); // add the file here

	
	public void loadPrices()	
	{

	    try {

	        Scanner sc = new Scanner(priceFile);

	        
	        pricecan = Integer.valueOf(sc.nextLine());
	        pricecrate= Integer.valueOf(sc.nextLine());
	        pricePolythenebag= Integer.valueOf(sc.nextLine());
	        pricepaperbag= Integer.valueOf(sc.nextLine());
	        priceplasticbottle = Integer.valueOf(sc.nextLine());
	        priceglassbottle = Integer.valueOf(sc.nextLine());
	   
	        sc.close();



	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	        
	    }
	    
	}
	
	public void SavePrices()
	{
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileOutputStream(priceFile));
			
			writer.println(pricecan);
			writer.println(pricecrate);
			writer.println(pricePolythenebag);
			writer.println(pricepaperbag);
			writer.println(priceplasticbottle);
			writer.println(priceglassbottle);
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static int getCanPrice() 
	{
		return pricecan;
	}
	public static int getCratePrice() 
	{
		return pricecrate;
	}
	
	public static int getPolythenebagPrice() 
	{
		return pricePolythenebag;
	}
	
	public static int getPaperbagPrice()
	{
		return pricepaperbag;
	}
	public static int getPlasticBagPrice() 
	{
		return priceplasticbottle;
	}
	public static int getGlassbottlePrice() 
	{
		return priceglassbottle;
	}
	
	public void changeCanPrice(String newVal) 
	{
		pricecan = Integer.valueOf(newVal);

	}
	public  void changeCratePrice(String newVal) 
	{
		pricecrate = Integer.valueOf(newVal);
	
	}
	
	public void changePolythenebagPrice(String newVal) 
	{
		pricePolythenebag = Integer.valueOf(newVal);
	
	}
	
	public void changePaperbagPrice(String newVal)
	{
		pricepaperbag = Integer.valueOf(newVal);
	
	}
	public void changePlasticBagPrice(String newVal) 
	{
		priceplasticbottle= Integer.valueOf(newVal);
	
	}
	public void changeGlassbottlePrice(String newVal) 
	{
		priceglassbottle= Integer.valueOf(newVal);
		
	}
	
	public String updatePrices(String can, String crate, String poly, String PaperBag, String PlasticBg, String GlassBottle)
	{
		changeCanPrice(can);
		changeCratePrice(crate);
		changePolythenebagPrice(poly);
		changePaperbagPrice(PaperBag);
		changePlasticBagPrice(PlasticBg);
		changeGlassbottlePrice(GlassBottle);
		SavePrices();
		return "Prices Updated";
	}
	
}

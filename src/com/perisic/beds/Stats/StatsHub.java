package com.perisic.beds.Stats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class StatsHub {
	static int receipts;
	static int numofitems;
	static int numofclr;
	static int numofundo;
	static int totalCans, totalCrates,totalGlassBottles, totalPaperBags, totalPolythenebags, totalPlasticBags;
	static int autoResets;
	static int EngResets;
	static double totalWeightDeposited = 0 , totalSizeDeposited = 0;
	
	static File statFile = new File("/home/devaka/workspace/Recycling Machine/src/com/perisic/beds/Stats/Stats.txt");
	
	
	public static void AddReceiptStat()
	{
		receipts++;
	}
	
	public static void AddNumItemsStats()
	{
		numofitems++;
	}
	
	public static void AddNumClrStats() 
	{
		numofclr++;
	}
	
	public static void AddtotalCansStats() 
	{
		totalCans++;
		AddNumItemsStats();
	}
	public static void AddtotalCratesStats() 
	{
		totalCrates++;
		AddNumItemsStats();
	}
	public static void AddtotalGlassBottlesStats() 
	{
		totalGlassBottles++;
		AddNumItemsStats();
	}
	public static void AddtotalPaperBagsStats() 
	{
		totalPaperBags++;
		AddNumItemsStats();
	}
	public static void AddtotalPolythenebagsStats() 
	{
		totalPolythenebags++;
		AddNumItemsStats();
	}
	public static void AddtotalPlasticBagsStats() 
	{
		totalPlasticBags++;
		AddNumItemsStats();
	}
	public static void AddautoResetsStats() 
	{
		autoResets++;
	}
	public static void AddnumofundoStat()
	{
		numofundo++;
	}
	public static void AddtotalWeightDepositedStat(double addweight)
	{
		totalWeightDeposited+=addweight;
	}
	
	public static void AddEngResetsStat()
	{
		EngResets++;
	}
	public static void AddtotalSizeDepositeddStat(double addSize)
	{
		totalSizeDeposited+=addSize;
	}
	
	public static void SaveStats()
	{
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileOutputStream(statFile));
			
			writer.println(receipts);
			writer.println(numofitems);
			writer.println(numofclr);
			writer.println(numofundo);
			writer.println(totalCans);
			writer.println(totalCrates);
			writer.println(totalGlassBottles);
			writer.println(totalPaperBags);
			writer.println(totalPolythenebags);
			writer.println(totalPlasticBags);
			writer.println(autoResets);
			writer.println(EngResets);
			writer.println(totalWeightDeposited);
			writer.println(totalSizeDeposited);
			writer.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void getStats()	
	{

	    try {

	        Scanner sc = new Scanner(statFile);

	        
	        receipts = Integer.valueOf(sc.nextLine());
			numofitems= Integer.valueOf(sc.nextLine());
			numofclr= Integer.valueOf(sc.nextLine());
			numofundo= Integer.valueOf(sc.nextLine());
			totalCans = Integer.valueOf(sc.nextLine());
			totalCrates = Integer.valueOf(sc.nextLine());
			totalGlassBottles = Integer.valueOf(sc.nextLine());
			totalPaperBags = Integer.valueOf(sc.nextLine());
			totalPolythenebags = Integer.valueOf(sc.nextLine());
			totalPlasticBags = Integer.valueOf(sc.nextLine());
			autoResets = Integer.valueOf(sc.nextLine());
			EngResets = Integer.valueOf(sc.nextLine());
			totalWeightDeposited = Double.valueOf(sc.nextLine());
			totalSizeDeposited = Double.valueOf(sc.nextLine());
	        
	   
	        sc.close();


	        
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	        
	    }
	    
	}
	
	public static String printStat() 
	{
		return ("Total Number of Receipts: "+receipts+"\nTotal Number of items: "+numofitems+"\nTotal Number of Screen Clears: "+numofclr+"\nTotal Number of Undos: "+numofundo+"\nTotal Number of time-outs: "+autoResets+"\nTotal Resets by an Engineer: "+EngResets+"\nTotal Weight deposited: "+totalWeightDeposited+"\nTotal Size deposited: "+totalSizeDeposited);
	}
	

	
}

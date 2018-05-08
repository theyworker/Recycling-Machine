package com.perisic.beds.Stats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;
/**
 * This class keeps track of the statistics of the Recycling Machine
 * @author devaka
 *
 */
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
	static XmlRpcClient server;
	
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
		addCan();
		
	}
	public static void AddtotalCratesStats() 
	{
		totalCrates++;
		AddNumItemsStats();
		addCrate();
	}
	public static void AddtotalGlassBottlesStats() 
	{
		totalGlassBottles++;
		AddNumItemsStats();
		addGlassBttle();
	}
	public static void AddtotalPaperBagsStats() 
	{
		totalPaperBags++;
		AddNumItemsStats();
		addPaperBags();
	}
	public static void AddtotalPolythenebagsStats() 
	{
		totalPolythenebags++;
		AddNumItemsStats();
		addPolyBags();
	}
	public static void AddtotalPlasticBagsStats() 
	{
		totalPlasticBags++;
		AddNumItemsStats();
		addPlasticBttl();
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
	
	public static void sendStats(String sessionCookie)
	{	
//		getStats();
//		 XmlRpcClient server;
//		try {
//			server = new XmlRpcClient("http://localHost:1200/RPC2");
//			   Vector<String> params = new Vector<String>();
//			   params.add(sessionCookie);
//			   params.add(Integer.toString(receipts));
//			   params.add(Integer.toString(numofitems));
//			   params.add(Integer.toString(totalCans));
//			   params.add(Integer.toString(totalCrates));
//			   params.add(Integer.toString(totalGlassBottles));
//			   params.add(Integer.toString(totalPaperBags));
//			   params.add(Integer.toString(totalPolythenebags));
//			   params.add(Integer.toString(totalPlasticBags));
//
//			   try {
//				Object result = server.execute("usage.statInput", params);
//				System.out.println(result.toString());
//			} catch (XmlRpcException | IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 

		   
	}
	
	public static void addCan()
	{
		 XmlRpcClient server;
		try {
			server = new XmlRpcClient("http://localHost:1200/RPC2");
			   Vector<String> params = new Vector<String>();
			   try {
				Object result = server.execute("usage.addCan", params);
				
			} catch (XmlRpcException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void addCrate()
	{
		try {
			server = new XmlRpcClient("http://localHost:1200/RPC2");
			   Vector<String> params = new Vector<String>();
			   try {
				Object result = server.execute("usage.addCrate", params);
				
			} catch (XmlRpcException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void addGlassBttle()
	{
		try {
			server = new XmlRpcClient("http://localHost:1200/RPC2");
			   Vector<String> params = new Vector<String>();
			   try {
				Object result = server.execute("usage.addGlassbtl", params);
				
			} catch (XmlRpcException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void addPlasticBttl()
	{
		try {
			server = new XmlRpcClient("http://localHost:1200/RPC2");
			   Vector<String> params = new Vector<String>();
			   try {
				Object result = server.execute("usage.addPlasticBottles", params);
				
			} catch (XmlRpcException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void addPaperBags()
	{
		try {
			server = new XmlRpcClient("http://localHost:1200/RPC2");
			   Vector<String> params = new Vector<String>();
			   try {
				Object result = server.execute("usage.addPaperBags", params);
				
			} catch (XmlRpcException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	public static void addPolyBags() 
	{
		try {
			server = new XmlRpcClient("http://localHost:1200/RPC2");
			   Vector<String> params = new Vector<String>();
			   try {
				Object result = server.execute("usage.addPolyBags", params);
				
			} catch (XmlRpcException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static String printStat() 
	{
		return ("Total Number of Receipts: "+receipts+"\nTotal Number of items: "+numofitems+"\nTotal Number of Screen Clears: "+numofclr+"\nTotal Number of Undos: "+numofundo+"\nTotal Number of time-outs: "+autoResets+"\nTotal Resets by an Engineer: "+EngResets+"\nTotal Weight deposited: "+totalWeightDeposited+"\nTotal Size deposited: "+totalSizeDeposited);
	}
	

	

	
}

package HeadOffice.Stats;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.util.Vector;

import javax.xml.transform.Templates;
import javax.xml.ws.Holder;

import org.apache.xmlrpc.XmlRpcClient;
import org.apache.xmlrpc.XmlRpcException;

import HeadOffice.HOLoginGUI;
import HeadOffice.HeadOffice;
import HeadOffice.HOTesting.HeadOfficeGUI;
/**
 * This class keeps track of the statistics of the entire system
 * @author devaka
 *
 */
public class StatsHO {


	static int receipts;
	static int numofitems;
	static int numofclr;
	static int numofundo;
	static int totalCans, totalCrates,totalGlassBottles, totalPaperBags, totalPolythenebags, totalPlasticBags;
	static int autoResets;
	static int EngResets;
	static double totalWeightDeposited = 0 , totalSizeDeposited = 0;

	static File canFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/Stats/cans.txt");
	static File crateFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/Stats/crate.txt");
	static File glassBottleFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/Stats/glassBttles.txt");
	static File plasticBottleFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/Stats/plasticBttles.txt");
	static File polybagFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/Stats/polyBags.txt");
	static File paperbagFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/Stats/paperBags.txt");

	static PrintWriter writer;

	public static String addCan() 
	{
		System.out.println("Inside add can");
		try
		{
			System.out.println("Inside add try");		
			Scanner sc = new Scanner(canFile);
			totalCans = sc.nextInt();
			totalCans++;
			writer = new PrintWriter(canFile);
			writer.println(totalCans);
			writer.close();
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return "Added";
	}
	public String addCrate() throws FileNotFoundException
	{
		Scanner sc = new Scanner(crateFile);
		totalCrates = sc.nextInt();
		
		totalCrates++;
		writer = new PrintWriter(crateFile);
		writer.println(totalCrates);
		writer.close();
		sc.close();
		return "Added";
	}
	public String addGlassbtl() throws FileNotFoundException
	{
		Scanner sc = new Scanner(glassBottleFile);
		totalGlassBottles = sc.nextInt();
		sc.close();
		totalGlassBottles++;
		writer = new PrintWriter(glassBottleFile);
		writer.println(totalGlassBottles);
		System.out.println("yoyoy");
		writer.close();
		return "Added";
	}
	public String addPaperBags() throws FileNotFoundException
	{
		Scanner sc = new Scanner(paperbagFile);
		totalPaperBags = sc.nextInt();
		totalPaperBags++;
		sc.close();
		writer = new PrintWriter(paperbagFile);
		writer.println(totalPaperBags);
		System.out.println("yoyoy");
		writer.close();
		return "Added";
		
	}
	public String addPlasticBottles() throws FileNotFoundException
	{
		System.out.println("yoyoy");
		Scanner sc = new Scanner(plasticBottleFile);
		
		totalPlasticBags = sc.nextInt();
		totalPlasticBags++;
		writer = new PrintWriter(plasticBottleFile);
		writer.println(totalPlasticBags);
		writer.close();
		sc.close();
		
		return "Added";
	}
	public static String addPolyBags() throws FileNotFoundException
	{
		
		Scanner sc = new Scanner(polybagFile);
		totalPolythenebags = sc.nextInt();
		totalPolythenebags++;
		sc.close();
		System.out.println(totalPolythenebags);
		
		writer = new PrintWriter(polybagFile);
		writer.println(totalPolythenebags);
		writer.close();
		
		return "Added";
	}
	
//	public static void main(String [] args) {
//		System.out.println(totalCans);
//		addCan();
//		System.out.println(totalCans);
//		
//	}

	




}

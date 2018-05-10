package HeadOffice.Stats;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Scanner;

/**
 * This class keeps track of the statistics of the entire system
 * @author devaka
 *
 */
public class StatsHO {


	static int receipts;
	static int numofitems;
	static int totalCans, totalCrates,totalGlassBottles, totalPaperBags, totalPolythenebags, totalPlasticBottles;

	public static int getTotalCans() throws FileNotFoundException {
		Scanner sc = new Scanner(canFile);
		totalCans = sc.nextInt();
		sc.close();
		return totalCans;
	}
	public static int getTotalCrates() throws FileNotFoundException {
		Scanner sc = new Scanner(crateFile);
		totalCrates = sc.nextInt();
		sc.close();
		return totalCrates;
	}
	public static int getTotalGlassBottles() throws FileNotFoundException {
		Scanner sc = new Scanner(glassBottleFile);
		totalGlassBottles = sc.nextInt();
		sc.close();
		return totalGlassBottles;
	}
	public static int getTotalPaperBags() throws FileNotFoundException {
		Scanner sc = new Scanner(paperbagFile);
		totalPaperBags = sc.nextInt();
		sc.close();
		return totalPaperBags;
	}
	public static int getTotalPolythenebags() {
		return totalPolythenebags;
	}
	public static int getTotalPlasticBottle() throws FileNotFoundException {
		Scanner sc = new Scanner(plasticBottleFile);

		totalPlasticBottles = sc.nextInt();
		sc.close();
		return totalPlasticBottles;
	}



	static File canFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/Stats/cans.txt");
	static File crateFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/Stats/crates.txt");
	static File glassBottleFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/Stats/glassBttles.txt");
	static File plasticBottleFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/Stats/plasticBttles.txt");
	static File polybagFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/Stats/polyBags.txt");
	static File paperbagFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/Stats/paperBags.txt");

	static PrintWriter writer;

	public static String addCan() 
	{

		try
		{
	
			Scanner sc = new Scanner(canFile);
			totalCans = sc.nextInt();
			totalCans++;
			writer = new PrintWriter(canFile);
			writer.println(totalCans);
			sc.close();
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

		totalPlasticBottles = sc.nextInt();
		totalPlasticBottles++;
		writer = new PrintWriter(plasticBottleFile);
		writer.println(totalPlasticBottles);
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

	public int getTotal()
	{
		numofitems = totalCans+ totalCrates+totalGlassBottles+ totalPaperBags+ totalPolythenebags+ totalPlasticBottles;
		return numofitems;
	}
	
	public String getUsage() throws FileNotFoundException
	{
	return "Colombo	"+getTotalCans()+"	"+ getTotalCrates()+"	"+getTotalGlassBottles()+"	"+ getTotalPaperBags()+"	"+ getTotalPolythenebags()+"	"+ getTotalPlasticBottle()+"	"+getTotal();
	}
	



//		public static void main(String [] args) throws FileNotFoundException {
//			System.out.println(getTotalCans());
//			addCan();
//			System.out.println(totalCans);
//			
//		}






}

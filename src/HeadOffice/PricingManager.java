package HeadOffice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import org.apache.xmlrpc.XmlRpcClient;

public class PricingManager {

	int Canvalue;
	int Cratevalue;
	int PolytheneBagvalue;
	int PaperBagvalue;
	int PlasticBottlevalue;
	int GlassBottlevalue;
	
	static File statFile = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/prices.txt"); // add the file here
	
	
	public void getPrices()	
	{

	    try {

	        Scanner sc = new Scanner(statFile);

	        
	        Canvalue = Integer.valueOf(sc.nextLine());
	        Cratevalue= Integer.valueOf(sc.nextLine());
	        PolytheneBagvalue= Integer.valueOf(sc.nextLine());
	        PaperBagvalue= Integer.valueOf(sc.nextLine());
	        PlasticBottlevalue = Integer.valueOf(sc.nextLine());
	        GlassBottlevalue = Integer.valueOf(sc.nextLine());
	   
	        sc.close();


	        System.out.println("Got the stuff"+Canvalue);
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	        
	    }
	    
	}
	
	public void changeValue(String item,int newVal) //this method should be called in the Head office Interface to change values
	{
		if(item.equals("Can"))
		{
			Canvalue = newVal;
		}
		else if (item.equals("Crate")) 
		{
			Cratevalue = newVal;
		}
		else if (item.equals("PolytheneBag")) 
		{
			PolytheneBagvalue = newVal;
		}
		else if (item.equals("PaperBag"))
		{
			PaperBagvalue = newVal;
		}
		else if (item.equals("PlasticBottle")) 
		{
			PlasticBottlevalue = newVal;
		}
		else if (item.equals("GlassBottle"))
		{
			GlassBottlevalue = newVal;
		}
	}
	
	public void SaveStats()
	{
		PrintWriter writer;
		try {
			writer = new PrintWriter(new FileOutputStream(statFile));
			
			writer.println(Canvalue);
			writer.println(Cratevalue);
			writer.println(PolytheneBagvalue);
			writer.println(PaperBagvalue);
			writer.println(PlasticBottlevalue);
			writer.println(GlassBottlevalue);
			
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void sendPrices()
	{
		System.out.println("Sending the prices");
		try {
			
			   XmlRpcClient server = new XmlRpcClient("http://localHost:1300/RPC2"); 
			   Vector<String> params = new Vector<String>();
			   params.add(Integer.toString(Canvalue));
//			   params.add(Integer.toString(Cratevalue));
//			   params.add(Integer.toString(PolytheneBagvalue));
//			   params.add(Integer.toString(PaperBagvalue));
//			   params.add(Integer.toString(PlasticBottlevalue));
//			   params.add(Integer.toString(GlassBottlevalue));
			   Object result = server.execute("machine.updatePrices", params);

		        System.out.println("Sending the prices22"+result.toString());
			   System.out.println(result.toString());
			   }
			   
		catch (Exception ex) {
			 
		}
	}

	
}

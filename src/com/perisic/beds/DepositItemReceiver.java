package com.perisic.beds;

/**
 * @author Marc Conrad
 *
 */
public class DepositItemReceiver {
	ReceiptBasis theReceiptBasis = null; 
	PrinterInterface Printer1 = null;
	
	double TotW=0;
	double TotS=0;
	
	int numofRcpts=0;
	
//	int TotW;
//	int TotS;
	public DepositItemReceiver(PrinterInterface pi) {
		super();
		this.Printer1 = pi;
	}
	/**
	 * 
	 */
	public void createReceiptBasis() { 
		theReceiptBasis = new ReceiptBasis(); 
	}
	/**
	 * @param slot
	 */
	public void classifyItem(int slot, double Tw, double Ts) { 
		DepositItem item = null; 
		this.TotW = Tw;
		this.TotS = Ts;
		/**
		 * This method determines the type of the item using the slot the item was inserted into. 
		 */
			if( slot == 1) { 
			
				item = new Can(); 
				RecyclingGUI.JT.setText("A can was added.");
				TotW= (Can.weight+TotW);
				TotS= (Can.size+TotS);
		} 	else if( slot == 2 ) { 
				item = new GlassBottle();
				RecyclingGUI.JT.setText("A glass bottle was added.");
				TotW= (GlassBottle.weight+TotW);
				TotS= (GlassBottle.size+TotS);
		} 	else if ( slot == 3 ) { 
				item = new Crate(); 
				RecyclingGUI.JT.setText("A crate was added.");
				TotW= (Crate.weight+TotW);
				TotS= (Crate.size+TotS);
		} 
		  	else if ( slot == 4 ) { 
				item = new PaperBag(); 
				RecyclingGUI.JT.setText("A paper bag was added.");
				TotW= (PaperBag.weight+TotW);
				TotS= (PaperBag.size+TotS);
		} 
		  	else if (slot == 5){
				 item = new PlasticBottle();
				 RecyclingGUI.JT.setText("A plastic bottle was added.");
				 TotW= (PlasticBottle.weight+TotW);
				 TotS= (PlasticBottle.size+TotS);
		  }
		  	else if (slot==6) {
		  		item = new PolytheneBag();
		  		 RecyclingGUI.JT.setText("A Polythene Bag was added.");
		  		TotW= (PolytheneBag.weight+TotW);
				 TotS= (PolytheneBag.size+TotS);
		  		 
		  	}
		
		if( theReceiptBasis == null ) { 
			createReceiptBasis(); 
		}
		theReceiptBasis.addItem(item); 
	}
	/**
	 * 
	 */
	public void printReceipt() { 
		/**
		 * This method can be called to print the detailed receipt on the current session
		 */
		if(theReceiptBasis!=null)
		{
		String str = theReceiptBasis.computeSum(); 
		Printer1.print(str); 
		clearReceipt(); 
		numofRcpts++;
		}
		else
		{
			Printer1.print("First enter the items to print a receipt.");
		}
	}
	
	/**
	 * This method is used to print warnings on the display
	 * @param errorstr
	 */
	public void printError (String errorstr)
	{
		Printer1.print(errorstr);
	}
	
	public double getTotalW(){
		/**
		 * Simply returns the Total Weight 
		 */
		return TotW;
	}
	
	public double getTotalS(){
		/**
		 * Simply returns the Total Size
		 */
		return TotS;
	}
	
	public int getTotalRcpts()
	{
		return numofRcpts;
	}
	
	public void clearReceipt() {
		theReceiptBasis = null;
		TotW=0;
		TotS=0;
	}
	
	public void removeLastItem()
	{
		DepositItem temp = theReceiptBasis.removeLastItem();
		if(temp!=null)
		{
		if(temp.name=="Plastic Bottle") 
		{
			TotW-=PlasticBottle.weight;
			TotS-=PlasticBottle.size;
		}
		
		else if(temp.name=="Glass Bottle")
		{
			TotW-=GlassBottle.weight;
			TotS-=GlassBottle.size;
		}
		else if (temp.name=="Paper Bag")
		{
			TotW-=PaperBag.weight;
			TotS-=PaperBag.size;
		}
		else if (temp.name=="Crate")
		{
			TotW-=Crate.weight;
			TotS-=Crate.size;
		}
		
		else if(temp.name=="Can")
		{
			TotW-=Can.weight;
			TotS-=Can.size;
		}
		
		else if (temp.name=="Polythene Bag")
		{
			TotW-=PolytheneBag.weight;
			TotS-=PolytheneBag.size;
		}
		
		ConsoleLog.printlog("The last added "+temp.name+" was removed");
		}
		else
		{
			ConsoleLog.printlog("No action executed on Undo");
		}
	}
}

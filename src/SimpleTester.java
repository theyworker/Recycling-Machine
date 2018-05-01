import com.perisic.beds.*;
/**
 * Tests the recycling machine.
 * @author Marc Conrad
 *@version 1.0
 *
 */
public class SimpleTester {
	
	public static void main(String [] args) { 
		/**
		 * This main function is used for simple testing purposes.
		 * @author devaka
		 */
		Display dis = new Display();
		
		CustomerPanel myPanel = new CustomerPanel(dis); 
		myPanel.itemReceived(3);
		myPanel.itemReceived(3);
		myPanel.itemReceived(3);
		myPanel.itemReceived(3);
		myPanel.itemReceived(3);
		myPanel.itemReceived(3);
//		myPanel.itemReceived(2);
//		myPanel.itemReceived(4);
//		myPanel.itemReceived(5);
//		myPanel.itemReceived(5);

		myPanel.printReceipt();
		/**
		 * This is the main method, we have used it here for testing purposes
		 * 
		 *For testing purposes:
		 *1 for Can
		 *2 for Glass Bottle
		 *3 for Crate
		 *4 for Paper Bag
		 *5 forPlastic Bottle
		 */
	}
}

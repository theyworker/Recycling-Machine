package HeadOffice;

import java.util.Vector;

public class rmConnection {

	
	static Vector<recyclingMachine> connection = new Vector<recyclingMachine>();
	
	public void addConnection(recyclingMachine rm) 
	{
		connection.add(rm);
		
	}
}

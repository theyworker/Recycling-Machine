package HeadOffice;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Scanner;

import com.j256.twofactorauth.TimeBasedOneTimePasswordUtil;

public class PasswordManager {

	public String checkEngCredentials(String usrname, String pssword) 
	{
		if(pssword.equals(readPsswdEngDB(usrname)))
		{
			return "Auth";
		}
		else
		{
			return "F";
		}
	}
	public String checkHOCredentials(String usrname, String pssword) 
	{
		if(pssword.equals(readPsswdHODB(usrname)))
		{
			return "Auth";
		}
		else
		{
			return "F";
		}
	}
	
	public String readPsswdEngDB(String usernm)
	{
		File file = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/passwordEngDB.txt");

	    try {

	        Scanner sc = new Scanner(file);

	        while(sc.hasNextLine())
	        {
	        	String[] i = sc.nextLine().split("-");
	        	if(i[0].equals(usernm)) 
	        	{
	        		sc.close();
	        		return i[1];
	        	} 
	        }
	        sc.close();
	        return null;
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	        
	    }
	    return null;
	}

	public String readTwoFAEngDB(String usernm)
	{
		File file = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/passwordEngDB.txt");

	    try {

	        Scanner sc = new Scanner(file);

	        while(sc.hasNextLine())
	        {
	        	String[] i = sc.nextLine().split("-");
	        	if(i[0].equals(usernm)) 
	        	{
	        		sc.close();
	        		return i[2];
	        	} 
	        }
	        sc.close();
	        return null;
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	        
	    }
	    return null;
	}
	
	public String readPsswdHODB(String usernm)
	{
		File file = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/passwordHODB.txt");

	    try {

	        Scanner sc = new Scanner(file);

	        while(sc.hasNextLine())
	        {
	        	String[] i = sc.nextLine().split("-");
	        	if(i[0].equals(usernm)) 
	        	{
	        		sc.close();
	        		return i[1];
	        	} 
	        }
	        sc.close();
	        return null;
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	        
	    }
	    return null;
	}
	
	public String readTwoFAHODB(String usernm)
	{
		File file = new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/passwordHODB.txt");

	    try {

	        Scanner sc = new Scanner(file);

	        while(sc.hasNextLine())
	        {
	        	String[] i = sc.nextLine().split("-");
	        	if(i[0].equals(usernm)) 
	        	{
	        		sc.close();
	        		return i[2];
	        	} 
	        }
	        sc.close();
	        return null;
	    } 
	    catch (FileNotFoundException e) {
	        e.printStackTrace();
	        
	    }
	    return null;
	}
	
	public void addNewHO(String username, String password,String TwoFA) throws FileNotFoundException, UnsupportedEncodingException
	{
		//PrintWriter writer = new PrintWriter("passwordDB.txt", "UTF-8");
		PrintWriter writer = new PrintWriter(new FileOutputStream(new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/passwordHODB.txt"), true));
		//writer.println(username+"-"+password);
		writer.append(username+"-"+password+"-"+TwoFA+"\n");
		writer.close();
	}
	
	public void addNewEng(String username, String password,String TwoFA) throws FileNotFoundException, UnsupportedEncodingException
	{
		//PrintWriter writer = new PrintWriter("passwordDB.txt", "UTF-8");
		PrintWriter writer = new PrintWriter(new FileOutputStream(new File("/home/devaka/workspace/Recycling Machine/src/HeadOffice/passwordEngDB.txt"), true));
		//writer.println(username+"-"+password);
		writer.append(username+"-"+password+"-"+TwoFA+"\n");
		writer.close();
	}
	
	public String getCurrentCode(String usercode) throws GeneralSecurityException 
	{
		return TimeBasedOneTimePasswordUtil.generateCurrentNumberString(usercode);
	}
	
	
	public String checkRemoteTwoFA(String username,String userCode) throws GeneralSecurityException 
	{
		String currentcode = getCurrentCode(readTwoFAEngDB(username));
		
		if(userCode.equals(currentcode)) 
		{
			return "Auth";
		}
		else 
		{
			return "Failed";
		}
		
	}
}

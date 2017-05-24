import java.util.*;
import java.text.*;
import java.io.*;
public class FileHandler
{

  // Read members from file Members.ser
	public ArrayList<Member> ReadMembers()
	{    
      ArrayList<Member> members = null;
      
    	try
    	{

        FileInputStream fileIn = new FileInputStream("Members.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        members = (ArrayList<Member>) in.readObject();

        in.close();
        fileIn.close();

    	}
    	catch (Exception e)
    	{
        	System.out.println("Members not found");
    	}
      return members;
	}

  // Write to file Members.ser
	public void WriteToMembers(ArrayList<Member> members)
	{
    try 
    {
      FileOutputStream fileOut = new FileOutputStream("Members.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(members);
      out.close();
      fileOut.close();

    }
    catch (Exception e)
    {
      System.out.println("Doh!");
      
    }
	}

  // Read from file CompetitiveSwimmers.ser
  public ArrayList<CompetetiveSwimmer> ReadCompetetiveSwimmers()
  {    
      ArrayList<CompetetiveSwimmer> competetiveSwimmers = null;
      
      try
      {

        FileInputStream fileIn = new FileInputStream("CompetetiveSwimmers.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        competetiveSwimmers = (ArrayList<CompetetiveSwimmer>) in.readObject();

        in.close();
        fileIn.close();

      }
      catch (Exception e)
      {
          System.out.println("CompetetiveSwimmers not found");
      }
      return competetiveSwimmers;
  }

  // Write to file CompetetiveSwimmers.ser
  public void WriteToCompetetiveSwimmers(ArrayList<CompetetiveSwimmer> competetiveSwimmers)
  {
    try 
    {
      FileOutputStream fileOut = new FileOutputStream("CompetetiveSwimmers.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(competetiveSwimmers);
      out.close();
      fileOut.close();

    }
    catch (Exception e)
    {
      System.out.println("Doh!");
      
    }
  }

}
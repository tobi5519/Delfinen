import java.util.*;
import java.text.*;
import java.io.*;
public class FileHandler implements Serializable 
{

  // Read members from file Members.ser
	public ArrayList<Member> readMembers()
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
	public void writeToMembers(ArrayList<Member> members)
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
  public ArrayList<CompetitiveSwimmer> readCompetitiveSwimmers()
  {    
      ArrayList<CompetitiveSwimmer> CompetitiveSwimmers = null;
      
      try
      {

        FileInputStream fileIn = new FileInputStream("CompetitiveSwimmers.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        CompetitiveSwimmers = (ArrayList<CompetitiveSwimmer>) in.readObject();

        in.close();
        fileIn.close();

      }
      catch (Exception e)
      {
          System.out.println("CompetitiveSwimmers not found");
      }
      return CompetitiveSwimmers;
  }

  // Write to file CompetitiveSwimmers.ser
  public void writeToCompetitiveSwimmers(ArrayList<CompetitiveSwimmer> CompetitiveSwimmers)
  {
    try 
    {
      FileOutputStream fileOut = new FileOutputStream("CompetitiveSwimmers.ser");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(CompetitiveSwimmers);
      out.close();
      fileOut.close();

    }
    catch (Exception e)
    {
      System.out.println("Doh!");
      
    }
  }

}
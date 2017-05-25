import java.util.*;
import java.io.*;
public class FileHandler implements Serializable 
{

  // Read members from file Members.db
	public ArrayList<Member> readMembers()
	{    
      ArrayList<Member> members = null;
      
    	try
    	{

        FileInputStream fileIn = new FileInputStream("Members.db");
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

  // Write to file Members.db
	public void writeToMembers(ArrayList<Member> members)
	{
    try 
    {
      FileOutputStream fileOut = new FileOutputStream("Members.db");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(members);
      out.close();
      fileOut.close();

    }
    catch (Exception e)
    {
      System.out.println("Can't write to file");
    }
	}

  // Read from file CompetitiveSwimmers.db
  public ArrayList<CompetitiveSwimmer> readCompetitiveSwimmers()
  {    
      ArrayList<CompetitiveSwimmer> CompetitiveSwimmers = null;
      
      try
      {

        FileInputStream fileIn = new FileInputStream("CompetitiveSwimmers.db");
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

  // Write to file CompetitiveSwimmers.db
  public void writeToCompetitiveSwimmers(ArrayList<CompetitiveSwimmer> competitiveSwimmers)
  {
    try 
    {
      FileOutputStream fileOut = new FileOutputStream("CompetitiveSwimmers.db");
      ObjectOutputStream out = new ObjectOutputStream(fileOut);
      out.writeObject(competitiveSwimmers);
      out.close();
      fileOut.close();
    }
    catch (Exception e)
    {
      System.out.println("Can't write to file");
    }
  }
}
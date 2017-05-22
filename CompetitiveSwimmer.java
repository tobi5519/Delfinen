import java.util.ArrayList; 

public class CompetitiveSwimmer extends Member
{

    private ArrayList<Performance> performances = new ArrayList<Performance>();

    
    public CompetitiveSwimmer(String name, int birthyear, String residence)
    {
        super(name, birthyear, residence); 
    }
    
     public ArrayList<Performance> getPerformance()
     {
          return performances;
     }

     public void addPerformance(String location, long time, String dicipline)
     {
         performances.add(new Performance(location, time, dicipline));
     }

     //CompetitiveSwimmer ??

  


}
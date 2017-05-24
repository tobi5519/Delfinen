import java.util.ArrayList; 

public class CompetitiveSwimmer extends Member
{

    private ArrayList<Performance> performances = new ArrayList<Performance>();

    
    public CompetitiveSwimmer(String name, int birthyear, String residence, int id)
    {
        super(name, birthyear, residence, id); 
    }
    
     public ArrayList<Performance> getPerformances()
     {
          return performances;
     }

     public void addPerformance(String location, long time, String dicipline)
     {
         performances.add(new Performance(location, time, dicipline, this.getName(), this.getAge()));
     }

     

  


}
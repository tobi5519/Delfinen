import java.io.*;
public class Performance implements Serializable
{
    private String location;
    private long time;
    private String dicipline;
    private String name;
    private int age;


    public Performance(String location, long time, String dicipline, String name, int age)
    {
        this.location = location;
        this.time = time;
        this.dicipline = dicipline;
        this.name = name;
        this.age = age;
    }

    public String getLocation()
    {
        return location;
    }

    public long getTime()
    {
        return time;
    }

    public String getDicipline()
    {
        return dicipline;
    }

    public String getName()
    {
        return name;
    }
    
    public int getAge()
    {
        return age;
    }

    @Override
    public String toString()
    {
        long min = time/60;
        long sec = time%60;
        String number = "";
        if(sec < 10){
            number = "0";
        }
        return "Name: " + name + " Age: " + age + " Time: " + min + ":"+ number + sec + " Discipline: " + dicipline + " Location: " + location;
    }
}
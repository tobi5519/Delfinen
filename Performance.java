public class Performance
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
        return "Navn: " + name + " " + "alder: " + age + " " + "Tid: " + " " + time + "Diciplin: " + " " + dicipline;
     "sted: " + " " + location;
    }
}
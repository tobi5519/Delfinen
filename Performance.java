public class Performance
{
    private String location;
    private long time;
    private String dicipline;
    private String name;


    public Performance(String location, long time, String dicipline, String name)
    {
        this.location = location;
        this.time = time;
        this.dicipline = dicipline;
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

    @Override
    public String toString()
    {
        return "sted: " + " " + location + " " + "Tid: " + " " + time + "Diciplin: " + " " + dicipline;
    }

}
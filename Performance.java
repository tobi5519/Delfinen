public class Performance
{
    private String location;
    private long time;
    private String dicipline;


    public Performance(String location, long time, String dicipline)
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
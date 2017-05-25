import java.io.*;

public class Member implements Serializable 
{
    private String name;
    private int age;
    private String residence;
    private int id;
    private boolean memberStatus;
    private boolean paymentStatus;

    public Member(String name, int age, String residence, int id)
    {
        this.name = name;
        this.age = age;
        this.residence = residence;
        this.id = id;
    }

    public Member(String name, int age, String residence, int id, boolean paymentStatus)
    {
        this.name = name;
        this.age = age;
        this.residence = residence;
        this.id = id;
        this.paymentStatus = paymentStatus;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public int getAge()
    {
        return age;
    }

    public void setResidence(String residence)
    {
        this.residence = residence;
    }

    public String getResidence()
    {
        return residence;
    }

    public int getID()
    {
        return id;
    }

    public void setMemberStatus(boolean status)
    {
        this.memberStatus = status;
    }

    public boolean getMemberStatus()
    {
        return memberStatus;
    }

    public void setPaymentStatus(boolean status)
    {
        this.paymentStatus = status;
    }

    public boolean getPaymentStatus()
    {
        return paymentStatus;
    }
}
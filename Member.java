public class Member
{
    protected String name;
    protected int age;
    protected String residence;
    protected int id;
    protected boolean memberStatus;
    protected boolean paymentStatus;

    public Member(String name, int age, String residence)
    {
        this.name = name;
        this.age = age;
        this.residence = residence;
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
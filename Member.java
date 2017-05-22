public class Member
{
    protected String name;
    protected int birthyear;
    protected String residence;
    protected int id;
    protected boolean memberStatus;
    protected boolean paymentStatus;

    public Member(String name, int birthyear, String residence)
    {
        this.name = name;
        this.birthyear = birthyear;
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

    public void setBirthYear(int birthyear)
    {
        this.birthyear = birthyear;
    }

    public int getBirthYear()
    {
        return birthyear;
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
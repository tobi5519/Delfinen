public class Member
{
    protected String name;
    protected int birthYear;
    protected String residence;
    protected int id;
    protected boolean memberStatus;
    protected boolean paymentStatus;

    public Member(String name, int birthYear, String residence)
    {
        this.name = name;
        this.birthYear = birthYear;
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

    public void setBirthYear(int birthYear)
    {
        this.birthYear = birthYear;
    }

    public int getBirthYear()
    {
        return birthYear;
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
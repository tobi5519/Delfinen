import java.util.ArrayList;
public class Database
{
	private ArrayList<Member> members = new ArrayList<Member>();
	private ArrayList<CompetitiveSwimmer> competitiveSwimmers = new ArrayList<CompetitiveSwimmer>();
	
	public void printDueMembers()
	{
		for(Member m : members)
		{
			System.out.println(m.getName() + " is overdue");
			
		}

		for(CompetitiveSwimmer cs : competitiveSwimmers)
		{
			System.out.println(cs.getName() + " is overdue");
			
		}

	}

	public void printMembers()
	{
		for(Member m : members)
		{
			System.out.println(m.getName() + " " + m.getBirthYear());
			
		}

		for(CompetitiveSwimmer cs : competitiveSwimmers)
		{
			System.out.println(cs.getName() + " " + cs.getBirthYear());
			
		}

	}

	// Wow much fucked it is.
	// Sorting algorithm
	public void printTopFive()
	{
		ArrayList<CompetitiveSwimmer> topfive = new ArrayList<CompetitiveSwimmer>();
		


		
	}
	
	public void addMember(Member member)
	{
		members.add(member);
	}
	
	public int findMember()
	{
		// prompt for input
	}
	
	public void deleteMember(int memberindex)
	{
		// both member and competitive swimmers?

		members.remove(memberindex);
	}
	
	public Member getMember(int memberindex)
	{
		return members.get(memberindex);
		
	}
	
	public CompetitiveSwimmer getCS(int memberindex)
	{
		return competitiveSwimmers.get(memberindex);
	}
		
}

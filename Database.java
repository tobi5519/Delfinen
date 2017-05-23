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

	public void printTopFive()
	{
		ArrayList<CompetitiveSwimmer> juniorCrawl = new ArrayList<CompetitiveSwimmer>();
		ArrayList<CompetitiveSwimmer> juniorButterfly = new ArrayList<CompetitiveSwimmer>();

		ArrayList<CompetitiveSwimmer> seniorCrawl = new ArrayList<CompetitiveSwimmer>();
		ArrayList<CompetitiveSwimmer> seniorButterfly = new ArrayList<CompetitiveSwimmer>();

		// Sorting the swimmers in arraylists according to agegroup and discipline
		for(CompetitiveSwimmer cs : competitiveSwimmers)
		{
			if (cs.getBirthyear() < 18)
			{
				for(Performance p : cs.getPerformance())
				{
					if(cs.getPerformance().getDicipline().equals("butterfly"))
					{
						juniorButterfly.add(cs);
					}
					else
					{
						juniorCrawl.add(cs);
					}
				}
			}
			else
			{
				for(Performance p : cs.getPerformance())
				{
					if(cs.getPerformance().getDicipline().equals("butterfly"))
					{
						seniorButterfly.add(cs);
					}
					else
					{
						seniorCrawl.add(cs);
					}
				}
			}
		}

		// Sorting each arraylist after 
		sort(juniorButterfly);
		sort(juniorCrawl);
		sort(seniorButterfly);
		sort(seniorCrawl);
		


				
	}

	public void sort(ArrayList<CompetitiveSwimmer> arraylist)
	{
		// Overvej bubble, sort i stedet for quick sort !!!df

		if(arraylist = null || arraylist.size() < 2) return;

		int mid = arraylist.size() / 2;
		long pivot = arraylist.get(mid).getTime();

		// Please Kill Me!



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
		members.remove(memberindex);
	}

	public void deleteCompetitiveSwimmer(int memberindex)
	{
		competitiveSwimmers.remove(memberindex);
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
		
}

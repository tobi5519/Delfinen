import java.util.ArrayList;
import java.util.Collections;
public class Database
{
	private ArrayList<Member> members = new ArrayList<Member>();
	private ArrayList<CompetitiveSwimmer> competitiveSwimmers = new ArrayList<CompetitiveSwimmer>();
	
	public void printDueMembers()
	{
		for(Member m : members)
		{
			if (m.getBirthyear() < 18)
			{
					
			}
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

	public ArrayList<Performance> getAllPerformances()
	{
		ArrayList<Performance> allPerformances = new ArrayList<Performance>();

		for(CompetitiveSwimmer cs : competitiveSwimmers)
		{
			for(Performance p : cs.getPerformances())
			{
				allPerformances.add(p);
			}
									
		}
		return allPerformances;
		
	}
	
	
	public void printTopFive()
	{
		ArrayList<Performance> performances = getAllPerformances();

		ArrayList<Performance> juniorCrawl = new ArrayList<Performance>();
		ArrayList<Performance> juniorButterfly = new ArrayList<Performance>();

		ArrayList<Performance> seniorCrawl = new ArrayList<Performance>();
		ArrayList<Performance> seniorButterfly = new ArrayList<Performance>();

		for(Performance p : performances)
		{
			if (p.getAge() < 18)
			{
				if(p.getDicipline().equals("butterfly"))
				{	
					juniorButterfly.add(p);
				}
				else
				{
					juniorCrawl.add(p);
				}
			}
			else
			{
				if(p.getDicipline().equals("butterfly"))
				{	
					seniorButterfly.add(p);
				}
				else
				{
					seniorCrawl.add(p);
				}
			}
		}

		// Sorting each arraylist after 
		juniorButterfly = sort(juniorButterfly);
		juniorCrawl = sort(juniorCrawl);
		seniorButterfly = sort(seniorButterfly);
		seniorCrawl = sort(seniorCrawl);
		
		for(Performance p : juniorButterfly)
		{	
			System.out.println("= = | Junior performances in butterfly | = =");
			System.out.println(p);
		}
		for(Performance p : juniorCrawl)
		{
			System.out.println("= = | Junior performances in crawl | = =");
			System.out.println(p);
		}
		for(Performance p : seniorButterfly)
		{
			System.out.println("= = | Senior performances in butterfly | = =");
			System.out.println(p);
		}
		for(Performance p : seniorCrawl)
		{
			System.out.println("= = | Senior performances in crawl | = =");
			System.out.println(p);
		}
				
	}

	public ArrayList<Performance> sort(ArrayList<Performance> arraylist)
	{
		if(arraylist = null || arraylist.size() < 2) return;
		Boolean swappedLastTime = true;
		while (swappedLastTime) {
			
			swappedLastTime = false;
			for(int i = 0;i < arraylist.size();i++)
			{
				
				if(arraylist.get(i) > arraylist.get(i+1)
				{
					Collections.swap(ArrayList<Performance> arraylist, i, i+1);
					swappedLastTime = true;
				}

			}
		}
		return arraylist;
	}
	
	
	
	public void addMember(Member member)
	{
		members.add(member);
	}
	
	public int findMember()
	{
		// prompt for input
		return 0;
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
	
	public CompetitiveSwimmer getCompetitiveSwimmer(int memberindex)
	{
		return competitiveSwimmers.get(memberindex);
	}
		}
		
}

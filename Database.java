import java.util.ArrayList;
import java.util.Collections;
public class Database
{
	FileHandler fh = new FileHandler();

	private ArrayList<Member> members = fh.ReadMembers();
	private ArrayList<CompetitiveSwimmer> competitiveSwimmers = fh.ReadCompetetiveSwimmers();

	// private ArrayList<Member> members = new ArrayList<Member>();
	// private ArrayList<CompetitiveSwimmer> competitiveSwimmers = new ArrayList<CompetitiveSwimmer>();
	
	public void save()
	{
		fh.WriteToMembers(members);
		fh.WriteToCompetetiveSwimmers(competitiveSwimmers);
	}
	
	

	public void printDueMembers()
	{
		for(Member m : members)
		{
			if (m.getPaymentStatus() == false)
			{
				if (m.getMemberStatus() == true)
				{
					if (m.getAge() < 18)
					{
						System.out.println("1000 kr. is due");
					}	
					else if(m.getAge() >= 18 && m.getAge() < 60)
					{
						System.out.println("1600 kr. is due");
						
					}
					else
					{
						System.out.println("1200 kr. is due");
						
					}
				}
				else
				{
					System.out.println("500 kr. is due");
					
				}
			}
		}
	}

	public void printDueCompetitiveSwimmers()
	{
		for(CompetitiveSwimmer cs : competitiveSwimmers)
		{
			if (cs.getPaymentStatus() == false)
			{
				if (cs.getMemberStatus() == true)
				{
					if (cs.getAge() < 18)
					{
						System.out.println("1000 kr. is due");
					}	
					else if(cs.getAge() >= 18 && cs.getAge() < 60)
					{
						System.out.println("1600 kr. is due");
						
					}
					else
					{
						System.out.println("1200 kr. is due");
						
					}
				}
				else
				{
					System.out.println("500 kr. is due");
					
				}
			}
		}
	}

	public void printMembers()
	{
		for(Member m : members)
		{
			System.out.println(m.getName() + " " + m.getAge());
			
		}

		for(CompetitiveSwimmer cs : competitiveSwimmers)
		{
			System.out.println(cs.getName() + " " + cs.getAge());
			
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
		if(arraylist.size() < 2)
		{
			return null;
		}

		Boolean swappedLastTime = true;
		while (swappedLastTime) 
		{
			swappedLastTime = false;
			for(int i = 0;i < arraylist.size();i++)
			{
				
				if(arraylist.get(i).getTime() > arraylist.get(i+1).getTime())
				{
					Collections.swap(arraylist, i, i+1); // works without "ArrayList<Performance>"
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
	public void addCompetitiveSwimmer(CompetitiveSwimmer cs)
	{
		competitiveSwimmers.add(cs);
	}
		
	public int[] findMember(String name)
	{
		int[] a = new int[2];
		for(Member m : members)
		{
			if(m.getName().equals(name))
			{			
				System.out.println("Hej fra member");	
				a[0] = 0;
				a[1] = members.indexOf(m);
				return a;
			}
			
		}

		for(CompetitiveSwimmer cs : competitiveSwimmers)
		{
			if(cs.getName().equals(name))
			{
				System.out.println("Hej fra cs member");	
				a[0] = 1;
				a[1] = competitiveSwimmers.indexOf(cs);
				return a;
			}
		}
		
		a[0] = -1;
		return a;
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

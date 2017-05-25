import java.util.ArrayList;
import java.util.Collections;
public class Database
{
	private FileHandler fh = new FileHandler();
	private ArrayList<Member> members;
	private ArrayList<CompetitiveSwimmer> competitiveSwimmers;
	
	public Database(){
		competitiveSwimmers = fh.readCompetitiveSwimmers();
		members = fh.readMembers();
		if(fh.readMembers() == null){
			members = new ArrayList<Member>();
		}
		if(fh.readCompetitiveSwimmers() == null){
			competitiveSwimmers = new ArrayList<CompetitiveSwimmer>();
		}
	}
	
	public void save()
	{
		fh.writeToMembers(members);
		fh.writeToCompetitiveSwimmers(competitiveSwimmers);
	}
	
	public void printDueMembers()
	{
		for(Member m : members)
		{
			if (m.getPaymentStatus() == false)
			{
				System.out.print(m.getName() + ": ");
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
				System.out.print(cs.getName() + ": ");
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
			String status = "Passive";
			if(m.getMemberStatus() == true){
				status = "Active";
			}
			System.out.println(m.getName() + " " + m.getAge() + " Member " + status);
			
		}

		for(CompetitiveSwimmer cs : competitiveSwimmers)
		{
			String status = "Passive";
			if(cs.getMemberStatus() == true){
				status = "Active";
			}
			System.out.println(cs.getName() + " " + cs.getAge() + " Competitive " + status);
			
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
				if(p.getDicipline().equals("Butterfly"))
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
				if(p.getDicipline().equals("Butterfly"))
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

		if(!juniorButterfly.isEmpty()){
			System.out.println("\n= = | Junior performances in butterfly | = =");
			for(int i = 0; i < juniorButterfly.size(); i++){
				System.out.println(juniorButterfly.get(i));
				if(i == 4){
					break;
				}
			}
		}
		
		if(!juniorCrawl.isEmpty()){	
			System.out.println("\n= = | Junior performances in crawl | = =");
			for(int i = 0; i < juniorCrawl.size(); i++){
				System.out.println(juniorCrawl.get(i));
				if(i == 4){
					break;
				}
			}
		}
		
		if(!seniorButterfly.isEmpty()){		
			System.out.println("\n= = | Senior performances in butterfly | = =");
			for(int i = 0; i < seniorButterfly.size(); i++){
				System.out.println(seniorButterfly.get(i));
				if(i == 4){
					break;
				}
			}
		}
		
		if(!seniorCrawl.isEmpty()){
			System.out.println("\n= = | Senior performances in crawl | = =");
			for(int i = 0; i < seniorCrawl.size(); i++){
				System.out.println(seniorCrawl.get(i));
				if(i == 4){
					break;
				}
			}
		}
	}

	public ArrayList<Performance> sort(ArrayList<Performance> arraylist)
	{
		if(arraylist.size() < 2)
		{
			return arraylist;
		}

		Boolean swappedLastTime = true;
		while (swappedLastTime) 
		{
			swappedLastTime = false;
			for(int i = 0; i < arraylist.size() - 1;i++)
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
		
	public void addMember(String name, int age, String residence)
	{
		members.add(new Member(name, age, residence, members.size()+competitiveSwimmers.size()));
	}

	public void addMember(String name, int age, String residence, boolean paymentStatus)
	{
		members.add(new Member(name, age, residence, members.size()+competitiveSwimmers.size(), paymentStatus));
	}

	public void addCompetitiveSwimmer(String name, int age, String residence)
	{
		ArrayList<CompetitiveSwimmer> hej = new ArrayList<CompetitiveSwimmer>();
		competitiveSwimmers.add(new CompetitiveSwimmer(name, age, residence, 
		members.size() + competitiveSwimmers.size() ));
	}
	
	public void addCompetitiveSwimmer(String name, int age, String residence, boolean paymentStatus)
	{
		ArrayList<CompetitiveSwimmer> hej = new ArrayList<CompetitiveSwimmer>();
		competitiveSwimmers.add(new CompetitiveSwimmer(name, age, residence, 
		members.size() + competitiveSwimmers.size(), paymentStatus ));
	}
		
	public int[] findMember(String name)
	{
		int[] a = new int[2];
		for(Member m : members)
		{
			if(m.getName().equals(name))
			{			
				a[0] = 0;
				a[1] = members.indexOf(m);
				return a;
			}
			
		}

		for(CompetitiveSwimmer cs : competitiveSwimmers)
		{
			if(cs.getName().equals(name))
			{
				a[0] = 1;
				a[1] = competitiveSwimmers.indexOf(cs);
				return a;
			}
		}
		
		a[0] = -1;
		return a;
	}
	
	public void deleteMember(int memberIndex)
	{
		members.remove(memberIndex);
	}

	public void deleteCompetitiveSwimmer(int memberIndex)
	{
		competitiveSwimmers.remove(memberIndex);
	}
	
	public Member getMember(int memberIndex)
	{
		return members.get(memberIndex);
		
	}
	
	public CompetitiveSwimmer getCompetitiveSwimmer(int memberIndex)
	{
		return competitiveSwimmers.get(memberIndex);
	}	
}

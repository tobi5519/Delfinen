import java.util.Scanner;
public class UserInput {
    private Scanner scanner;

    public UserInput(){
        this.scanner = new Scanner(System.in);
    }

    public String getLine(){
        return scanner.nextLine();
    }
    
    public String getLine(String prompt){
        System.out.println(prompt + ": ");
        return scanner.nextLine();
    }

    public String waitForEnter(){
        System.out.println("Press enter to return.");
        return scanner.nextLine();
    }

    public String getWord(){
        return scanner.next();
    }

    public Boolean hasNext(){
        return scanner.hasNext();
    }
    
    public int getInt(){
        while(true){
            try{
                int integer = Integer.parseInt(scanner.nextLine());
                return integer;
            } catch (NumberFormatException e){
                System.out.println(">> Not a number, try again.");
            }
        }
    }

    public int getInt(String prompt){
        while(true){
            try{
                System.out.println(prompt + ": ");
                int integer = Integer.parseInt(scanner.nextLine());
                return integer;
            } catch (NumberFormatException e){
                System.out.println(">> Not a number, try again.");
            }
        }
    }

    public long getLong(String prompt){
        while(true){
            try{
                System.out.println(prompt + ": ");
                long number = Long.parseLong(scanner.nextLine());
                return number;
            } catch (NumberFormatException e){
                System.out.println(">> Not a number, try again.");
            }
        }
    }
}
import java.util.Scanner;
public class UserInput {
    private Scanner scanner;

    public UserInput(){
        this.scanner = new Scanner(System.in);
    }

    public String getLine(){
        return scanner.nextLine();
    }

    public String getWord(){
        return scanner.next();
    }

    public Boolean hasNext(){
        return scanner.hasNext();
    }
    
    public int getInt(){
        try{
        int integer = Integer.parseInt(scanner.nextLine());
        return integer;
        } catch (NumberFormatException e){
            System.out.println(">> ikke et tal returnere -1 index out of bounds sikkert: " + e);
        }
        return -1;
    }

}
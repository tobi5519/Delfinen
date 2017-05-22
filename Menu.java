public class Menu{
    private UserInput input = new UserInput();
    private Database db = new Database();

    // Starter method ----------------------------------------------------------------------

    public void start(){
        menuRunner("mainMenu");
    }

    // MENUS -------------------------------------------------------------------------------

    private Boolean mainMenu(){
        String[] menuOptions = {"Main Menu","Accountant Menu","Chairman Menu","Coach Menu"};
        printOptions(menuOptions);
        switch(input.getInt()){
            case 0: 
                return null;
            case 1:
                menuRunner("accountantMenu");
                return true;
            case 2:
                menuRunner("chairmanMenu");
                return true;
            case 3:
                menuRunner("coachMenu");
                return true;
            default: 
                return true;
        }
    }

    private Boolean chairmanMenu(){
        String[] menuOptions = {"Chairman Menu","Add Member","Edit member","Remove Member"};
        printOptions(menuOptions);
        switch(input.getInt()){
            case 0: 
                return null;
            case 1:
                addMemberMenu();
                break;
            case 2:
                db.editMember(db.pickMember());
                break;
            case 3:
                db.deleteMember(db.pickMember());
                break;
            default: 
        }
        return true;
    }

    private Boolean coachMenu(){
        String[] menuOptions = {"Coach Menu","Add Performance"};
        printOptions(menuOptions);
        switch(input.getInt()){
            case 0: 
                return null;
            case 1:
                db.pickCS().addPerformance();
                break;
            default: 
        }
        return true;
    }

    private Boolean accountantMenu(){
        System.out.println("Now viewing members with a due payment!");
        db.printDueMembers();
        return true;
    }

    // Utility methods -------------------------------------------------------------------------------

    private void printOptions(String[] options){
        System.out.println(options[0]);
        System.out.println("Options:");
        System.out.println("0: Go back/exit.");
        for(int i = 1; i < options.length; i++){
            System.out.println(i + ": " + options[i]);
        }
    }

    private void menuRunner(String method){
        Boolean running = true;
        while(running){
            switch(method){
                case "chairmanMenu":
                    running = chairmanMenu();
                    break;
                case "mainMenu":
                    running = mainMenu();
                    break;
                case "accountantMenu":
                    running = accountantMenu();
                    break;
                case "coachMenu":
                    running = coachMenu();
                    break;
            }
        }
    }

    // Actions MÅSKE skal alt dette være i de enkelte klasser?   ---------

    private void addMemberMenu(){
        System.out.println("Adding new member.");

        System.out.println("Name: ");
        String name = input.getLine();
        
        System.out.println("Birthyear: ");
        int birthYear = input.getInt();
        
        System.out.println("Address: ");
        String address = input.getLine();
        
        while(true){
            System.out.println("What kind of swimmer?");
            System.out.println("0: Exit");
            System.out.println("1: Exercise");
            System.out.println("2: Competitive");
            int selection = input.getInt();
        
            if(selection == 1){
                db.addMember(new Member(name, birthYear, address));
                break;
            } else if ( selection == 2){
                // db.addCS(new CompetitiveSwimmer(name, birthYear, address));
                break;
            } else if (selection == 0){
                break;
            } else {
                System.out.println("Wrong selection, try again.");
            }
        }
    }

    private void editMemberMenu(){
            db.findMember();
    }

// NEEDS USING
    private void memberPropertyMenu(){
        String[] options = {"What would you like to edit?", 
                            "Name", 
                            "Birthyear", 
                            "Residence", 
                            "Membership status (Active/Passive)"};
        printOptions(options);
    }

    private void deleteMemberMenu(){
        db.deleteMember(db.findMember());
        
    }
}
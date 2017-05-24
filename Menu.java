public class Menu{
    private UserInput input = new UserInput();
    private Database db = new Database();

    // Starter method ----------------------------------------------------------------------

    public void start(){
        menuRunner("mainMenu");
    }

    // MENUS -------------------------------------------------------------------------------

    private Boolean mainMenu(){
        String[] menuOptions = {"Main Menu",
                                "Chairman Menu",
                                "View members with a due payment",
                                "Coach Menu"};
        printOptions(menuOptions);
        switch(input.getInt()){
            case 0: 
                return false;
            case 1:
                menuRunner("chairmanMenu");
                return true;
            case 2:
                menuRunner("accountantMenu");
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
                return false;
            case 1:
                addMember();
                break;
            case 2:
                editMember(chooseMember("edit"));
                break;
            case 3:
                deleteMember(chooseMember("delete"));
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
                return false;
            case 1:
                //add performance
                break;
            default: 
        }
        return true;
    }

    private Boolean accountantMenu(){
        System.out.println("Now viewing members with a due payment!");
        db.printDueMembers();
        return false;
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

    private void addMember(){
        System.out.println("Adding new member.");
        String name = input.getLine("Name");
        int birthYear = input.getInt("Birth year");
        String address = input.getLine("Address");
        while(true){
            if(chooseSwimType(name, birthYear, address)){
                break;
            }
        }
    }

    private Boolean chooseSwimType(String name, int birthYear, String address){
            String[] options = {"What kind of swimmer?", "Exercise", "Competitive"};
            printOptions(options);
            int selection = input.getInt();
            if(selection == 1){
                db.addMember(new Member(name, birthYear, address));
                return true;
            } else if ( selection == 2){
                db.addCompetitiveSwimmer(new CompetitiveSwimmer(name, birthYear, address));
                return true;
            } else if (selection == 0) {
                System.out.println("Exiting, no member added.");
                return true;
            } else {
                System.out.println("No member added, try again.");
                return false;
            }
    }

    private Member chooseMember(String actionToDo){
            System.out.println("What member would you like to " + actionToDo + "?");
            int[] memberIndex = db.findMember(input.getLine("Name"));
            Member placeholder = null;
            if(memberIndex[0] == 0){
                placeholder = db.getMember(memberIndex[1]);
            } else if (memberIndex[0] == 1){
                placeholder = db.getCompetitiveSwimmer(memberIndex[1]);
            } else if (memberIndex[0] == -1){
                System.out.println("Member not found");
            }
            return placeholder;
    }

    private CompetitiveSwimmer chooseCompetitiveSwimmer(String actionToDo){
            System.out.println("What member would you like to " + actionToDo + "?");
            int[] memberIndex = db.findMember(input.getLine("Name"));
            CompetitiveSwimmer placeholder = null;
            if(memberIndex[0] == 0){
                System.out.println("Not a competitive swimmer");
            } else if (memberIndex[0] == 1){
                placeholder = db.getCompetitiveSwimmer(memberIndex[1]);
            } else if (memberIndex[0] == -1){
                System.out.println("Member not found");
            }
            return placeholder;
    }

    private void editMember(Member placeholder){
            if(placeholder != null){
                Boolean running = true;
                while(running){
                    switch( chooseProperty(
                            placeholder.getName(), 
                            placeholder.getAge(), 
                            placeholder.getResidence(), 
                            placeholder.getMemberStatus()) ) 
                            {
                                case 0:
                                    running = false;
                                    break;
                                //name
                                case 1:
                                    placeholder.setName(input.getLine("Name"));
                                    break;
                                //age
                                case 2:    
                                    int birthYear = 2017 - input.getInt("Age");
                                    placeholder.setAge(birthYear);
                                    break;
                                //residence
                                case 3:    
                                    placeholder.setResidence(input.getLine("Residence/Address"));
                                    break;
                                //membership
                                case 4:    
                                    if(placeholder.getMemberStatus() == true){
                                        placeholder.setMemberStatus(false);
                                        System.out.println("Setting membership to Passive..");
                                    } else {
                                        placeholder.setMemberStatus(true);
                                        System.out.println("Setting membership to Active..");
                                    }
                                    break;
                            }
                    }
            }
    }

    private int chooseProperty(String name, int birthYear, String residence, Boolean membership){
        String membershipTitle = "Passive";
        if(membership){
            membershipTitle = "Active";
        }
        int age = 2017 - birthYear;
        String[] options = {"What would you like to edit?", 
                            "Name: " + name, 
                            "Age: " + age, 
                            "Residence: " + residence, 
                            "Membership status (Active/Passive): " + membershipTitle};
        printOptions(options);
        return input.getInt();
    }
    

    private void deleteMember(Member placeholder){
        if(placeholder != null){
            String delete = "Do you want to delete " + placeholder.getName() + " (y/n)?";
            if(input.getLine(delete).toLowerCase().contains("y")){
                int[] location = db.findMember(placeholder.getName());
                if(location[0] == 0){
                    db.deleteMember(location[1]);
                } else if (location[0] == 1){
                    db.deleteCompetitiveSwimmer(location[1]);
                }
            }
        }
    }

    private void addPerformance(){
        // public Performance(String location, long time, String dicipline, String name, int age)
        String location = null;
        String dicipline = null;
        System.out.println("Adding performance.");
        String[] options = {"Choose a Swimtype", "Crawl", "Butterfly"};
        long time = 0;
        
        printOptions(options);
        switch(input.getInt()){
            case 0:
            break;
            case 1:
                dicipline = "Crawl";
            break;
            case 2:
                dicipline = "Butterfly";
            break;
            default:
            break;
            
        }

        if(dicipline != null){
            location = input.getLine("Location");
            time = input.getLong("Time in seconds");
            Member placeholder = null;
            while(placeholder == null){
                placeholder = chooseMember("add the performance to");
                if(placeholder == null){
                    if(input.getLine("Not a member, try again?").toLowerCase().contains("n")){
                        break;
                    }
                } else {
                    placeholder.addPerformance(location, time, dicipline);
                    int sec = time%60;
                    int min = time/60;
                    System.out.println(dicipline + " performance; "+ min + ":" + sec +" in " + location + " added to " + placeholder.getName() + "'s records.");
                }
            }
        }
    }
}
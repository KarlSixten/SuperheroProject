package main;
import comparator.*;
import java.io.IOException;
import java.util.Scanner;

public class UserInterface  {
    Database superheroDatabase = new Database();
    private Controller controller = new Controller(superheroDatabase);
    private Filehandler filehandler = new Filehandler();

    public UserInterface() throws IOException {
        controller.setSuperheroArrayList(filehandler.loadData());
    }

    //Create scanner called input
    Scanner input = new Scanner(System.in);
    boolean uiIsrunning = true;

    public void startProgram(){
        while (uiIsrunning){
            showMainMenu();
            //Tilføjer to superheros til test af f.eks. søgning i lister
            //controller.addSuperhero("Batman", "Bruce Wayne", "Badass", 1966, true, 62);
            //controller.addSuperhero("Superman", "Vides ikke", "Ikke lige så sej", 1951, true, 84);

            switch (input.nextInt()){
                case 1 -> addSuperhero();
                case 2 -> showSuperheros();
                case 3 -> searchSuperhero();
                case 4 -> editSuperhero();
                case 5 -> deleteSuperhero();
                case 6 -> saveSuperheros();
                case 9 -> exitProgram();
                default -> System.out.println("Enter valid number");
            }

        }
    }
    private void showMainMenu(){
        System.out.println("Welcome to the superhero database. \n" +
                "1. Create new superhero. \n" +
                "2. Show superheroes. \n" +
                "3. Find superhero. \n" +
                "4. Edit superhero.\n" +
                "5. Delete superhero.\n" +
                "6. Save superheros.\n" +
                "9. End");
    }

private void sortAfterSuperheroName(){
        controller.getSuperheroesArrayList().sort(new SuperheroNameComparator());
    System.out.println("Data sorted after superheroname");
}
private void sortAfterRealName(){
        controller.getSuperheroesArrayList().sort(new SuperheroRealNameComparator());
    System.out.println("Data sorted after superheroes real name");
}
private void sortAfterSuperpower(){
        controller.getSuperheroesArrayList().sort(new SuperheroSuperpoweComparator());
}
private void sortAfterIsHuman(){
        controller.getSuperheroesArrayList().sort(new SuperheroIsHumanComparator());
}
private void sortAfterYearCreated(){
        controller.getSuperheroesArrayList().sort(new SuperheroYearCreatedComparator());
}
private void sortAfterStrength(){
        controller.getSuperheroesArrayList().sort(new SuperheroStrengthComparator());
}

    private void addSuperhero() {
        System.out.println("What is the superheros superhero name?");
        input.nextLine(); //reset af scanneren - håndtering af scanner bug
        String superheroName = input.nextLine();
        System.out.println("What is the superheros real name?");
        String realName = input.nextLine();
        System.out.println("What is the superheros superpower?");
        String superpower = input.nextLine();
        System.out.println("When was this superhero created?");
        int yearCreated = input.nextInt();
        System.out.println("Is the superhero human? y/n");
        boolean isHuman = false;
        if (input.next().equalsIgnoreCase("y")) {
            isHuman = true;
        }
        System.out.println("What is the superheros strength? [1-100]");
        int strength = input.nextInt();

        controller.addSuperhero(superheroName, realName, superpower, yearCreated, isHuman, strength);
        saveSuperheros();
    }

    private void showSuperheros() {
        if (controller.getSuperheroesArrayList().isEmpty()) {
            System.out.println("There are no superheroes in the database.");
        } else {
            System.out.println("How would you like to sort the superheros?\n" +
                    "1. kea.Superhero Name.\n" +
                    "2. Real name.\n" +
                    "3. Superpower.\n" +
                    "4. Year created.\n" +
                    "5. If the superhero is human.\n" +
                    "6. Their strength.");
            switch (input.nextInt()) {
                case 1 -> sortAfterSuperheroName();
                case 2 -> sortAfterRealName();
                case 3 -> sortAfterSuperpower();
                case 4 -> sortAfterYearCreated();
                case 5 -> sortAfterIsHuman();
                case 6 -> sortAfterStrength();
                default -> System.out.println("Please enter a valid number!");
            }


            System.out.println("""
                    ------------------------
                    Superheroes in database:
                    ------------------------""");
            for (Superhero superhero : controller.getSuperheroesArrayList()) {
                System.out.println(superhero + "\n----------------------------");
            }
        }
    }

    private void searchSuperhero() {
        StringBuilder stringBuilder = new StringBuilder();
        System.out.println("Search for name or part of superheros name: ");
        String stringToSearchFor = input.nextLine();
        stringToSearchFor = input.nextLine(); //Ekstra input linje pga. scanner bug.
            for (Superhero superhero : controller.searchSuperhero(stringToSearchFor)) {
                if (superhero.getSuperheroName().contains(stringToSearchFor)) {
                    stringBuilder.append(controller.getSearchMatches().indexOf(superhero) + 1);
                    stringBuilder.append(". ");
                    stringBuilder.append(superhero.getSuperheroName());
                    stringBuilder.append("\n");
                }
            }
            if (controller.getSearchMatches().isEmpty()) {
                System.out.println("No superheros found :(");
            } else {
                System.out.println("Superheros found!: \n" + stringBuilder.toString());
            }
        }

        private void editSuperhero() {
            //Asks the user which superhero to edit, and converts it into index for ArrayList
            System.out.println(controller.printSuperheroNames());
            System.out.println("Select the superhero you'd like to edit: ");
            int indexOfSuperheroToEdit = input.nextInt() - 1;

            //Asks the user which attribute they'd like to edit and converts to int for switch case
            System.out.println("What would you like to edit?");
            System.out.println(controller.getSuperheroesArrayList().get(indexOfSuperheroToEdit).printSuperheroAttributesIndexed());
            int attributeToEdit = input.nextInt();

            //Asks the user for the new value, input is taken in later method call
            System.out.println("New value:");
            input.nextLine(); //Scanner bug

            switch (attributeToEdit) {
                case 1, 2, 3 -> controller.editSuperhero(indexOfSuperheroToEdit, attributeToEdit, input.nextLine());
                case 4, 6 -> controller.editSuperhero(indexOfSuperheroToEdit, attributeToEdit, input.nextInt());
                case 5 -> controller.editSuperhero(indexOfSuperheroToEdit, attributeToEdit, input.nextBoolean());
                default -> System.out.println("What");
            }
            saveSuperheros();
        }


    private void deleteSuperhero() {
        int count = 1;
        try {
            if (controller.getSuperheroesArrayList().isEmpty()) {
                System.out.println("There are no superheroes in the database.");
            } else {
                System.out.println("""
                        ------------------------
                        Superheroes in database:
                        ------------------------""");
                for (Superhero superhero : controller.getSuperheroesArrayList()) {
                    System.out.println(count + ". " + superhero.getSuperheroName() + "\n");
                    count++;
                }
                System.out.println("Select the kea.Superhero you want to delete from the database: ");
                controller.deleteSuperhero(input.nextInt() - 1);
                System.out.println("The superhero was deleted.");
                saveSuperheros();
            }
        } catch (Exception e) {
            System.out.println("Error, try again!");
        }
    }

    private void saveSuperheros() {
        filehandler.saveSuperheroes(controller.getSuperheroesArrayList());
        System.out.println("All superheros have been saved.");
    }

    private void exitProgram() {
        uiIsrunning = false;
        System.out.println("Exiting...");
    }
}
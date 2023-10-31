import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInterface {
    Database superheroDatabase = new Database();
    private Controller controller = new Controller(superheroDatabase);
    //Create scanner called input
    Scanner input = new Scanner(System.in);

    public void startProgram() {
        //Tilføjer to superheros til test af f.eks. søgning i lister
        controller.addSuperhero("Batman", "Bruce Wayne", "Badass", 1966, true, 62);
        controller.addSuperhero("Superman", "Vides ikke", "Ikke lige så sej", 1951, true, 84);
        int userChoice = -1;
        while (userChoice != 9) {
            try {
                System.out.println("Welcome to the superhero database.\n" +
                        "1. Create new superhero.\n" +
                        "2. Show superheroes.\n" +
                        "3. Find superhero.\n" +
                        "4. Edit superhero.\n" +
                        "5. Delete superhero.\n" +
                        "9. End");
                userChoice = input.nextInt();
                handleUserChoice(userChoice);
            } catch (InputMismatchException e) {
                System.out.println("Error enter valid number, try again");
                input.nextLine(); //reset af scanneren - håndtering af scanner bug
            }
        }
    }

    public void handleUserChoice(int userChoice) {
        if (userChoice == 1)
            addSuperhero();
        else if (userChoice == 2)
            showSuperheros();
        else if (userChoice == 3)
            searchSuperhero();
        else if (userChoice == 4)
            editSuperhero();
        else if (userChoice == 5)
            deleteSuperhero();
        else if (userChoice == 9)
            System.exit(0);
        else System.out.println("Error, enter valid number");
    }

    public void addSuperhero() {
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
    }

    public void showSuperheros() {
        if (controller.getSuperheroesArrayList().isEmpty()) {
            System.out.println("There are no superheroes in the database.");
        } else {
            System.out.println("""
                    ------------------------
                    Superheroes in database:
                    ------------------------""");
            for (Superhero superhero : controller.getSuperheroesArrayList()) {
                System.out.println(superhero + "\n----------------------------");
            }
        }
    }

    public void searchSuperhero() {
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

        public void editSuperhero() {
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
        }


    public void deleteSuperhero() {
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
                System.out.println("Select the Superhero you want to delete from the database: ");
                controller.deleteSuperhero(input.nextInt() - 1);
                System.out.println("The superhero was deleted.");
            }
        } catch (Exception e) {
            System.out.println("Error, try again!");
        }
    }
}
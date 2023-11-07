package main;
import java.io.IOException;
import java.util.*;

public class UserInterface {
    private Controller controller;

    public UserInterface() throws IOException {
        this.controller = new Controller();
    }

    //Create scanner called input
    Scanner input = new Scanner(System.in);
    boolean uiIsrunning = true;

    public void startProgram(){
        while (uiIsrunning){
            showMainMenu();
          try {
              switch (input.nextInt()){
                  case 1 -> addSuperhero();
                  case 2 -> showSuperheros();
                  case 3 -> searchSuperhero();
                  case 4 -> editSuperhero();
                  case 5 -> deleteSuperhero();
                  case 6 -> saveSuperheros();
                  case 7 -> simpleSort();
                  case 8 -> advancedSort();
                  case 9 -> exitProgram();
                  default -> System.out.println("Enter valid number");
              }
          }catch (InputMismatchException e){
              System.out.println("Invalid input, try again");
                input.nextLine(); // reset af scanner bug
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
                "7. Sort by attribute.\n" +
                "8. Sort by two attributes.\n" +
                "9. End");
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
        System.out.println(controller.showSuperheros());
    }

    private void searchSuperhero() {
        System.out.println("Search for name or part of superheros name: ");
        input.nextLine(); //Scanner bug
        System.out.println(controller.searchSuperhero(input.nextLine()));
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
        System.out.println(controller.printSuperheroNamesWithIndex());
        System.out.println("Select the superhero you want to delete:");
        try {
            controller.deleteSuperhero(input.nextInt());
            System.out.println("The superhero has been deleted from the database.");
            saveSuperheros();
        } catch (InputMismatchException|IndexOutOfBoundsException e) {
            System.out.println("Invalid selection!\nTry again!");
            input.nextLine();
            deleteSuperhero();

            /*controller.deleteSuperhero(input.nextInt());
            System.out.println("The superhero has been deleted from the database \n");
            saveSuperheros();*/
        }
    }

    private void saveSuperheros() {
        controller.saveSuperheros();
        System.out.println("All superheroes have been saved.");
    }

    private void simpleSort() {
        System.out.println("How would you like to sort the superheros?\n");
        printAttributesListed();
        int userSelection = input.nextInt();
        switch (userSelection) {
            case 1, 2, 3, 4, 5, 6 -> controller.simpleSort(userSelection);
            default -> System.out.println("Invalid input.");
        }
    }


    private void advancedSort() {
        int primarySort;
        int secondarySort;

        System.out.println("Select the primary sorting method");
        printAttributesListed();
        primarySort = input.nextInt();
        while (!(primarySort > 0 && primarySort < 7)) {
            System.out.println("Invalid input! Try again:");
            primarySort = input.nextInt();
        }

        System.out.println("Select the secondary sorting method:");
        printAttributesListed();
        secondarySort = input.nextInt();
        while (!(secondarySort > 0 && secondarySort < 7)) {
            System.out.println("Invalid input! Try again:");
            secondarySort = input.nextInt();
        }
        controller.advancedSort(primarySort, secondarySort);
    }

    private boolean inputIsValid(int minimumInput, int maximumInput, int actualInput) {
        //Måske overflødig?
        return actualInput >= minimumInput && actualInput <= maximumInput;
    }
    private void printAttributesListed(){
        System.out.println("\n1. Superhero Name.\n" +
                        "2. Real name.\n" +
                        "3. Superpower.\n" +
                        "4. Year created.\n" +
                        "5. If the superhero is human.\n" +
                        "6. Their strength.");
    }

    private void exitProgram() {
        uiIsrunning = false;
        System.out.println("Exiting...");
    }
}
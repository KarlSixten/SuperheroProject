package main;

import java.io.IOException;
import java.util.*;

public class UserInterface {
    private final Controller controller;
    Scanner input = new Scanner(System.in);
    boolean uiIsrunning = true;

    public UserInterface() throws IOException {
        this.controller = new Controller();
    }

    public void startProgram(){
        while (uiIsrunning){
            showMainMenu();
            switch (takeUserInput()){
                case 1 -> addSuperhero();
                case 2 -> showSuperheros();
                case 3 -> searchSuperhero();
                case 4 -> editSuperhero();
                case 5 -> deleteSuperhero();
                case 6 -> saveSuperheros();
                case 7 -> simpleSort();
                case 8 -> advancedSort();
                case 9 -> exitProgram();
                default -> System.out.println("Enter valid number.");
            }
        }
    }
    private void showMainMenu(){
        System.out.println("""
                Welcome to the superhero database.\s
                1. Create new superhero.\s
                2. Show superheroes.\s
                3. Find superhero.\s
                4. Edit superhero.
                5. Delete superhero.
                6. Save superheros.
                7. Sort by attribute.
                8. Sort by two attributes.
                9. End""");
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
        boolean isHuman = input.next().equalsIgnoreCase("y");
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
        int indexOfSuperheroToEdit = takeUserInput() - 1;

        //Asks the user which attribute they'd like to edit and converts to int for switch case
        System.out.println("What would you like to edit?");
        System.out.println(controller.printSuperheroAttributesIndexed(indexOfSuperheroToEdit));
        int attributeToEdit = takeUserInput();

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

        int userSelection = takeUserInput();

        while (!inputIsValid(1, controller.getNumberOfSuperherosInDatabase(), userSelection)) {
            System.out.println("Invalid selection! Try again:");
            userSelection = takeUserInput();
        }
        System.out.println("The superhero has been deleted from the database.");
        saveSuperheros();
    }

    private void saveSuperheros() {
        controller.saveSuperheros();
        System.out.println("All superheroes have been saved.\n");
    }

    private void simpleSort() {
        System.out.println("How would you like to sort the superheros?");
        controller.simpleSort(selectSortMethod());
        System.out.println("The superheros have been sorted.\n");
    }

    private void advancedSort() {
        int primarySort;
        int secondarySort;

        List<Integer> availableSortOptions = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6)); // Create a list of available options

        System.out.println("Select the primary sorting method");
        printAttributesListed();

        primarySort = input.nextInt();

        while (!availableSortOptions.contains(primarySort)) {
            System.out.println("Invalid input! Try again:");
            primarySort = input.nextInt();
        }

        availableSortOptions.remove(Integer.valueOf(primarySort)); // Remove the primary sort option

        System.out.println("Select the secondary sorting method:");
        printAvailableAttributes(availableSortOptions);

        secondarySort = input.nextInt();

        while (!availableSortOptions.contains(secondarySort)) {
            System.out.println("Invalid input! Try again:");
            secondarySort = input.nextInt();
        }

        controller.advancedSort(primarySort, secondarySort);
    }

    private boolean inputIsValid(int minimumInput, int maximumInput, int actualInput) {
        return actualInput >= minimumInput && actualInput <= maximumInput;
    }

    private int selectSortMethod() {
        printAttributesListed();
        int userSelection = takeUserInput();

        while (!inputIsValid(1, 6, userSelection)) {
            System.out.println("Invalid input! Try again:");
            userSelection = takeUserInput();
        }
        return userSelection;
    }

    private void printAttributesListed(){
        System.out.println("""

                1. Superhero Name.
                2. Real name.
                3. Superpower.
                4. Year created.
                5. If the superhero is human.
                6. Their strength.""");
    }

    private int takeUserInput() {
        String inputString = input.nextLine();
        int inputInt = 0;

        try {
            inputInt = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Try again:");
            inputInt = takeUserInput();
        }
        return inputInt;
    }

    private void exitProgram() {
        uiIsrunning = false;
        System.out.println("Exiting...");
    }
    private void printAvailableAttributes(List<Integer> availableOptions) {
        System.out.println("Available options for secondary sort:");

        for (int option : availableOptions) {
            switch (option) {
                case 1:
                    System.out.println("1. Real name.");
                    break;
                case 2:
                    System.out.println("2. Superpower.");
                    break;
                case 3:
                    System.out.println("3. Year created.");
                    break;
                case 4:
                    System.out.println("4. If the superhero is human.");
                    break;
                case 5:
                    System.out.println("5. Their strength.");
                    break;
            }
        }
    }
}
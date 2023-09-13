import java.util.Scanner;

public class Main {
    private Controller controller;
    //Create scanner called input
    Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        Main m = new Main();
        // konfiguration af system
        Database superheroDatabase = new Database();
        m.controller = new Controller(superheroDatabase);
        m.startProgram();
    }

    public void startProgram() {

        //Tilføjer to superheros til test af f.eks. søgning i lister
        controller.addSuperhero("Batman", "Bruce Wayne", "Badass", 1966, true, 62);
        controller.addSuperhero("Superman", "Vides ikke", "Ikke lige så sej", 1951, true, 84);

        int userChoice = -1;
        while (userChoice != 9) {
            System.out.println("Welcome to the superhero database.\n1. Create new superhero.\n2. Show superheroes.\n3. Find superhero.\n9. End");

            userChoice = input.nextInt();
            input.nextLine(); //Håndtering af bug
            handleUserChoice(userChoice);
        }
    }

    public void handleUserChoice(int userChoice) {
        if (userChoice == 1)
            addSuperhero();
        else if (userChoice == 2)
            showSuperheros();
        else if (userChoice == 3)
            searchSuperhero();
        else System.out.println("error");
    }


    public void addSuperhero() {
        System.out.println("What is the superheros superhero name?");
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
        if (controller.getSuperheroesArrayList().size() == 0) {
            System.out.println("There are no superheroes in the database.");
        } else {
            System.out.println("Superheroes in database:");
            for (Superhero superhero : controller.getSuperheroesArrayList()) {
                System.out.println(superhero);
            }
        }

    }

    public void searchSuperhero() {
        System.out.println("Search for name or part of superheros name: ");
        System.out.println(controller.searchSuperhero(input.nextLine()));


    }


}


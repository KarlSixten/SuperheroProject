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
        String newuserChoice;
        int userChoice = -1;
        while (userChoice != 9) {
            try {
                System.out.println("Welcome to the superhero database.\n1. Create new superhero.\n2. Show superheroes.\n3. Find superhero.\n4. Edit super hero.\n9. End");
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
            System.out.println("----------------------------\n" +
                    "Superheroes in database:\n" +
                    "----------------------------");
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
        int indexToEdit;
        searchSuperhero();

        while (controller.getSearchMatches().isEmpty()) {
            searchSuperhero();
        }

        System.out.println("Select the superhero you want to edit: ");

        indexToEdit = input.nextInt() - 1;

        System.out.println("Select the attribute you want to edit: ");
        System.out.println("1. Superhero name: " + controller.getSearchMatches().get(indexToEdit).getSuperheroName());
        System.out.println("2. Name: " + controller.getSearchMatches().get(indexToEdit).getRealName());
        System.out.println("3. Superpower: " + controller.getSearchMatches().get(indexToEdit).getSuperpower());
        System.out.println("4. Year created: " + controller.getSearchMatches().get(indexToEdit).getYearCreated());
        System.out.println("5. Is human: " + controller.getSearchMatches().get(indexToEdit).getIsHuman());
        System.out.println("6. Strength: " + controller.getSearchMatches().get(indexToEdit).getStrength());

        try {
            switch (input.nextInt()) {
                case (1):
                    System.out.println("Enter new superhero name: ");
                    input.nextLine();
                    controller.getSuperheroesArrayList().get(indexToEdit).setSuperheroName(input.nextLine());
                    System.out.println("The new data for the superhero:\n" + controller.getSuperheroesArrayList().get(indexToEdit));
                    break;

                case (2):
                    System.out.println("Enter new real name: ");
                    input.nextLine();
                    controller.getSuperheroesArrayList().get(indexToEdit).setRealName(input.nextLine());
                    System.out.println("The new data for the superhero:\n" + controller.getSuperheroesArrayList().get(indexToEdit));
                    break;

                case (3):
                    System.out.println("Indtast ny superpower: ");
                    input.nextLine();
                    controller.getSuperheroesArrayList().get(indexToEdit).setSuperpower(input.nextLine());
                    System.out.println("The new data for the superhero:\n" + controller.getSuperheroesArrayList().get(indexToEdit));
                    break;

                case (4):
                    System.out.println("Enter new year of creation: ");
                    input.nextLine();
                    controller.getSuperheroesArrayList().get(indexToEdit).setYearCreated(input.nextInt());
                    System.out.println("The new data for the superhero:\n" + controller.getSuperheroesArrayList().get(indexToEdit));
                    break;

                case (5):
                    System.out.println("Is the superhero human: ");
                    boolean isHuman = false;
                    if (input.next().equalsIgnoreCase("y")) {
                        isHuman = true;
                        input.nextLine();
                        controller.getSuperheroesArrayList().get(indexToEdit).setIsHuman(isHuman);
                        System.out.println("The new data for the superhero:\n" + controller.getSuperheroesArrayList().get(indexToEdit));
                        break;
                    }
                case (6):
                    System.out.println("Put new strength [1-100]: ");
                    input.nextLine();
                    controller.getSuperheroesArrayList().get(indexToEdit).setStrength(input.nextInt());
                    System.out.println("The new data for the superhero:\n" + controller.getSuperheroesArrayList().get(indexToEdit));
                    break;


                default:
                    //ugyldigt valg
                    System.out.println("Error, incompatibale choice");
                    break;
            }

        } catch (Exception e) {
            System.out.println("Error must enter a valid number");
            input.nextLine();
            controller.getSuperheroesArrayList().get(indexToEdit).setStrength(input.nextInt());
            System.out.println("New data of the superhero: \n" + controller.getSuperheroesArrayList().get(indexToEdit));


        }

    }

    public void deleteSuperhero() {
        int count = 1;
        int indexToDelete;
        if (controller.getSuperheroesArrayList().isEmpty()) {
            System.out.println("There are no superheroes in the database.");
        } else {
            System.out.println("----------------------------\n" +
                    "Superheroes in database:\n" +
                    "----------------------------");
            for (Superhero superhero : controller.getSuperheroesArrayList()) {
                System.out.println(count + ". " + superhero.getSuperheroName() + "\n");
                count++;
            }
        }
        System.out.println("Select the Superhero you want to delete from the database: ");
        controller.getSuperheroesArrayList().remove(input.nextInt() - 1);

    }
}


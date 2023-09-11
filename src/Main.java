import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //Create scanner called input
        Scanner input = new Scanner(System.in);
        //Initialise variable to check for users choice
        int userChoice;
        //Create new Database object
        Database superheroDatabase = new Database();

        //Introduction print lines
        System.out.println("Welcome to the superhero universe!");

        do {
            System.out.println("1. Create superhero \n9. Exit.");
            //Asks user what they want to do
            userChoice = input.nextInt();
            if (userChoice == 1) {
                //Adds new superhero to database
                superheroDatabase.addSuperhero();
            }
            else if (userChoice == 9) {
                System.out.println("Exiting.");
            }
            else {
                //Error message
                System.out.println("Error");
            }
        }

        while (userChoice != 9);
    }
}

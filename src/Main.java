import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Opret et Scanner objekt til at læse input fra brugeren
        Scanner scanner = new Scanner(System.in);

        // Opret et Database objekt
        Database database = new Database();

        // Vis menuen
        showMenu(scanner);

        // Luk programmet
        System.exit(0);
    }

    private static void showMenu(Scanner scanner) {
        // Vis menuen
        System.out.println("Vælg en handling:");
        System.out.println("1. Opret en ny superhelt");
        System.out.println("2. Afslut programmet");

        // Læs brugerens valg
        int choice = scanner.nextInt();

        // Udfør den valgte handling
        switch (choice) {
            case 1:
                // Opret en ny superhelt
                createSuperhero(scanner, new Database());
                break;
            case 2:
                // Afslut programmet
                System.exit(0);
            default:
                // Ugyldigt valg
                System.out.println("Ugyldigt valg.");
                break;
        }
    }

    private static void createSuperhero(Scanner scanner, Database database) {
    }
}
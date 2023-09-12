import  java.util.ArrayList;
import java.util.Scanner;

public class Database {
    //Create scanner called input
    Scanner input = new Scanner(System.in);
    //Create new Arraylist with initial capacity of 1
    private ArrayList<Superhero> superheroesArrayList = new ArrayList<Superhero>(1);

    public void addSuperhero() {
        //Get info about superhero to add
        System.out.println("What is the superheros superhero name?");
        String superheroName = input.nextLine();
        System.out.println("What is the superheros real name?");
        String realName = input.nextLine();
        System.out.println("What is the superheros superpower?");
        String superpower = input.nextLine();
        System.out.println("When was this superhero created?");
        int yearCreated = input.nextInt();
        System.out.println("Is the superhero human? true/false");
        boolean isHuman = input.nextBoolean();
        System.out.println("What is the superheros strength? int");
        int strength = input.nextInt();

        //Creates a new superhero object and adds to index 0 of superheroesArrayList
        superheroesArrayList.add(0, (new Superhero(superheroName, realName, superpower, yearCreated, isHuman, strength)));

        //Test printlinje
        System.out.println(superheroesArrayList.get(0));
    }
}

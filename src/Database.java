import  java.util.ArrayList;
import java.util.Scanner;

public class Database {
    //Create scanner called input
    Scanner input = new Scanner(System.in);
    //Create new Arraylist with initial capacity of 1
    private ArrayList<Superhero> superheroesArrayList = new ArrayList<Superhero>(1);

    public ArrayList<Superhero> getSuperheroesArrayList() {
        return superheroesArrayList;
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int yearCreated, boolean isHuman, int strength) {
        //Creates a new superhero object and adds to index 0 of superheroesArrayList
        superheroesArrayList.add(0, (new Superhero(superheroName, realName, superpower, yearCreated, isHuman, strength)));
    }

    public String searchSuperhero(String stringToSearchFor) {
        String result = "";
        for (Superhero superhero : superheroesArrayList) {
            if (superhero.getSuperheroName().contains(stringToSearchFor)) {
                result = "Superhero found: " + superhero.getToString();
                break;
            } else {
                result = "No super heroes found";
            }
        }
        return result;
    }
}


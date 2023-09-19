import  java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Database {
    //Create scanner called input
    Scanner input = new Scanner(System.in);
    //Create new Arraylist with initial capacity of 1
    private ArrayList<Superhero> superheroesArrayList = new ArrayList<Superhero>(1);
    private ArrayList<Superhero> searchMatches = new ArrayList<Superhero>();

    public ArrayList<Superhero> getSuperheroesArrayList() {
        return superheroesArrayList;

        }
    public ArrayList<Superhero> getSearchMatches(){
        return searchMatches;
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int yearCreated, boolean isHuman, int strength) {
        //Creates a new superhero object and adds to index 0 of superheroesArrayList
        superheroesArrayList.add(0, (new Superhero(superheroName, realName, superpower, yearCreated, isHuman, strength)));
    }


    public ArrayList<Superhero> searchSuperhero(String stringToSearchFor) {
        searchMatches.clear();
        for (Superhero superhero : superheroesArrayList) {
            if (superhero.getSuperheroName().contains(stringToSearchFor)) {
                searchMatches.add(superhero);
            }
        }
        return searchMatches;
    }

    public void editSuperhero(int numberToEdit){

    }
    public void deleteSuperhero (){

    }
}
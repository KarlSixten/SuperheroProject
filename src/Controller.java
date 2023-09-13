import java.util.ArrayList;

public class Controller {
    private Database superheroDatabase;

    public Controller(Database superheroDatabase) {
        this.superheroDatabase = superheroDatabase;
    }

    public void addSuperhero(String superheroName, String realName, String superpower, int yearCreated, boolean isHuman, int strength) {
        superheroDatabase.addSuperhero(superheroName, realName, superpower, yearCreated, isHuman, strength);

    }
    public ArrayList<Superhero> getSuperheroesArrayList(){
        return superheroDatabase.getSuperheroesArrayList();
    }

    public String searchSuperhero(String stringToSearchFor) {
        return superheroDatabase.searchSuperhero(stringToSearchFor);
    }


}
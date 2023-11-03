import main.Database;
import main.Superhero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Superhero s1;
    Superhero s2;
    Superhero s3;
    Database database;

    @BeforeEach
    void setUp() {
        database = new Database();

    }

    @AfterEach
    void tearDown() {
        database = null;
    }


    @Test
    //Tilføjer yderligere en superhelt udover de to hardcodede i databasen. Tester om expectedSize og størrelsen på min superheroesArraylist() er lige store.
    void addSuperhero() {
        //Arrange
        s1 = new Superhero("Spiderman", "Aner det ikke","Edderkoppesværd", 1990, true, 1000);
        s2 = new Superhero("Ironman", "Vides ikke","Jern", 1980, true, 300);
        s3 = new Superhero("Superman", "Clark Kent", "Laser", 1983, true, 183);
        database.getSuperheroesArrayList().addAll(List.of(s1,s2,s3));
        int expectedSize = database.getSuperheroesArrayList().size() + 1;

        //Act
        database.addSuperhero("Holger", "Rune", "Tennisketsjer",2000, true, 7);

        //Assert
        assertEquals(expectedSize, database.getSuperheroesArrayList().size());

    }
    @Test
    void getSearchMatchesWithOne() {
        s1 = new Superhero("Spiderman", "Aner det ikke","Edderkoppesværd", 1990, true, 1000);
        database.getSuperheroesArrayList().add(s1);
        //Arrange
        String expectedName = "Spiderman";

        //Act
        String actualName = s1.getSuperheroName();
        //Assert
        assertEquals(expectedName, actualName);
    }
    @Test

    void editSuperhero(){

    }
    @Test
    void deleteSuperhero(){
        int expectedSize = database.getSuperheroesArrayList().size();
        s1 = new Superhero("Spiderman", "Aner det ikke","Edderkoppesværd", 1990, true, 1000);
        database.getSuperheroesArrayList().add(s1);
        database.getSuperheroesArrayList().remove(s1);
        int actualSize  = database.getSuperheroesArrayList().size();


        assertEquals(expectedSize, actualSize);
    }
    @Test
    void deleteNewSuperhero(){
        s1 = new Superhero("Spiderman", "Aner det ikke","Edderkoppesværd", 1990, true, 1000);
        database.getSuperheroesArrayList().add(s1);

        boolean expectedResult = database.getSearchMatches().isEmpty();
        database.getSuperheroesArrayList().remove(s1);
        database.searchSuperhero(s1.getSuperheroName());
        boolean actualResult = database.getSearchMatches().isEmpty();

        assertEquals(expectedResult, actualResult);
    }
}
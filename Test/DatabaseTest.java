import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
    Superhero s1;
    Superhero s2;
    Database database;

    @BeforeEach
    void setUp() {
        //arrange
        database = new Database();
        s1 = new Superhero("Spiderman", "Aner det ikke","Edderkoppesværd", 1990, true, 1000);
        s2 = new Superhero("Ironman", "Vides ikke","Jern", 1980, true, 300);
        //act
        database.getSuperheroesArrayList().addAll(List.of(s1,s2));

    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getSearchMatches() {

    }

    @Test
    //Tilføjer yderligere en superhelt udover de to hardcodede i databasen. Tester om expectedSize og størrelsen på min superheroesArraylist() er lige store.
    void addSuperhero() {
        //Arrange
        int expectedSize = 3;
        //Act
        database.addSuperhero("Holger", "Rune", "Tennisketsjer",2000, true, 7);
        //assert
        assertEquals(expectedSize, database.getSuperheroesArrayList().size());
    }
}
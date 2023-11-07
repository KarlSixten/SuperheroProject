package comparator;
import main.Superhero;
import java.util.Comparator;

public class SuperheroYearCreatedComparator implements Comparator <Superhero> {

    @Override
    public int compare(Superhero superhero1, Superhero superhero2) {
        if (superhero1.getYearCreated() > superhero2.getYearCreated()) {
            return 1;
        }
        else if (superhero1.getYearCreated() < superhero2.getYearCreated()) {
            return -1;
        }
        else return 0;


    }
}
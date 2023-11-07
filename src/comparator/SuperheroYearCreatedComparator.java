package comparator;

import main.Superhero;
import java.util.Comparator;

public class SuperheroYearCreatedComparator implements Comparator <Superhero> {
    @Override
    public int compare(Superhero superhero1, Superhero superhero2) {
        return Integer.compare(superhero1.getYearCreated(), superhero2.getYearCreated());
    }
}